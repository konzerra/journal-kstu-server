package com.konzerra.journal_kstu_server.domain.markdown.dto

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.domain.markdown.Markdown
import com.konzerra.journal_kstu_server.domain.markdown.markdown_data.MarkdownData
import org.springframework.stereotype.Component

class MarkdownFullResponseDto(
    var id:Long,
    var name:String,
    var dataList: List<MarkdownData> = emptyList()
) : ResponseDtoI{
    @Component
    companion object: Mapper<Markdown, MarkdownFullResponseDto> {
        override fun toResponseDto(entity: Markdown, lang: String): MarkdownFullResponseDto {

            return MarkdownFullResponseDto(
                id=entity.id ?: 0,
                name=entity.name,
                dataList = entity.dataList
            )
        }

    }

}