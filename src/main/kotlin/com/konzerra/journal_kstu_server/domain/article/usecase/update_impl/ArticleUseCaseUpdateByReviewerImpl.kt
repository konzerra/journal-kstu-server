package com.konzerra.journal_kstu_server.domain.article.usecase.update_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.common.MailService
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.ArticleStatus
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleUpdateByReviewerDto
import com.konzerra.journal_kstu_server.domain.article.usecase.ArticleUseCaseUpdateByReviewer
import com.konzerra.journal_kstu_server.domain.doc.Doc
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import com.konzerra.journal_kstu_server.exception.BadRequestException
import com.konzerra.journal_kstu_server.exception.ResourceNotFoundException
import org.springframework.web.multipart.MultipartFile

@UseCase
class ArticleUseCaseUpdateByReviewerImpl(
    private val articleOutPortFindById:OutPortFindById<Article, Long>,
    private val articleOutPortSave: OutPortSave<Article>,
    private val reviewerOutPortSave: OutPortSave<Reviewer>,
    private val mailService: MailService
) : ArticleUseCaseUpdateByReviewer {

    override fun execute(updateDto: ArticleUpdateByReviewerDto, reviewerBlankFile: MultipartFile?) {
        val article = articleOutPortFindById.execute(updateDto.id)

        //if reviewer skipped article
        if(updateDto.status == ArticleStatus.SkippedByReviewer.toString()){

            detachArticleFromReviewer(article)
            article.reviewer = null
            article.status = ArticleStatus.InModeration.toString()


            articleOutPortSave.execute(article)
            return
        }

        if(reviewerBlankFile == null){
            throw BadRequestException("Нет бланка рецензента")
        }

        val reviewerBlank = Doc(
            name = reviewerBlankFile.name,
            mimeType = reviewerBlankFile.contentType ?: "application/octet-stream",
            content = reviewerBlankFile.bytes
        )

        article.status = updateDto.status
        article.reviewerComment = updateDto.comment
        article.reviewerBlankDoc = reviewerBlank
        articleOutPortSave.execute(article)
        detachArticleFromReviewer(article)

        try{
            //If reviewer accepted article
            if(updateDto.status == ArticleStatus.AcceptedByReviewer.toString()){
                mailService.sendEmail(
                    "Пуликация статьи в журнал 'Известия им.И. Раззакова' ",
                    "Ваша статья была принята рецензентом (см. ниже комментарий) \n\n${updateDto.comment}",
                    article.owner.email
                )
            }
            //If reviewer rejected article
            if(updateDto.status == ArticleStatus.RejectedByReviewer.toString()){
                mailService.sendEmail(
                    "Пуликация статьи в журнал 'Известия им.И. Раззакова' ",
                    "Ваша статья была отклонена рецензентом (см. ниже комментарий) \n\n${updateDto.comment}",
                    article.owner.email
                )
            }
        }catch (e: Exception){
            //do something
        }





    }
    private fun detachArticleFromReviewer(article:Article){
        article.reviewer?.let {reviewer->
            reviewer.articles.removeIf{
                it.id == article.id
            }
            reviewerOutPortSave.execute(reviewer)
        }
    }
}