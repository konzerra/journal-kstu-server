package com.konzerra.journal_kstu_server.domain.article.dto

import com.konzerra.journal_kstu_server._generic.data.SaveDtoI
import com.konzerra.journal_kstu_server.domain.article.article_data.ArticleData

class ArticleSaveDto(
    var ownerId: Long,

    var journalId: Long,
    var dataList: List<ArticleData> =emptyList(),

) : SaveDtoI{
}