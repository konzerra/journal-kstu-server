package com.konzerra.journal_kstu_server.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ResourceNotFoundExceptionHandler {

    @ExceptionHandler
    fun handle(exception: ResourceNotFoundException):Any{
        return ResponseEntity(ExceptionResponse(exception.message()),HttpStatus.NOT_FOUND)
    }

}