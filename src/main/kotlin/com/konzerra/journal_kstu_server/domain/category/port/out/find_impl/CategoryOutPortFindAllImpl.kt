
package com.konzerra.journal_kstu_server.domain.category.port.out.find_impl

import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.CategoryRepository
    
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAll

@OutPort
class CategoryOutPortFindAllImpl(
    private val repository: CategoryRepository
): OutPortFindAll<Category> {
    override fun findAll(): List<Category> {
        return repository.findAll()
    }

}
  