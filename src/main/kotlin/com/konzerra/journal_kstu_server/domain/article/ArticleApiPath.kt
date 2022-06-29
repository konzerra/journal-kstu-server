
package  com.konzerra.journal_kstu_server.domain.article

import  com.konzerra.journal_kstu_server.ApiPath
    


class ArticleApiPath {
    companion object{
        private const val basePath = "/article"
        private const val protectedPath = "${ApiPath.protectedPath}$basePath"
        private const val publicPath = "${ApiPath.publicPath}/article"

        const val findById = "$publicPath/{lang}/{id}"
        const val findByIdFull = "$protectedPath/full/{id}"
        const val savePath = protectedPath
        const val updatePathByAdmin = "${protectedPath}/admin"
        const val updatePathByReviewer = "${protectedPath}/reviewer"
        const val deleteByIdPath = "$protectedPath/{id}"
    }
}
    