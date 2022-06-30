package com.konzerra.journal_kstu_server.domain.reviewer

import com.konzerra.journal_kstu_server.ApiPath

class ReviewerApiPath {
    companion object{
        private const val protectedPath = "${ApiPath.protectedPath}/reviewer"
        private const val publicPath = "${ApiPath.publicPath}/reviewer"

        const val distribute = "$protectedPath/distribute"
        const val findArticles = "$protectedPath/articles/{id}"

        const val findById = "$publicPath/{id}"
        const val findByIdFull = "$protectedPath/full/{id}"
        const val findAllPaginated = "$protectedPath/all/{pageNumber}"

        const val save = protectedPath
        const val update = protectedPath
        const val deleteById = "$protectedPath/{id}"
    }
}