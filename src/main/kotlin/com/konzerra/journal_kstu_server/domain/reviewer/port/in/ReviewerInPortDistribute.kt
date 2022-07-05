package com.konzerra.journal_kstu_server.domain.reviewer.port.`in`

interface ReviewerInPortDistribute {
    fun execute(id:Long):Any
}