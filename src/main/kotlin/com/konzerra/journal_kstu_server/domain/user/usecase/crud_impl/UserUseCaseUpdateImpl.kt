package com.konzerra.journal_kstu_server.domain.user.usecase.crud_impl


import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.user.dto.UserUpdateDto
import com.konzerra.journal_kstu_server._generic.usecase.abstract_impl.UseCaseUpdateAbstractImpl
import com.konzerra.journal_kstu_server.domain.user.AppUser

@UseCase
class UserUseCaseUpdateImpl(
    override val outPortSave: OutPortSave<AppUser>,
    override val outPortFindById: OutPortFindById<AppUser, Long>
) : UseCaseUpdateAbstractImpl<AppUser,Long,UserUpdateDto>(){
    override fun execute(updateDto: UserUpdateDto) {
        val user = outPortFindById.execute(updateDto.id)
        user.name = updateDto.name
        outPortSave.execute(user)
    }
}