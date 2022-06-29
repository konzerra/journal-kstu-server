package com.konzerra.journal_kstu_server.configuration.security


import com.konzerra.journal_kstu_server.ApiPath
import com.konzerra.journal_kstu_server.domain.user.port.out.UserOutPortGetDetails
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
class SecurityConfig(
    private val getUserDetailsUseCaseImpl: UserOutPortGetDetails,
    private val jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint,
    private val jwtTokenFilter: JwtTokenFilter
)
{

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val auth = DaoAuthenticationProvider()
        auth.setUserDetailsService(getUserDetailsUseCaseImpl)
        auth.setPasswordEncoder(passwordEncoder())
        return auth
    }

    @Bean
    @Throws(Exception::class)
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager? {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    @Throws(java.lang.Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        http .csrf().disable().cors().and()

        // Set session management to stateless
        http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

        // Set unauthorized requests exception handler
        http
            .exceptionHandling()
            .authenticationEntryPoint(
                jwtAuthenticationEntryPoint
            )
            .and()

        // Set permissions on endpoints
        http.authorizeRequests() // Our public endpoints
            .antMatchers(
                "${ApiPath.publicPath}/**",
            ).permitAll() // Our private endpoints
            .anyRequest().authenticated()

        // Add JWT token filter
        http.addFilterBefore(
            jwtTokenFilter,
            UsernamePasswordAuthenticationFilter::class.java
        )
        return http.build()
    }

}