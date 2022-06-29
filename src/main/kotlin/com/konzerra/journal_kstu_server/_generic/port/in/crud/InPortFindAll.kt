package com.konzerra.journal_kstu_server._generic.port.`in`.crud

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI

interface InPortFindAll<ResponseDto: ResponseDtoI> {
    fun execute(lang:String): Any
}