package com.konzerra.journal_kstu_server.domain.markdown

import com.konzerra.journal_kstu_server.ApiPath

class MarkdownApi {
    companion object{
        private const val protectedPath = "${ApiPath.protectedPath}/markdown"
        private const val publicPath = "${ApiPath.publicPath}/markdown"



        const val findByName = "$publicPath/{name}"

        const val findByIdFull = "$protectedPath/full/{id}"
        const val findAllPaginated = "$protectedPath/all/{pageNumber}/{pageSize}"

        const val save = protectedPath
        const val update = protectedPath
        const val deleteById = "$protectedPath/{id}"
    }
}