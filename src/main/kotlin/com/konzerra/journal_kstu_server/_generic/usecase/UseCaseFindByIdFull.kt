package com.konzerra.journal_kstu_server._generic.usecase

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI

interface UseCaseFindByIdFull<FullResponseDto:ResponseDtoI, Id:Any> {
    fun execute(id:Id):FullResponseDto
}