package com.konzerra.journal_kstu_server._generic.usecase

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI

interface UseCaseFindAll<Entity : EntityI, ResponseDto : ResponseDtoI> {
    fun execute(lang:String): List<ResponseDto>
}