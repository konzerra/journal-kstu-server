package com.konzerra.journal_kstu_server.on_startup

import com.konzerra.journal_kstu_server.domain.role.Role
import com.konzerra.journal_kstu_server.domain.role.RoleRepository
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.UserRepository
import com.konzerra.journal_kstu_server.domain.user.UserRoles
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class OnStartup(
    private val roleRepository: RoleRepository,
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val list: List<Role> = listOf(
            Role(
                name = "Admin"
            ),
            Role(
                name = "User"
            ),
            Role(
                name = "Reviewer"
            )
        )
        //check if role exists before saving
        list.forEach {
            try{
                roleRepository.findRoleByName(it.name)
            }catch(e:RuntimeException) {
                roleRepository.save(it)
            }

        }


        val appUser = AppUser(
            name = "Ruslan",
            email = "konzerra@gmail.com",
            password = passwordEncoder.encode("123"),
            roles = mutableSetOf(
                roleRepository.findRoleByName(UserRoles.Admin.toString()),
                roleRepository.findRoleByName(UserRoles.User.toString())
            )
        )
        try{
            userRepository.findByEmail("konzerra@gmail.com")
        }
        catch(e:RuntimeException){
            userRepository.save(appUser)
        }
    }

}