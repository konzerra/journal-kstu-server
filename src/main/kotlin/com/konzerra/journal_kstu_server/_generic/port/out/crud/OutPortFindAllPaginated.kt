package com.konzerra.journal_kstu_server._generic.port.out.crud

import com.konzerra.journal_kstu_server._generic.data.EntityI
import org.springframework.data.domain.Page

interface OutPortFindAllPaginated<Entity:EntityI> {
    fun execute(pageNumber: Int, pageSize:Int):Page<Entity>
}