package com.konzerra.journal_kstu_server.domain.reviewer

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.user.AppUser
import javax.persistence.*

@Entity
class Reviewer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,

    @OneToOne(fetch = FetchType.LAZY)
    var appUser:AppUser,

    var active:Boolean,

    @OneToOne
    var category:Category,

    @OneToMany
    var articles:MutableSet<Article> = mutableSetOf()


) : EntityI{
}