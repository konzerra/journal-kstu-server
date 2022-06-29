package com.konzerra.journal_kstu_server._generic.port.`in`.crud

import com.konzerra.journal_kstu_server._generic.data.UpdateDtoI

interface InPortUpdate<UpdateDto: UpdateDtoI> {
    fun execute(updateDto: UpdateDto): Any
}