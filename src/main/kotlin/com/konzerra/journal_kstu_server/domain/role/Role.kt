package com.konzerra.journal_kstu_server.domain.role

import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server._generic.data.EntityI
import javax.persistence.*

@Entity
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id:Long? = null,
    @Column(unique = true)
    var name:String,
    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH])
    var appUsers:MutableSet<AppUser> = mutableSetOf()
) : EntityI {
}