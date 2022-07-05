package com.konzerra.journal_kstu_server.domain.reviewer_queue

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import javax.persistence.*

@Entity
class ReviewerQueue(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,

    @OneToOne
    var category:Category,

    @OneToMany(mappedBy="queue", fetch = FetchType.LAZY, )
    var list: MutableList<Reviewer> = mutableListOf()
) : EntityI {

}