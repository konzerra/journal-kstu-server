package com.konzerra.journal_kstu_server._generic.port.`in`.crud

import com.konzerra.journal_kstu_server._generic.data.EntityI

interface InPortDeleteById<Entity: EntityI, Id:Any> {
    fun execute(id: Id):Any
}