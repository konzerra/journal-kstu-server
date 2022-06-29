package com.konzerra.journal_kstu_server.domain.user.port.`in`.crud.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.dto.UserSaveDto
import com.konzerra.journal_kstu_server.domain.user.port.`in`.UserApiPath
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortSaveAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseSave
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@InPort
class UserInPortSaveImpl(
    override val useCaseInPortSave: UseCaseSave<UserSaveDto>
) : InPortSaveAbstractImpl<AppUser, Long, UserSaveDto>() {

    @PostMapping(UserApiPath.savePath)
    override fun execute(@RequestBody saveDto: UserSaveDto): ResponseEntity<*> {
        useCaseInPortSave.execute(saveDto)
        return ResponseEntity<Any>(HttpStatus.CREATED)
    }
}