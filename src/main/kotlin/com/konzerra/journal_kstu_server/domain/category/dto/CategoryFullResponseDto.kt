package com.konzerra.journal_kstu_server.domain.category.dto

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.category_data.CategoryData
import org.springframework.stereotype.Component

class CategoryFullResponseDto(
    var id:Long? = null,
    var dataList:List<CategoryData> = emptyList()
):ResponseDtoI {
    @Component
    companion object : Mapper<Category, CategoryFullResponseDto> {
        override fun toResponseDto(entity: Category, lang:String): CategoryFullResponseDto {
            return  CategoryFullResponseDto(
                id= entity.id,
                dataList = entity.dataList
            )
        }
    }
}