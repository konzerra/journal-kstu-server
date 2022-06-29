package com.konzerra.journal_kstu_server._generic.usecase

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI


interface UseCaseFindById<Entity : EntityI, Id, ResponseDto : ResponseDtoI> {
    fun execute(id:Id,lang:String): ResponseDto
}