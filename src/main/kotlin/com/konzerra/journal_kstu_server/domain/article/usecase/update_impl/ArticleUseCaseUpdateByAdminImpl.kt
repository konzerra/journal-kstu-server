package com.konzerra.journal_kstu_server.domain.article.usecase.update_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleUpdateDtoByAdmin
import com.konzerra.journal_kstu_server.domain.article.usecase.ArticleUseCaseUpdateByAdmin
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.doc.Doc
import com.konzerra.journal_kstu_server.domain.journal.Journal
import org.springframework.web.multipart.MultipartFile

@UseCase
class ArticleUseCaseUpdateByAdminImpl(
    private val outPortSave: OutPortSave<Article>,
    private val outPortFindById: OutPortFindById<Article,Long>,
    private val journalOutPortFindById: OutPortFindById<Journal,Long>,
    private val categoryOutPortFindById: OutPortFindById<Category,Long>

) : ArticleUseCaseUpdateByAdmin {
    override fun execute(
        updateDto: ArticleUpdateDtoByAdmin,
        wordFile: MultipartFile?,
        pdfFile: MultipartFile?
    ) {
        val wordDoc = wordFile?.let {
            Doc(
                name = it.name,
                mimeType = it.contentType ?: "application/octet-stream",
                content = it.bytes
            )
        }
        val pdfDoc = pdfFile?.let {
            Doc(
                name = it.name,
                mimeType = it.contentType ?: "application/octet-stream",
                content = it.bytes
            )
        }
        val article = outPortFindById.execute(updateDto.id)
        article.status = updateDto.status

        updateDto.pagesInJournal?.let{
            article.pagesInJournal = it
        }
        updateDto.journalId?.let {
            article.journal = journalOutPortFindById.execute(it)
        }
        println("categoryId: "+updateDto.categoryId)
        updateDto.categoryId?.let {
            article.category = categoryOutPortFindById.execute(it)
        }
        updateDto.antiplagiat?.let{
            article.antiplagiat = it
        }

        wordDoc?.let {
            article.wordDoc = it
        }
        pdfDoc?.let{
            article.pdfDoc = it
        }
        article.dataList = updateDto.dataList
        outPortSave.execute(article)
    }
}