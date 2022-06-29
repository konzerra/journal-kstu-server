package com.konzerra.journal_kstu_server.domain.journal

class JournalReport(
    var name:String,
    var reviewers:MutableList<Reviewer> = mutableListOf()
) {
    fun addReviewer(name: String, email:String){
        val reviewer = Reviewer(name,email)

        reviewers.find {
            it.name == name && it.email == email
        }.apply {
            if(this!=null){
                this.articles++
            }
            else{
                reviewers.add(reviewer)
            }
        }
    }

    data class Reviewer(
        var name:String,
        var email:String,
        var articles:Int = 1
    )

    companion object{
        fun test(){
            val list = listOf(
                Reviewer("A","a"),
                Reviewer("C","c"),
                Reviewer("A","b"),
                Reviewer("A","a")
            )
            val journal  = JournalReport("Magazine 2022")
            list.forEach {
                journal.addReviewer(it.name,it.email)
            }
            journal.reviewers.forEach {
                println(it.name+" "+it.email+" "+it.articles)
            }

        }
    }

}