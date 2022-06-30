package com.konzerra.journal_kstu_server.domain.reviewer.port.`in`

interface ReviewerInPortFindArticles {
    fun execute(id:Long, lang:String):Any
}