package com.konzerra.journal_kstu_server.domain.user;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<AppUser,Long> {
    fun findByEmail(email:String): AppUser
    
}