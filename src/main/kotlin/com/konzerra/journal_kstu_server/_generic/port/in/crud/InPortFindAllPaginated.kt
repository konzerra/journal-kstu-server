package com.konzerra.journal_kstu_server._generic.port.`in`.crud

import com.konzerra.journal_kstu_server.AppLanguages

interface InPortFindAllPaginated {
    fun execute(pageNumber:Int,  pageSize:Int, lang:String = AppLanguages.Ru.toString(),):Any
}