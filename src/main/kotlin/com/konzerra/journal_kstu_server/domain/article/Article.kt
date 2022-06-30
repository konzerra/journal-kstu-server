package com.konzerra.journal_kstu_server.domain.article

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server.domain.article.article_data.ArticleData
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.doc.Doc
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import com.konzerra.journal_kstu_server.domain.user.AppUser
import javax.persistence.*

@Entity
class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,

    var status: String,

    var antiplagiat : String? = null,

    @ManyToOne
    var owner:AppUser,

    @OneToOne(fetch = FetchType.LAZY)
    var reviewer: Reviewer? = null,

    var reviewerComment:String? = null,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var dataList: List<ArticleData> =emptyList(),

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH])
    var journal: Journal,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH])
    var category: Category? = null,


    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var wordDoc: Doc? = null,

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var pdfDoc: Doc? = null,

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var reviewerBlankDoc: Doc? = null,

    var pagesInJournal:String? = null,

    //private val paid: String? = null
) : EntityI{

    fun dataByLanguage(lang:String): ArticleData {
        var articleData = ArticleData(lang = lang)
        dataList.find {
            it.lang == lang
        }?.let {
            articleData=it
        }
        return articleData
    }
}