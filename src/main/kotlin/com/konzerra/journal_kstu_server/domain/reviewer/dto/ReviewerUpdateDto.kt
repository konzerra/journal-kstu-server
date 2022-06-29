package com.konzerra.journal_kstu_server.domain.reviewer.dto

import com.konzerra.journal_kstu_server._generic.data.UpdateDtoI

class ReviewerUpdateDto(
    var id: Long,
    var categoryId: Long,
    var active: Boolean,
) : UpdateDtoI {

}