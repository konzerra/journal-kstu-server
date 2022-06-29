
package com.konzerra.journal_kstu_server.domain.article.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortDeleteById
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.ArticleRepository


@OutPort
class ArticleOutPortDeleteByIdImpl(
private val repository: ArticleRepository
) : OutPortDeleteById<Article, Long> {
  override fun execute(id: Long) {
      repository.deleteById(id)
  }
}
  