package com.konzerra.journal_kstu_server._generic.usecase

import com.konzerra.journal_kstu_server._generic.data.SaveDtoI

interface UseCaseSave<SaveDto : SaveDtoI> {
    fun execute(saveDto: SaveDto)
}

