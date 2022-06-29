package com.konzerra.journal_kstu_server.domain.article.article_data

import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
class ArticleData(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var lang: String,


    @Column(columnDefinition = "TEXT")
    var name: String = "no translation",

    @Column(columnDefinition = "TEXT")
    var authors: String = "no translation",


    @Column(columnDefinition = "TEXT")
    var annotation: String = "no translation",

    @Column(columnDefinition = "TEXT")
    var tags: String = "no translation",
) {
}