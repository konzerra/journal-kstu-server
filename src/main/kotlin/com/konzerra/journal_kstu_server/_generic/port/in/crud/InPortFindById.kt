package com.konzerra.journal_kstu_server._generic.port.`in`.crud


interface InPortFindById<Id:Any> {
    fun execute(id:Id,lang:String): Any
}