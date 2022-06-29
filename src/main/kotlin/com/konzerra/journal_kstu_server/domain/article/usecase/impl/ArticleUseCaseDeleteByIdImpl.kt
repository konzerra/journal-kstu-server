
package com.konzerra.journal_kstu_server.domain.article.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortDeleteById
import com.konzerra.journal_kstu_server._generic.usecase.abstract_impl.UseCaseDeleteByIdAbstractImpl
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.article.Article

    

@UseCase
class ArticleUseCaseDeleteByIdImpl(
    override val outPortDeleteById: OutPortDeleteById<Article, Long>
) : UseCaseDeleteByIdAbstractImpl<Article, Long>()
    