package com.konzerra.journal_kstu_server.domain.user.usecase.crud_impl





import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.dto.UserResponseDto
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl.UseCaseFindByIdAbstractImpl
import com.konzerra.journal_kstu_server._generic.util.Mapper

@UseCase
class UserUseCaseFindByIdImpl(
    override val outPortFindById: OutPortFindById<AppUser, Long>,
    override val mapper: Mapper<AppUser, UserResponseDto>
) : UseCaseFindByIdAbstractImpl<AppUser, Long, UserResponseDto>()