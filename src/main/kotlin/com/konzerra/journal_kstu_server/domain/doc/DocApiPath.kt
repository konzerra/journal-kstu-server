package com.konzerra.journal_kstu_server.domain.doc

import com.konzerra.journal_kstu_server.ApiPath

class DocApiPath {
    companion object{

        private const val protectedPath = "${ApiPath.protectedPath}/doc"
        private const val publicPath = "${ApiPath.publicPath}/doc"

        const val download = "$publicPath/{id}"
    }
}