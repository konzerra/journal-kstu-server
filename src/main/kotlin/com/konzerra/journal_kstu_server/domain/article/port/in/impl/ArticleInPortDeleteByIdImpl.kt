
package com.konzerra.journal_kstu_server.domain.article.port.`in`.impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortDeleteByIdAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseDeleteById
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.ArticleApiPath


import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@InPort
class  ArticleInPortDeleteByIdImpl(
    override val useCaseDeleteById: UseCaseDeleteById<Article, Long>
) : InPortDeleteByIdAbstractImpl<Article, Long>()
{
    @DeleteMapping(ArticleApiPath.deleteByIdPath)
    override fun execute(@PathVariable id: Long): ResponseEntity<*> {
        useCaseDeleteById.execute(id)
        return ResponseEntity<Any>(HttpStatus.OK)
    }
}
    