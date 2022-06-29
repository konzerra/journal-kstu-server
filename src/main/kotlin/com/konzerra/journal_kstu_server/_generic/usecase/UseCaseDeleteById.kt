package com.konzerra.journal_kstu_server._generic.usecase

import com.konzerra.journal_kstu_server._generic.data.EntityI

interface UseCaseDeleteById<Entity: EntityI, Id> {
    fun execute(id:Id)
}