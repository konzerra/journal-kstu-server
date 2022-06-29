package com.konzerra.journal_kstu_server.domain.reviewer.usecase

interface ReviewerUseCaseDistribute {
    fun execute(journalId:Long):String
}