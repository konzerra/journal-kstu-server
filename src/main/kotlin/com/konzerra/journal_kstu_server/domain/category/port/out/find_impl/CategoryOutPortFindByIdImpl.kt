
package com.konzerra.journal_kstu_server.domain.category.port.out.find_impl

import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.CategoryRepository
import com.konzerra.journal_kstu_server.exception.ResourceNotFoundException
    
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById

@OutPort
class CategoryOutPortFindByIdImpl(
    private val repository: CategoryRepository
): OutPortFindById<Category, Long> {
    override fun execute(id: Long): Category {
        return repository.findById(id).orElseThrow {
            ResourceNotFoundException(
                className = Category::class.simpleName ?: "className",
                fieldName = Category::id.name,
                fieldValue = id
            )
        }


    }
}
  