package com.konzerra.journal_kstu_server.domain.user.port.out.crud_impl

import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.UserRepository
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAll

@OutPort
class UserOutPortFindAllImpl(
    private val repository: UserRepository
): OutPortFindAll<AppUser> {
    override fun findAll(): List<AppUser> {
        return repository.findAll()
    }

}