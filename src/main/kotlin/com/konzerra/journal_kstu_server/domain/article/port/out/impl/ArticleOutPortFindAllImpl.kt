
package com.konzerra.journal_kstu_server.domain.article.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAll
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.ArticleRepository


@OutPort
class ArticleOutPortFindAllImpl(
    private val repository: ArticleRepository
): OutPortFindAll<Article> {
    override fun findAll(): List<Article> {
        return repository.findAll()
    }

}
  