package com.konzerra.journal_kstu_server.domain.article.dto

import com.konzerra.journal_kstu_server.domain.article.article_data.ArticleData

class ArticleUpdateDtoByAdmin(
    var id:Long,

    var status: String,

    var journalId: Long? = null,

    var categoryId: Long? = null,

    var pagesInJournal: String? = null,

    var antiplagiat : String? = null,

    var dataList: List<ArticleData> =emptyList(),

    var pdfDocId: Long? = null,

    var wordDocId: Long? = null,

    var verificationDocId: Long? = null,
) {
}