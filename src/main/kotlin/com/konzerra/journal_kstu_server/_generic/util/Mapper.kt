package com.konzerra.journal_kstu_server._generic.util

import com.konzerra.journal_kstu_server.AppLanguages
import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI


interface Mapper<Entity: EntityI, ResponseDto: ResponseDtoI> {
   fun toResponseDto(entity:Entity, lang:String = AppLanguages.Ru.toString()): ResponseDto
}