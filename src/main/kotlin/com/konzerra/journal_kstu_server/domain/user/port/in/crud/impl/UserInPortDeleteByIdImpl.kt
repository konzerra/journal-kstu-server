package com.konzerra.journal_kstu_server.domain.user.port.`in`.crud.impl


import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.port.`in`.UserApiPath
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortDeleteByIdAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseDeleteById
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable

@InPort
class UserInPortDeleteByIdImpl(
    override val useCaseDeleteById: UseCaseDeleteById<AppUser, Long>
) : InPortDeleteByIdAbstractImpl<AppUser, Long>()
{
    @DeleteMapping(UserApiPath.deleteByIdPath)
    override fun execute(@PathVariable id: Long): ResponseEntity<*> {
        useCaseDeleteById.execute(id)
        return ResponseEntity<Any>(HttpStatus.OK)
    }
}
