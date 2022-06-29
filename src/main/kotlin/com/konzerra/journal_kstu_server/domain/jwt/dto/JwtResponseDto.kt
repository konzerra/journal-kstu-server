package com.konzerra.journal_kstu_server.domain.jwt.dto

import com.konzerra.journal_kstu_server.domain.user.dto.UserResponseDto


class JwtResponseDto(
    var jwtToken:String,
    var user: UserResponseDto
) {
}