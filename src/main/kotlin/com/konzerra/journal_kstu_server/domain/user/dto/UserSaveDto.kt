package com.konzerra.journal_kstu_server.domain.user.dto

import com.konzerra.journal_kstu_server._generic.data.SaveDtoI


class UserSaveDto(
    var name:String,
    var email:String,
    var password:String
) : SaveDtoI

