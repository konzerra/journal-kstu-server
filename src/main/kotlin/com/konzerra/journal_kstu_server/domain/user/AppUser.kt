package com.konzerra.journal_kstu_server.domain.user

import com.konzerra.journal_kstu_server.domain.role.Role
import com.konzerra.journal_kstu_server._generic.data.EntityI
import javax.persistence.*


@Entity
class AppUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,
    var name:String,
    @Column(unique = true)
    var email:String,
    var password:String,
    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.REFRESH])
    var roles:MutableSet<Role> = mutableSetOf()
): EntityI {

}