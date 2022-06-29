package com.konzerra.journal_kstu_server.domain.user.dto


import com.konzerra.journal_kstu_server._generic.data.UpdateDtoI

class UserUpdateDto(
    var id: Long,
    var name: String
) : UpdateDtoI

