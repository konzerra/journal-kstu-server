package com.konzerra.journal_kstu_server.domain.jwt.port.`in`

import com.konzerra.journal_kstu_server.domain.jwt.dto.JwtRequestDto
import com.konzerra.journal_kstu_server.domain.jwt.dto.JwtResponseDto
import org.springframework.http.ResponseEntity

interface JwtInPortGenerateJwtToken {
    fun generateToken(jwtRequestDto: JwtRequestDto,lang:String):ResponseEntity<JwtResponseDto>
}