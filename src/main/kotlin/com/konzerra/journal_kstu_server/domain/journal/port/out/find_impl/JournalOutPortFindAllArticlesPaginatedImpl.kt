package com.konzerra.journal_kstu_server.domain.journal.port.out.find_impl

import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.ArticleRepository
import com.konzerra.journal_kstu_server.domain.journal.port.out.JournalOutPortFindAllArticlesPaginated
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

@OutPort
class JournalOutPortFindAllArticlesPaginatedImpl(
    private val repository: ArticleRepository
) : JournalOutPortFindAllArticlesPaginated {
    override fun execute(journalId: Long, pageNumber: Int, pageSize: Int): Page<Article> {
        val pageable = PageRequest.of(pageNumber,pageSize, Sort.unsorted())
        return repository.findArticlesByJournalIdIs(journalId,pageable)
    }
}