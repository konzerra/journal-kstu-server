package com.konzerra.journal_kstu_server.domain.user.dto

import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.util.Mapper
import org.springframework.stereotype.Component

class SimpleUserResponseDto(
    var id:Long? = null,
    var name:String,
): ResponseDtoI {
    @Component
    companion object: Mapper<AppUser, SimpleUserResponseDto> {
        override fun toResponseDto(entity: AppUser, lang:String): SimpleUserResponseDto {
            return SimpleUserResponseDto(
                id = entity.id,
                name = entity.name
            )
        }
    }
}