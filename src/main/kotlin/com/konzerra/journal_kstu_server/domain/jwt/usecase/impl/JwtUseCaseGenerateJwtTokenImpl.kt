package com.konzerra.journal_kstu_server.domain.jwt.usecase.impl


import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.configuration.security.util.JwtUtil
import com.konzerra.journal_kstu_server.domain.jwt.dto.JwtRequestDto
import com.konzerra.journal_kstu_server.domain.jwt.dto.JwtResponseDto
import com.konzerra.journal_kstu_server.domain.jwt.usecase.JwtUseCaseGenerateJwtToken
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.dto.UserResponseDto
import com.konzerra.journal_kstu_server.domain.user.port.out.UserOutPortFindByEmail
import com.konzerra.journal_kstu_server.domain.user.port.out.UserOutPortGetDetails

import com.konzerra.journal_kstu_server._generic.util.Mapper
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails

@UseCase
class JwtUseCaseGenerateJwtTokenImpl(
    private val jwtUtil: JwtUtil,
    private val userOutPortGetDetails: UserOutPortGetDetails,
    private val authenticationManager: AuthenticationManager,
    private val userOutPortFindByEmail: UserOutPortFindByEmail,
    private val appUserMapper: Mapper<AppUser, UserResponseDto>,
) : JwtUseCaseGenerateJwtToken {

    override fun execute(jwtRequestDto: JwtRequestDto, lang:String): JwtResponseDto {
        val email: String = jwtRequestDto.email
        val userPassword: String = jwtRequestDto.password
        authenticate(email, userPassword)

        val userDetails: UserDetails = userOutPortGetDetails.loadUserByUsername(email)
        val newGeneratedToken = jwtUtil.generateToken(userDetails)

        val userResponseDto: UserResponseDto = appUserMapper
            .toResponseDto(userOutPortFindByEmail.execute(email), lang)
        return JwtResponseDto(newGeneratedToken, userResponseDto)
    }


    private fun authenticate(userName: String, userPassword: String) {
        try {
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(userName, userPassword))
        } catch (e: DisabledException) {
            throw Exception("USER_DISABLED", e)
        } catch (e: BadCredentialsException) {
            throw Exception("INVALID_CREDENTIALS", e)
        }
    }
}