package com.konzerra.journal_kstu_server.domain.markdown.dto

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server.domain.markdown.markdown_data.MarkdownData

class MarkdownFullResponseDto(
    var id:Long,
    var name:String,
    var dataList: List<MarkdownData> = emptyList()
) : ResponseDtoI{


}