package com.konzerra.journal_kstu_server.domain.journal.port.out

import com.konzerra.journal_kstu_server.domain.article.Article
import org.springframework.data.domain.Page

interface JournalOutPortFindAllArticlesPaginated {
    fun execute(journalId:Long,pageNumber:Int,pageSize:Int): Page<Article>
}