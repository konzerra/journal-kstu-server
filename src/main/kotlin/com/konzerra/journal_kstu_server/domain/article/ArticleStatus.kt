package com.konzerra.journal_kstu_server.domain.article

//Do not change
enum class ArticleStatus {
    Registered,
    InModeration,
    Published,
    RejectedByModerator,
    AcceptedByModerator,
    SkippedByModerator,

    RejectedByAdmin,
}