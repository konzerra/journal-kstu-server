
package com.konzerra.journal_kstu_server.domain.category.port.`in`.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.CategoryApiPath
    
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortDeleteByIdAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseDeleteById

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@InPort
class  CategoryInPortDeleteByIdImpl(
    override val useCaseDeleteById: UseCaseDeleteById<Category, Long>
) : InPortDeleteByIdAbstractImpl<Category, Long>()
{
    @DeleteMapping(CategoryApiPath.deleteByIdPath)
    override fun execute(@PathVariable id: Long): ResponseEntity<*> {
        useCaseDeleteById.execute(id)
        return ResponseEntity<Any>(HttpStatus.OK)
    }
}
    