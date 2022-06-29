package com.konzerra.journal_kstu_server.domain.article.dto

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.journal.dto.JournalResponseDto
import org.springframework.stereotype.Component

class ArticleResponseDto(
    var id: Long? = null,
    var name: String,
    var authors: List<String>,
    var annotation: String,
    var tags:String,
    var status:String,
    var journal:JournalResponseDto
) : ResponseDtoI{
    @Component
    companion object: Mapper<Article,ArticleResponseDto>{
        override fun toResponseDto(entity: Article, lang: String): ArticleResponseDto {
            val articleData = entity.dataByLanguage(lang)
            return ArticleResponseDto(
                id = entity.id,
                name = articleData.name ?: "no translation",
                authors = articleData.authors.split("$") ?: listOf("No translation"),
                annotation = articleData.annotation,
                tags = articleData.tags,
                status = entity.status,
                journal = JournalResponseDto.toResponseDto(entity.journal)
            )
        }
    }
}