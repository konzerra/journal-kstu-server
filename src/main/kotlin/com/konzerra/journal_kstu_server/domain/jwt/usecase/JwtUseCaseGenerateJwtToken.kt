package com.konzerra.journal_kstu_server.domain.jwt.usecase

import com.konzerra.journal_kstu_server.domain.jwt.dto.JwtRequestDto
import com.konzerra.journal_kstu_server.domain.jwt.dto.JwtResponseDto


interface JwtUseCaseGenerateJwtToken{
    fun execute(jwtRequestDto: JwtRequestDto, lang:String): JwtResponseDto
}