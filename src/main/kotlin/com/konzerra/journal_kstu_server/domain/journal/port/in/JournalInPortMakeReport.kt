package com.konzerra.journal_kstu_server.domain.journal.port.`in`

interface JournalInPortMakeReport {
    fun execute(id:Long,lang:String):Any
}