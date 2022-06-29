
package com.konzerra.journal_kstu_server.domain.category.port.out.impl

import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.CategoryRepository
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave

@OutPort
class CategoryOutPortSaveImpl(
    private val repository: CategoryRepository,
): OutPortSave<Category> {
    override fun execute(entity: Category) {
        repository.save(entity)
    }

}
  