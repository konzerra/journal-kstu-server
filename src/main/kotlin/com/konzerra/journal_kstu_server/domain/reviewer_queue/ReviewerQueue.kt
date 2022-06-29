package com.konzerra.journal_kstu_server.domain.reviewer_queue

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
class ReviewerQueue(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,

    @OneToOne
    var category:Category,

    @OneToMany
    var list: MutableList<Reviewer> = mutableListOf()
) : EntityI {

}