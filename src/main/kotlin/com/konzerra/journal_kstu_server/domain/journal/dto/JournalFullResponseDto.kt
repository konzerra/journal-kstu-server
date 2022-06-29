package com.konzerra.journal_kstu_server.domain.journal.dto

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.journal_data.JournalData
import org.springframework.stereotype.Component

class JournalFullResponseDto(
    var id:Long? = null,
    var status:String,
    var dataList:List<JournalData> = emptyList()
) : ResponseDtoI {
    @Component
    companion object : Mapper<Journal,JournalFullResponseDto>{
        override fun toResponseDto(entity: Journal, lang: String): JournalFullResponseDto {
            return JournalFullResponseDto(
                id = entity.id,
                status = entity.status,
                dataList = entity.dataList
            )
        }

    }

}