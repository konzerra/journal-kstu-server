package com.konzerra.journal_kstu_server.domain.journal

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.journal.journal_data.JournalData
import javax.persistence.*

@Entity
class Journal(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id:Long? = null,
    @OneToMany(cascade = [CascadeType.ALL])
    var dataList:List<JournalData> = emptyList(),

    var status:String,
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "journal")
    var articles: List<Article> = emptyList(),

) : EntityI{

    fun dataByLanguage(lang:String):JournalData{
        var journalData = JournalData(lang = lang)
        dataList.find {
            it.lang == lang
        }?.let {
          journalData=it
        }
        return journalData
    }
}