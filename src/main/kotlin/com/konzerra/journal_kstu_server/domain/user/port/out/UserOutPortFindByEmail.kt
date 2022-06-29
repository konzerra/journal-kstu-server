package com.konzerra.journal_kstu_server.domain.user.port.out

import com.konzerra.journal_kstu_server.domain.user.AppUser


interface UserOutPortFindByEmail {
    fun execute(email:String): AppUser
}