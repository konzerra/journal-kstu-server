package com.konzerra.journal_kstu_server.domain.reviewer.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseSave
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import com.konzerra.journal_kstu_server.domain.reviewer.dto.ReviewerSaveDto
import com.konzerra.journal_kstu_server.domain.reviewer_queue.port.out.ReviewerQueueOutPortFindByCategory
import com.konzerra.journal_kstu_server.domain.role.port.out.RoleOutPortFindByName
import com.konzerra.journal_kstu_server.domain.user.AppUser
import com.konzerra.journal_kstu_server.domain.user.UserRoles
import com.konzerra.journal_kstu_server.domain.user.port.out.UserOutPortFindByEmail
import com.konzerra.journal_kstu_server.exception.ResourceNotFoundException

@UseCase
class ReviewerUseCaseSaveImpl(
    private val reviewerOutPortSave: OutPortSave<Reviewer>,
    private val reviewerQueueOutPortFindByCategory: ReviewerQueueOutPortFindByCategory,
    private val userOutPortFindByEmail: UserOutPortFindByEmail,
    private val appUserOutPortSave: OutPortSave<AppUser>,
    private val roleOutPortFindByName: RoleOutPortFindByName,
    private val categoryOutPortFindById: OutPortFindById<Category,Long>
) : UseCaseSave<ReviewerSaveDto>{

    override fun execute(saveDto: ReviewerSaveDto) {
        val user = try{
            userOutPortFindByEmail.execute(saveDto.email)
        }catch (e:Exception){
            throw ResourceNotFoundException(
                className = "User",
                fieldName = "email",
                fieldValue = saveDto.email
            )
        }
        val hasRole = user.roles.find {
            it.name == UserRoles.Reviewer.toString()
        }
        if(hasRole==null){
            user.roles.add(roleOutPortFindByName.findByName(
                UserRoles.Reviewer.toString()
            ))
            appUserOutPortSave.execute(user)
            reviewerOutPortSave.execute(
                Reviewer(
                    appUser = user,
                    category = categoryOutPortFindById.execute(saveDto.categoryId),
                    active = true,
                    queue = reviewerQueueOutPortFindByCategory.execute(saveDto.categoryId)
                )
            )
        }
    }
}