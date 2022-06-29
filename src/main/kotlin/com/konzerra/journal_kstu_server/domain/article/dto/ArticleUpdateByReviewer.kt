package com.konzerra.journal_kstu_server.domain.article.dto

import com.konzerra.journal_kstu_server._generic.data.UpdateDtoI
import com.konzerra.journal_kstu_server.domain.article.article_data.ArticleData
import com.konzerra.journal_kstu_server.domain.doc.Doc

class ArticleUpdateByReviewer(
    var id:Long? = null,

    var status: String,

    var ownerId: Long,

    var antiplagiat : String? = null,

    var dataList: List<ArticleData> =emptyList(),

    var wordDoc: Doc? = null,
    var reviewerComment:String? = null,
) : UpdateDtoI {
}