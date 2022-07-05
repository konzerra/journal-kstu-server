
package com.konzerra.journal_kstu_server.domain.article.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.ArticleStatus
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleSaveDto
import com.konzerra.journal_kstu_server.domain.article.usecase.ArticleUseCaseSave
import com.konzerra.journal_kstu_server.domain.doc.Doc
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.user.AppUser
import org.springframework.web.multipart.MultipartFile


@UseCase
class ArticleUseCaseSaveImpl(
    private val outPortSave: OutPortSave<Article>,
    private val appUserOutPortFindById:OutPortFindById<AppUser,Long>,
    private val journalOutPortFindById: OutPortFindById<Journal,Long>
) : ArticleUseCaseSave{
    override fun execute(saveDto: ArticleSaveDto, file: MultipartFile) {
        val doc = Doc(
            name = file.name,
            mimeType = file.contentType ?: "application/octet-stream",
            content = file.bytes
        )
        val article = Article(
            status = ArticleStatus.Registered.toString(),
            owner = appUserOutPortFindById.execute(saveDto.ownerId),
            dataList = saveDto.dataList,
            journal = journalOutPortFindById.execute(saveDto.journalId),
            wordDoc = doc
        )
        outPortSave.execute(article)
    }

}
    