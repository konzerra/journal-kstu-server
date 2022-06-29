package com.konzerra.journal_kstu_server.configuration.security

import com.konzerra.journal_kstu_server.configuration.security.util.JwtUtil
import com.konzerra.journal_kstu_server.domain.user.port.out.UserOutPortGetDetails
import io.jsonwebtoken.ExpiredJwtException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Authentication token is sent via header
 */
@Component
class JwtTokenFilter(
    private val jwtUtil: JwtUtil,
    private val userOutPortGetDetails: UserOutPortGetDetails
) : OncePerRequestFilter() {


    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val header = request.getHeader("Authorization")
        var jwtToken: String? = null
        var userName: String? = null
        if (header != null && header.startsWith("Bearer ")) {
            jwtToken = header.substring(7)
            logger.info(header.substring(7))
            try {
                userName = jwtUtil.getUserNameFromToken(jwtToken)
            } catch (illegalArgumentException: IllegalArgumentException) {
                println("Unable to get Jwt Token")
            } catch (expiredJwtException: ExpiredJwtException) {
                println("Jwt token is expired")
            }
        } else {
            println("Jwt not found")
        }
        if (userName != null && SecurityContextHolder.getContext().authentication == null && jwtToken!=null) {
            val userDetails: UserDetails = userOutPortGetDetails.loadUserByUsername(userName)
            if (jwtUtil.validateToken(jwtToken, userDetails)) {
                val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.authorities
                )
                usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
            }
        }
        filterChain.doFilter(request, response)
    }
}