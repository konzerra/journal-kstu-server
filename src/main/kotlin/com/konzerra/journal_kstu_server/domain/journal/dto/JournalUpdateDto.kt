package com.konzerra.journal_kstu_server.domain.journal.dto

import com.konzerra.journal_kstu_server._generic.data.UpdateDtoI
import com.konzerra.journal_kstu_server.domain.journal.journal_data.JournalData

class JournalUpdateDto(
    var id:Long,
    var status:String,
    var dataList:List<JournalData>,
):UpdateDtoI {
}