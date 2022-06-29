package com.konzerra.journal_kstu_server._generic.port.`in`.crud

interface InPortFindByIdFull<Id:Any> {
    fun execute(id:Id):Any
}