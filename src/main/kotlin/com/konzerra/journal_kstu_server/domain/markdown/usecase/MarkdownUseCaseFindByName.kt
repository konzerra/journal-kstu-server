package com.konzerra.journal_kstu_server.domain.markdown.usecase

import com.konzerra.journal_kstu_server.domain.markdown.dto.MarkdownResponseDto

interface MarkdownUseCaseFindByName {
    fun execute(name:String,lang:String):MarkdownResponseDto
}