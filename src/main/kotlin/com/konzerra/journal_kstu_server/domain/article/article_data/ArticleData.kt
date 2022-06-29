package com.konzerra.journal_kstu_server.domain.article.article_data

import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
class ArticleData(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null,

    var lang: String,


    @Column(length=4096)
    var name: String = "no translation",

    @Column(length=8192)
    var authors: String = "no translation",


    @Column(length=8192)
    var annotation: String = "no translation",

    @Column(length=4096)
    var tags: String = "no translation",
) {
}