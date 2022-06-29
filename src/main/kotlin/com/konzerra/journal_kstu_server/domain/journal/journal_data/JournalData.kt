package com.konzerra.journal_kstu_server.domain.journal.journal_data

import com.konzerra.journal_kstu_server._generic.data.EntityI
import javax.persistence.*

@Entity
class JournalData(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id:Long? = null,
    var lang:String,
    var name:String = "no translation",
    var version:String = "no translation",
) : EntityI{
}