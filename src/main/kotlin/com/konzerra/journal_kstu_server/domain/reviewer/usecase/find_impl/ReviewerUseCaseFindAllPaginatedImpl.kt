package com.konzerra.journal_kstu_server.domain.reviewer.usecase.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAllPaginated
import com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl.UseCaseFindAllPaginatedAbstractImpl
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import com.konzerra.journal_kstu_server.domain.reviewer.dto.ReviewerResponseDto

@UseCase
class ReviewerUseCaseFindAllPaginatedImpl(
    override val outPortFindAllPaginated: OutPortFindAllPaginated<Reviewer>,
    override val mapper: Mapper<Reviewer, ReviewerResponseDto>
) : UseCaseFindAllPaginatedAbstractImpl<Reviewer,ReviewerResponseDto>() {

}