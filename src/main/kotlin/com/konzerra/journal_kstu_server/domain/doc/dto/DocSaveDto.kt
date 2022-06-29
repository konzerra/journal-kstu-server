package com.konzerra.journal_kstu_server.domain.doc.dto

import com.konzerra.journal_kstu_server._generic.data.SaveDtoI


class DocSaveDto(
    var name:String = "document",
    var mimeType :String,
    private var content: ByteArray
):SaveDtoI {
}