package com.konzerra.journal_kstu_server.domain.article.usecase.update_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.ArticleStatus
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleUpdateByReviewerDto
import com.konzerra.journal_kstu_server.domain.article.usecase.ArticleUseCaseUpdateByReviewer
import com.konzerra.journal_kstu_server.domain.doc.Doc
import com.konzerra.journal_kstu_server.exception.ResourceNotFoundException
import org.springframework.web.multipart.MultipartFile

@UseCase
class ArticleUseCaseUpdateByReviewerImpl(
    private val articleOutPortFindById:OutPortFindById<Article, Long>,
    private val articleOutPortSave: OutPortSave<Article>
) : ArticleUseCaseUpdateByReviewer {

    override fun execute(updateDto: ArticleUpdateByReviewerDto, reviewerBlankFile: MultipartFile?) {
        val article = articleOutPortFindById.execute(updateDto.id)

        //if reviewer skipped article
        if(updateDto.status == ArticleStatus.SkippedByModerator.toString()){
            article.reviewer = null
            article.status = ArticleStatus.InModeration.toString()
            articleOutPortSave.execute(article)
            return
        }

        if(reviewerBlankFile == null){
            throw RuntimeException()
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
        //If reviewer accepted article
        if(updateDto.status == ArticleStatus.AcceptedByModerator.toString()){
            //send email

        }
        //If reviewer rejected article
        if(updateDto.status == ArticleStatus.RejectedByModerator.toString()){
            //send email

        }




    }
}