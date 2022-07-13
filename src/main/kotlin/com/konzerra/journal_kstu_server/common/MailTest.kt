package com.konzerra.journal_kstu_server.common

import com.konzerra.journal_kstu_server.ApiPath
import com.konzerra.journal_kstu_server.annotation.InPort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.web.bind.annotation.GetMapping

@InPort
class MailTest(
    private val mailService: MailService
) {
    @GetMapping(ApiPath.publicPath+"/mail")
    fun execute():Any{
        mailService.sendEmail(
            "Пуликация статьи в журнал 'Известия им.И. Раззакова' ",
            "Ваша статья была принята рецензентом (см. ниже комментарий) \n\nЧто-то чтоо",
            "konzerra@gmail.com"
        )
        return ResponseEntity<Any>("Success",HttpStatus.OK)
    }
}