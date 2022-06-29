
package com.konzerra.journal_kstu_server.domain.article.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.ArticleRepository


@OutPort
class ArticleOutPortSaveImpl(
    private val repository: ArticleRepository
): OutPortSave<Article> {
    override fun execute(entity:Article) {
        repository.save(entity)
    }

}
  