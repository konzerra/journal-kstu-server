package com.konzerra.journal_kstu_server.domain.jwt.port.`in`.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.jwt.dto.JwtRequestDto
import com.konzerra.journal_kstu_server.domain.jwt.dto.JwtResponseDto
import com.konzerra.journal_kstu_server.domain.jwt.JwtApiPath
import com.konzerra.journal_kstu_server.domain.jwt.port.`in`.JwtInPortGenerateJwtToken
import com.konzerra.journal_kstu_server.domain.jwt.usecase.JwtUseCaseGenerateJwtToken
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@InPort
class JwtInPortGenerateJwtTokenImpl(
    private val jwtUseCaseGenerateJwtToken: JwtUseCaseGenerateJwtToken
) : JwtInPortGenerateJwtToken {


    @PostMapping(JwtApiPath.generateJwtTokenPath)
    override fun generateToken(
        @RequestBody jwtRequestDto: JwtRequestDto,
        @RequestHeader("Accept-Language") lang:String
    ): ResponseEntity<JwtResponseDto> {
        return ResponseEntity(jwtUseCaseGenerateJwtToken.execute(jwtRequestDto,lang),HttpStatus.OK)
    }
}