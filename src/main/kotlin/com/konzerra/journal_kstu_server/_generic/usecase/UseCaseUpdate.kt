package com.konzerra.journal_kstu_server._generic.usecase

import com.konzerra.journal_kstu_server._generic.data.UpdateDtoI

interface UseCaseUpdate<UpdateDto : UpdateDtoI> {
    fun execute(updateDto: UpdateDto)
}