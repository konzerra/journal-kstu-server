package com.konzerra.journal_kstu_server.domain.role.port.out

import com.konzerra.journal_kstu_server.domain.role.Role

interface RoleOutPortFindByName {
    fun findByName(name:String): Role
}