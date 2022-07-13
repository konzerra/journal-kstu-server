package com.konzerra.journal_kstu_server.domain.article.dto

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.article_data.ArticleData
import com.konzerra.journal_kstu_server.domain.category.dto.CategoryResponseDto
import com.konzerra.journal_kstu_server.domain.journal.dto.JournalResponseDto
import org.springframework.stereotype.Component

class ArticleFullResponseDto(
    var id:Long?,

    var status: String,

    var journal: JournalResponseDto,

    var category: CategoryResponseDto?,

    var reviewer: Boolean,

    var pagesInJournal: String? = null,

    var antiplagiat : String? = null,

    var dataList: List<ArticleData> =emptyList(),

    var pdfDocId: Long? = null,

    var wordDocId: Long? = null,

    var reviewerBlankDocId: Long? = null,

) : ResponseDtoI{

    @Component
    companion object : Mapper<Article, ArticleFullResponseDto>
    {
        override fun toResponseDto(entity: Article, lang: String): ArticleFullResponseDto {
            return ArticleFullResponseDto(
                id= entity.id,
                status = entity.status,
                journal = JournalResponseDto.toResponseDto(entity.journal),
                category = entity.category?.let { CategoryResponseDto.toResponseDto(it) },
                reviewer = entity.reviewer != null,
                pagesInJournal = entity.pagesInJournal,
                antiplagiat = entity.antiplagiat,
                dataList = entity.dataList,
                pdfDocId = entity.pdfDoc?.id,
                wordDocId = entity.wordDoc?.id,
                reviewerBlankDocId = entity.reviewerBlankDoc?.id,
            )
        }

    }
}