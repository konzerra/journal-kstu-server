package com.konzerra.journal_kstu_server.domain.user.dto


import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.role.dto.RoleResponseDto
import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.util.Mapper
import org.springframework.stereotype.Component


class UserResponseDto(
    var id:Long? = null,
    var name:String,
    var email:String,
    var roles:List<RoleResponseDto>,
) : ResponseDtoI
{

    @Component
    companion object: Mapper<AppUser, UserResponseDto> {
        override fun toResponseDto(entity: AppUser, lang:String): UserResponseDto {
            return UserResponseDto(
                id = entity.id,
                email = entity.email,
                name = entity.name,
                roles = entity.roles.map{
                    RoleResponseDto(it.name)
                }
            )
        }
    }
}