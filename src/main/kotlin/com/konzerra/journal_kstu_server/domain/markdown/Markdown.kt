package com.konzerra.journal_kstu_server.domain.markdown

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server.domain.markdown.markdown_data.MarkdownData
import javax.persistence.*


@Entity
class Markdown(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,

    var name:String,

    @OneToMany(cascade = [CascadeType.ALL])
    var dataList: List<MarkdownData> = emptyList()
):EntityI {
    fun dataByLanguage(lang:String): MarkdownData {
        var markdownData = MarkdownData(lang = lang)
        dataList.find {
            it.lang == lang
        }?.let {
            markdownData=it
        }
        return markdownData
    }
}