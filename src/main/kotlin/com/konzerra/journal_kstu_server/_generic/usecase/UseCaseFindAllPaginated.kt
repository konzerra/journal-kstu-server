package com.konzerra.journal_kstu_server._generic.usecase

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import org.springframework.data.domain.Page

interface UseCaseFindAllPaginated<ResponseDto:ResponseDtoI> {
    fun execute(pageNumber: Int,pageSize:Int, lang:String): Page<ResponseDto>
}