
package  com.konzerra.journal_kstu_server.domain.journal

import  com.konzerra.journal_kstu_server.ApiPath
    


class JournalApiPath {
    companion object{
        private const val protectedPath = "${ApiPath.protectedPath}/journal"
        private const val publicPath = "${ApiPath.publicPath}/journal"

        const val makeReport = "${protectedPath}/{id}"

        const val findAllByStatus = "$protectedPath/all-by-status/{status}"
        const val findAllArticlesPaginated = "$publicPath/{id}/articles/{pageNumber}"
        const val findById = "$publicPath/{id}"
        const val findByIdFull = "$protectedPath/full/{id}"
        const val findAllPaginated = "$publicPath/all/{pageNumber}"

        const val save = protectedPath
        const val update = protectedPath
        const val deleteById = "$protectedPath/{id}"
    }
}
    