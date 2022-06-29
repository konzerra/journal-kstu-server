package com.konzerra.journal_kstu_server.domain.user.port.`in`

import com.konzerra.journal_kstu_server.ApiPath


class UserApiPath {
    companion object{
        private const val basePath = "/user"
        const val protectedPath = "${ApiPath.protectedPath}$basePath"
        const val publicPath = "${ApiPath.publicPath}$basePath"

        const val findByIdPath = "$publicPath/{lang}/{id}"
        const val findAllPath = "$publicPath/all/{lang}"

        const val savePath = "$publicPath/register"
        const val updatePath = protectedPath
        const val deleteByIdPath = "$protectedPath/{id}"
    }
}