
package com.konzerra.journal_kstu_server.domain.article.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl.UseCaseFindByIdFullAbstractImpl
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleFullResponseDto


@UseCase
class ArticleUseCaseFindByIdFullImpl(
    override val outPortFindById: OutPortFindById<Article, Long>,
    override val mapper: Mapper<Article, ArticleFullResponseDto>
) : UseCaseFindByIdFullAbstractImpl<Article, Long, ArticleFullResponseDto>()
    