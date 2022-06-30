package com.konzerra.journal_kstu_server.domain.article.dto

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.article_data.ArticleData
import org.springframework.stereotype.Component

class ArticleFullResponseDto(
    var id:Long?,

    var status: String,

    var journalId: Long? = null,

    var categoryId: Long? = null,

    var pagesInJournal: String? = null,

    var antiplagiat : String? = null,

    var dataList: List<ArticleData> =emptyList(),

    var pdfDocId: Long? = null,

    var wordDocId: Long? = null,

    var reviewerBlankDoc: Long? = null,
) : ResponseDtoI{

    @Component
    companion object : Mapper<Article, ArticleFullResponseDto>
    {
        override fun toResponseDto(entity: Article, lang: String): ArticleFullResponseDto {
            return ArticleFullResponseDto(
                id= entity.id,
                status = entity.status,
                journalId = entity.journal.id,
                categoryId = entity.category?.id,
                pagesInJournal = entity.pagesInJournal,
                antiplagiat = entity.antiplagiat,
                dataList = entity.dataList,
                pdfDocId = entity.pdfDoc?.id,
                wordDocId = entity.wordDoc?.id,
                reviewerBlankDoc = entity.reviewerBlankDoc?.id
            )
        }

    }
}