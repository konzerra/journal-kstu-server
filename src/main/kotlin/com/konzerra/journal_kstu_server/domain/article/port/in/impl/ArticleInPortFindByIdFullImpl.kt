
package com.konzerra.journal_kstu_server.domain.article.port.`in`.impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortFindByIdFullAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindByIdFull
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.article.ArticleApiPath
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleFullResponseDto

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@InPort
class ArticleInPortFindByIdFullImpl(
    override val useCaseFindByIdFull: UseCaseFindByIdFull<ArticleFullResponseDto, Long>
) : InPortFindByIdFullAbstractImpl<Long, ArticleFullResponseDto>() {
    @GetMapping(ArticleApiPath.findByIdFull)
    override fun execute(@PathVariable id: Long): Any {
        return ResponseEntity(useCaseFindByIdFull.execute(id), HttpStatus.OK)
    }


}
    