package com.konzerra.journal_kstu_server.domain.jwt.port.`in`

import com.konzerra.journal_kstu_server.ApiPath


class JwtApiPath {
    companion object{
        private const val basePath = "/authenticate/{lang}"
        const val publicPath = "${ApiPath.publicPath}$basePath"

        const val generateJwtTokenPath = publicPath

    }
}