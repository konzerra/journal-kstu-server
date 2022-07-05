package com.konzerra.journal_kstu_server.domain.markdown.port.`in`


interface MarkdownInPortFindByName {
    fun execute(name:String, lang:String):Any
}