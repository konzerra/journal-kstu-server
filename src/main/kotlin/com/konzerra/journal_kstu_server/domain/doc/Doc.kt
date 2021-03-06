package com.konzerra.journal_kstu_server.domain.doc

import javax.persistence.*

//https://netbasal.com/how-to-implement-file-uploading-in-angular-reactive-forms-89a3fffa1a03
@Entity
class Doc(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id:Long? = null,
    var name:String,
    var mimeType :String,
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private var content: ByteArray
) {
}