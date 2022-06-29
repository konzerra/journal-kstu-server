package com.konzerra.journal_kstu_server.domain.user.port.out.crud_impl

import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.UserRepository

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave

@OutPort
class UserOutPortSaveImpl(
    private val repository: UserRepository,
): OutPortSave<AppUser> {
    override fun execute(entity: AppUser) {
        repository.save(entity)
    }
}