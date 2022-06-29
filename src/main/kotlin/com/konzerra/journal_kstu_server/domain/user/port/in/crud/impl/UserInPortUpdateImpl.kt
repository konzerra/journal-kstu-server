package com.konzerra.journal_kstu_server.domain.user.port.`in`.crud.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.dto.UserUpdateDto
import com.konzerra.journal_kstu_server.domain.user.port.`in`.UserApiPath
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortUpdateAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseUpdate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping

@InPort
class UserInPortUpdateImpl(
    override val useCaseUpdate: UseCaseUpdate<UserUpdateDto>
) : InPortUpdateAbstractImpl<AppUser, Long, UserUpdateDto>() {

    @PutMapping(UserApiPath.updatePath)
    override fun execute(updateDto: UserUpdateDto): ResponseEntity<*> {
        useCaseUpdate.execute(updateDto)
        return ResponseEntity<Any>(HttpStatus.OK)
    }
}