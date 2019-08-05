package com.graphql.play.server.service

import com.graphql.play.server.converter.ActorConverter
import com.graphql.play.server.exception.ActorDoesNotExistException
import com.graphql.play.server.model.actor.ActorDto
import com.graphql.play.server.model.page.PageQuery
import com.graphql.play.server.repository.ActorRepository
import com.graphql.play.server.utils.convertPageQuery
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ActorService(
        val actorRepository: ActorRepository,
        val actorConverter: ActorConverter) {

    fun findById(id: Long): ActorDto {
        return actorRepository.findByIdOrNull(id)?.let {
            actorConverter.convertEntity(it)
        } ?: throw ActorDoesNotExistException("Actor with id = $id doesn't exist")
    }

    fun updateAvatar(id: Long, url: String) {
        actorRepository.updateAvatar(id, url)
    }

    fun findAll(query: PageQuery): ActorDto.PagedActorDto {
        val page = actorRepository.findAll(convertPageQuery(query))
//        return toPagedContent(page, actorConverter.convertEntities(page.content))
        return ActorDto.PagedActorDto()
    }
}