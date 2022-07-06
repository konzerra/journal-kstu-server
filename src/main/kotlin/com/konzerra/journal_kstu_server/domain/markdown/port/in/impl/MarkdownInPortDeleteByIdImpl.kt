package com.konzerra.journal_kstu_server.domain.markdown.port.`in`.impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortDeleteById
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseDeleteById
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.markdown.Markdown
import com.konzerra.journal_kstu_server.domain.markdown.MarkdownApi
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable


@InPort
class MarkdownInPortDeleteByIdImpl(
    private val markdownUseCaseDeleteById: UseCaseDeleteById<Markdown,Long>
) : InPortDeleteById<Markdown,Long>{
    @DeleteMapping(MarkdownApi.deleteById)
    override fun execute(@PathVariable id: Long): Any {
        markdownUseCaseDeleteById.execute(id)
        return ResponseEntity<Any>(HttpStatus.OK)
    }

}