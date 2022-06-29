package com.konzerra.journal_kstu_server.domain.user.port.out.crud_impl

import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.exception.ResourceNotFoundException
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.UserRepository
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById

@OutPort
class UserOutPortFindByIdImpl(
    private val repository: UserRepository
): OutPortFindById<AppUser, Long> {
    override fun execute(id: Long): AppUser {
        return repository.findById(id).orElseThrow {
            ResourceNotFoundException(
                className = AppUser::class.simpleName ?: "className",
                fieldName = AppUser::id.name,
                fieldValue = id
            )
        }


    }
}