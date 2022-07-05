package com.konzerra.journal_kstu_server.domain.markdown.dto

import com.konzerra.journal_kstu_server._generic.data.SaveDtoI
import com.konzerra.journal_kstu_server.domain.markdown.markdown_data.MarkdownData

class MarkdownSaveDto(
    var name: String,
    var dataList: List<MarkdownData>
) : SaveDtoI{
}