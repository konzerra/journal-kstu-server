package com.konzerra.journal_kstu_server.domain.doc

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DocRepository : JpaRepository<Doc,Long> {
}