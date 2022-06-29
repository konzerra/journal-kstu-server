package com.konzerra.journal_kstu_server.domain.article.article_data

import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
class ArticleData(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null,

    var lang: String,

    @Type( type = "org.hibernate.type.TextType")
    var name: String = "no translation",

    @Type( type = "org.hibernate.type.TextType")
    var authors: String = "no translation",


    @Type( type = "org.hibernate.type.TextType")
    var annotation: String = "no translation",

    @Type( type = "org.hibernate.type.TextType")
    var tags: String = "no translation",
) {
}