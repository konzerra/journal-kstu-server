package com.konzerra.journal_kstu_server._generic.port.`in`.crud

import com.konzerra.journal_kstu_server._generic.data.SaveDtoI

interface InPortSave<SaveDto: SaveDtoI> {
    fun execute(saveDto: SaveDto): Any
}