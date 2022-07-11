package com.konzerra.journal_kstu_server.domain.journal.port.`in`

interface JournalInPortFindAllArticlesPaginated {
    fun execute(id:Long, pageNumber: Int, pageSize: Int, lang:String):Any
}