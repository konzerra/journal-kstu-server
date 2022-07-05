
package  com.konzerra.journal_kstu_server.domain.category

import  com.konzerra.journal_kstu_server.ApiPath



class CategoryApiPath {
    companion object{

        private const val protectedPath = "${ApiPath.protectedPath}/category"
        private const val publicPath = "${ApiPath.publicPath}/category"

        const val findAllPaginated = "$protectedPath/all/{pageNumber}/{pageSize}"
        const val findByIdPathFull = "$protectedPath/full/{id}"
        const val findByIdPath = "$publicPath/{id}"
        const val findAllPath = "$publicPath/all"

        const val savePath = protectedPath
        const val updatePath = protectedPath
        const val deleteByIdPath = "$protectedPath/{id}"
    }
}
    