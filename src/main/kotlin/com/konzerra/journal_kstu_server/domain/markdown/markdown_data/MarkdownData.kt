package com.konzerra.journal_kstu_server.domain.markdown.markdown_data

import com.konzerra.journal_kstu_server._generic.data.EntityI
import javax.persistence.*


@Entity
class MarkdownData(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,
    var lang:String,
    @Column(columnDefinition = "TEXT")
    var source:String = "no translation"
): EntityI {
}