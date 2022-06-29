package com.konzerra.journal_kstu_server.domain.journal.dto

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.domain.journal.Journal
import org.springframework.stereotype.Component

class JournalResponseDto(
    var id:Long? = null,
    var name:String,
    var status:String,
    var version:String,
    var articlesCount:Int

) : ResponseDtoI {
    @Component
    companion object : Mapper<Journal, JournalResponseDto> {
        override fun toResponseDto(entity: Journal, lang: String): JournalResponseDto {
            val data = entity.dataByLanguage(lang)
            return JournalResponseDto(
                id = entity.id,
                status = entity.status,
                name = data.name,
                version = data.version,
                articlesCount = entity.articles.size
            )
        }

    }

}