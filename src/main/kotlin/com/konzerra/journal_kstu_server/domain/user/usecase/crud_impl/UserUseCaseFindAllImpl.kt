package com.konzerra.journal_kstu_server.domain.user.usecase.crud_impl



import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.dto.UserResponseDto
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAll
import com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl.UseCaseFindAllAbstractImpl
import com.konzerra.journal_kstu_server._generic.util.Mapper

@UseCase
class UserUseCaseFindAllImpl(
    override val outPortFindAll: OutPortFindAll<AppUser>,
    override val mapper: Mapper<AppUser, UserResponseDto>
) : UseCaseFindAllAbstractImpl<AppUser, UserResponseDto>()