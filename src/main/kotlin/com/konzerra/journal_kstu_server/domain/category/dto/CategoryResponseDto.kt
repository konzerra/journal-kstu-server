
package  com.konzerra.journal_kstu_server.domain.category.dto


import  com.konzerra.journal_kstu_server.domain.category.Category
    

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.util.Mapper
import org.springframework.stereotype.Component


class CategoryResponseDto(
    var id:Long? = null,
    var name:String,
    var overview:String
) : ResponseDtoI
{
    @Component
    companion object : Mapper<Category, CategoryResponseDto> {
        override fun toResponseDto(entity: Category,lang:String): CategoryResponseDto {
            val data = entity.dataByLanguage(lang)
            return  CategoryResponseDto(
                id= entity.id,
                name = data.name,
                overview = data.overview
            )
        }
    }

}
    