package com.konzerra.journal_kstu_server.domain.category

import com.konzerra.journal_kstu_server.domain.category.category_data.CategoryData
import com.konzerra.journal_kstu_server._generic.data.EntityI
import javax.persistence.*

@Entity
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,

    @OneToMany(cascade = [CascadeType.ALL])
    var dataList:List<CategoryData> = emptyList()
) : EntityI {
    fun dataByLanguage(lang:String): CategoryData {
        var categoryData = CategoryData(lang = lang)
        dataList.find {
            it.lang == lang
        }?.let {
            categoryData=it
        }
        return categoryData
    }
}