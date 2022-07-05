package com.konzerra.journal_kstu_server.domain.markdown.dto

import com.konzerra.journal_kstu_server._generic.data.UpdateDtoI
import com.konzerra.journal_kstu_server.domain.markdown.markdown_data.MarkdownData

class MarkdownUpdateDto(
    var id:Long,
    var name: String,
    var dataList: List<MarkdownData>
) :UpdateDtoI{
}