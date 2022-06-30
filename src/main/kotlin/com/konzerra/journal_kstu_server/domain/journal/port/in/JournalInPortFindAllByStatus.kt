package com.konzerra.journal_kstu_server.domain.journal.port.`in`

interface JournalInPortFindAllByStatus {
    fun execute(status:String,lang:String):Any
}