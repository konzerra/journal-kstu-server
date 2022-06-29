package com.konzerra.journal_kstu_server.domain.user.port.`in`.crud.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.dto.UserResponseDto
import com.konzerra.journal_kstu_server.domain.user.port.`in`.UserApiPath
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortFindByIdAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindById
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@InPort
class UserInPortFindByIdImpl(
    override val useCaseFindById: UseCaseFindById<AppUser, Long, UserResponseDto>
) : InPortFindByIdAbstractImpl<AppUser, Long, UserResponseDto>() {

    @GetMapping(UserApiPath.findByIdPath)
    override fun execute(@PathVariable id: Long, @PathVariable lang: String): ResponseEntity<UserResponseDto> {
        return ResponseEntity(useCaseFindById.execute(id,lang),HttpStatus.OK)
    }

}