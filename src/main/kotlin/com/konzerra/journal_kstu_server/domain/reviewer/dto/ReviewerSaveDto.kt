package com.konzerra.journal_kstu_server.domain.reviewer.dto

import com.konzerra.journal_kstu_server._generic.data.SaveDtoI


class ReviewerSaveDto(
    var email:String,
    var categoryId: Long
) : SaveDtoI{
}