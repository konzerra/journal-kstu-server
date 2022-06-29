package com.konzerra.journal_kstu_server.domain.user.usecase.crud_impl



import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortDeleteById
import com.konzerra.journal_kstu_server._generic.usecase.abstract_impl.UseCaseDeleteByIdAbstractImpl

@UseCase
class UserUseCaseDeleteByIdImpl(
    override val outPortDeleteById: OutPortDeleteById<AppUser, Long>
) : UseCaseDeleteByIdAbstractImpl<AppUser, Long>()