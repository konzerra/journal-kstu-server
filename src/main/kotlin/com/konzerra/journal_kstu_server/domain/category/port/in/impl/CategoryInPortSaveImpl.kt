
package com.konzerra.journal_kstu_server.domain.category.port.`in`.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.dto.CategorySaveDto
import com.konzerra.journal_kstu_server.domain.category.CategoryApiPath
    
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortSaveAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseSave

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@InPort
class CategoryInPortSaveImpl(
    override val useCaseInPortSave: UseCaseSave<CategorySaveDto>
) : InPortSaveAbstractImpl<Category, Long, CategorySaveDto>() {

    @PostMapping(CategoryApiPath.savePath)
    override fun execute(@RequestBody saveDto: CategorySaveDto): ResponseEntity<*> {
        useCaseInPortSave.execute(saveDto)
        return ResponseEntity<Any>(HttpStatus.CREATED)
    }
}
    