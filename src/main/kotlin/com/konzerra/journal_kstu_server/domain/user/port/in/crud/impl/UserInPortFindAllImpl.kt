package com.konzerra.journal_kstu_server.domain.user.port.`in`.crud.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.dto.UserResponseDto
import com.konzerra.journal_kstu_server.domain.user.port.`in`.UserApiPath
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortFindAllAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindAll
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@InPort
class UserInPortFindAllImpl(
    override val useCaseFindAll: UseCaseFindAll<AppUser, UserResponseDto>
) : InPortFindAllAbstractImpl<AppUser, UserResponseDto>() {

    @GetMapping(UserApiPath.findAllPath)
    override fun execute(@PathVariable lang:String): ResponseEntity<List<UserResponseDto>> {
        return ResponseEntity(useCaseFindAll.execute(lang),HttpStatus.OK)
    }
}