package com.konzerra.journal_kstu_server.domain.journal

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JournalRepository : JpaRepository<Journal,Long>{

}