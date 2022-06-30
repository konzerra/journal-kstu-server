package com.konzerra.journal_kstu_server.domain.article.dto

import com.konzerra.journal_kstu_server._generic.data.UpdateDtoI

class ArticleUpdateByReviewerDto(
    var id:Long,

    var status: String,

    var comment:String,


) : UpdateDtoI {
}