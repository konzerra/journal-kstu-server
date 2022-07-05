package com.konzerra.journal_kstu_server.domain.markdown.port.out

import com.konzerra.journal_kstu_server.domain.markdown.Markdown


interface MarkdownOutPortFindByName {
    fun execute(name:String):Markdown
}