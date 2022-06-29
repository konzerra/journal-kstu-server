package com.konzerra.journal_kstu_server.domain.category.port.out.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAllPaginated
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.CategoryRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

@OutPort
class CategoryOutPortFindAllPaginated(
    private val repository: CategoryRepository
) : OutPortFindAllPaginated<Category> {
    override fun execute(pageNumber: Int, pageSize: Int): Page<Category> {
        val pageable = PageRequest.of(pageNumber,pageSize, Sort.unsorted())
        return repository.findAll(pageable)
    }

}