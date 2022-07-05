package com.konzerra.journal_kstu_server.domain.reviewer.port.out

import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer

interface ReviewerOutPortFindByUserId {
    fun execute(userId:Long): Reviewer
}