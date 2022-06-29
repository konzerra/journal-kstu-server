package com.konzerra.journal_kstu_server.domain.category.category_data

import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
class CategoryData(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,

    var lang:String,

    var name:String = "no translation",

    @Column(columnDefinition = "TEXT")
    var overview : String = "no translation",

) {
}