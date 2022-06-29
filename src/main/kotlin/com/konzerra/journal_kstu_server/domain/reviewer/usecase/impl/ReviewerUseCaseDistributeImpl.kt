package com.konzerra.journal_kstu_server.domain.reviewer.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.article.Article
import com.konzerra.journal_kstu_server.domain.article.ArticleStatus
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import com.konzerra.journal_kstu_server.domain.reviewer.usecase.ReviewerUseCaseDistribute
import com.konzerra.journal_kstu_server.domain.reviewer_queue.ReviewerQueue
import com.konzerra.journal_kstu_server.domain.reviewer_queue.port.out.ReviewerQueueOutPortFindByCategory

@UseCase
class ReviewerUseCaseDistributeImpl(
    private val journalOutPortFindById: OutPortFindById<Journal,Long>,
    private val articleOutPortSave: OutPortSave<Article>,
    private val reviewerQueueOutPortFindByCategory: ReviewerQueueOutPortFindByCategory,
    private val reviewerQueueOutPortSave: OutPortSave<ReviewerQueue>,
) : ReviewerUseCaseDistribute {
    override fun execute(journalId:Long): String {
        val articles = journalOutPortFindById.execute(journalId).articles
        var responseResult = ""
        articles.forEach { article->
            if(article.reviewer==null
                && article.status==ArticleStatus.InModeration.toString()
            ){
                responseResult += distribute(article)
            }

        }
        return responseResult.ifEmpty { "Все статьи распределены по рецензентам" }
    }


    //returns result of distribution as message
    //returns nothing if no distribution performed
    private fun distribute(article: Article):String{

        if(article.category == null){
            return "\nСтатья с id: ${article.id} не имеет категории"
        }
        article.category?.id?.let { categoryId ->
            val reviewerQueue = reviewerQueueOutPortFindByCategory.execute(categoryId)


            var reviewer: Reviewer? = null
            try {
                reviewer = reviewerQueue.list.removeFirst()
                article.reviewer = reviewer
                reviewerQueue.list.add(reviewer)

                reviewerQueueOutPortSave.execute(reviewerQueue)
                articleOutPortSave.execute(article)

            } catch (e: Exception) {
                return "\nСтатья с id: ${article.id} не может " +
                        "получить рецензента, [по категории с " +
                        "id: $categoryId не найден рецензент]"
            }
        }
        return ""
    }

}