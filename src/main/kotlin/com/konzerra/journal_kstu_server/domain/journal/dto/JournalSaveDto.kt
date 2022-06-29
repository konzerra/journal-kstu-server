package com.konzerra.journal_kstu_server.domain.journal.dto

import com.konzerra.journal_kstu_server._generic.data.SaveDtoI
import com.konzerra.journal_kstu_server.domain.journal.journal_data.JournalData

class JournalSaveDto(
    var dataList:List<JournalData>,
) : SaveDtoI