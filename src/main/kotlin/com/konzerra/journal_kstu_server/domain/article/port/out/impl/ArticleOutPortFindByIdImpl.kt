
package com.konzerra.journal_kstu_server.domain.article.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.ArticleRepository
import com.konzerra.journal_kstu_server.exception.ResourceNotFoundException
    


@OutPort
class ArticleOutPortFindByIdImpl(
    private val repository: ArticleRepository
): OutPortFindById<Article, Long> {
    override fun execute(id: Long): Article {
        return repository.findById(id).orElseThrow {
            ResourceNotFoundException(
                className = Article::class.simpleName ?: "className",
                fieldName = Article::id.name,
                fieldValue = id
            )
        }


    }
}
  