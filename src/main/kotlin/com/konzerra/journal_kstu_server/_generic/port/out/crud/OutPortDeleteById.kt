package com.konzerra.journal_kstu_server._generic.port.out.crud

import com.konzerra.journal_kstu_server._generic.data.EntityI

interface OutPortDeleteById<Entity: EntityI, Id:Any> {
    fun execute(id: Id)
}