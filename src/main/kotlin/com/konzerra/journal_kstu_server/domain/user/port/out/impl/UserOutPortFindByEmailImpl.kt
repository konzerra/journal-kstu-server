package com.konzerra.journal_kstu_server.domain.user.port.out.impl

import com.konzerra.journal_kstu_server.exception.ResourceNotFoundException
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.UserRepository
import com.konzerra.journal_kstu_server.domain.user.port.out.UserOutPortFindByEmail

@OutPort
class UserOutPortFindByEmailImpl(
    private val repository: UserRepository
) : UserOutPortFindByEmail {
    override fun execute(email: String): AppUser {
        try{
            return repository.findByEmail(email)
        }catch(e:RuntimeException){
            throw ResourceNotFoundException(
                className = AppUser::class.simpleName ?: "className",
                fieldName = AppUser::id.name,
                fieldValue = email
            )
        }

    }
}