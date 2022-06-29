package com.konzerra.journal_kstu_server.domain.user.usecase.crud_impl


import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.user.dto.UserSaveDto
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server._generic.usecase.abstract_impl.UseCaseSaveAbstractImpl
import com.konzerra.journal_kstu_server.domain.role.port.out.RoleOutPortFindByName
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.UserRoles
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@UseCase
class UserUseCaseSaveImpl(
    override val outPortSave: OutPortSave<AppUser>,
    private val roleOutPortFindByName: RoleOutPortFindByName,
    private val passwordEncoder: BCryptPasswordEncoder
) : UseCaseSaveAbstractImpl<AppUser,UserSaveDto>(){

    override fun execute(saveDto: UserSaveDto) {
        outPortSave.execute(
            AppUser(
                name = saveDto.name,
                email = saveDto.email,
                password = passwordEncoder.encode(saveDto.password),
                roles = mutableSetOf(roleOutPortFindByName.findByName(UserRoles.User.toString()))
            )
        )
    }

}