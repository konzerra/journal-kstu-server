package com.konzerra.journal_kstu_server.domain.user.port.out.impl

import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.role.Role
import com.konzerra.journal_kstu_server.domain.user.port.out.UserOutPortFindByEmail
import com.konzerra.journal_kstu_server.domain.user.port.out.UserOutPortGetDetails
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@UseCase
class UserOutPortGetDetailsImpl(
    private val userOutPortFindByEmail: UserOutPortFindByEmail
) : UserOutPortGetDetails {
    override fun loadUserByUsername(username: String): UserDetails {
        val appUser: AppUser = userOutPortFindByEmail.execute(username)

        return org.springframework.security.core.userdetails.User(
            appUser.email,
            appUser.password,
            mapRolesToAuthorities(appUser.roles.toList())
        )
    }
    private fun mapRolesToAuthorities(roles: List<Role>): Collection<GrantedAuthority?> {
        val authorities: List<SimpleGrantedAuthority> = roles.map {
            SimpleGrantedAuthority("ROLE_${it.name}")
        }
        return authorities
    }
}