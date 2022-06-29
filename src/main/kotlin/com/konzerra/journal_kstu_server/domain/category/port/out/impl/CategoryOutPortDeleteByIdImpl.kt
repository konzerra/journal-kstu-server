
package com.konzerra.journal_kstu_server.domain.category.port.out.impl

import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.CategoryRepository
    
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortDeleteById

@OutPort
class CategoryOutPortDeleteByIdImpl(
private val repository: CategoryRepository
) : OutPortDeleteById<Category, Long> {
  override fun execute(id: Long) {
      repository.deleteById(id)
  }
}
  