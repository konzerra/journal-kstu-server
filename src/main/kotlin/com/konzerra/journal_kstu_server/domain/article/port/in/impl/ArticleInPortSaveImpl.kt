
package com.konzerra.journal_kstu_server.domain.article.port.`in`.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleSaveDto
import com.konzerra.journal_kstu_server.domain.article.ArticleApiPath
import com.konzerra.journal_kstu_server.domain.article.port.`in`.ArticleInPortSave
import com.konzerra.journal_kstu_server.domain.article.usecase.ArticleUseCaseSave


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@InPort
class ArticleInPortSaveImpl(
    val useCaseSave: ArticleUseCaseSave
) : ArticleInPortSave {

    @PostMapping(ArticleApiPath.savePath)
    override fun execute(
        @RequestPart("saveDto") saveDto: ArticleSaveDto,
        @RequestPart("file") file:MultipartFile
    ): ResponseEntity<*> {
        println(file)
        useCaseSave.execute(saveDto,file)
        return ResponseEntity<Any>(HttpStatus.CREATED)
    }
}
    