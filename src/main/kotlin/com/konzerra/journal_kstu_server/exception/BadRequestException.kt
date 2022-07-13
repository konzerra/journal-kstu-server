package com.konzerra.journal_kstu_server.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class BadRequestException(
    private val report: String
): RuntimeException() {
    fun message():String{
        return report
    }
}