package com.konzerra.journal_kstu_server.domain.journal.port.out

import com.konzerra.journal_kstu_server.domain.journal.Journal

interface JournalOutPortFindAllByStatus {
    fun execute(status:String):List<Journal>
}