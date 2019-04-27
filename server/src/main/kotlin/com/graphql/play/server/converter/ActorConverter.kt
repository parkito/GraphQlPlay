package com.graphql.play.server.converter

import com.graphql.play.server.entity.ActorEntity
import com.graphql.play.server.model.Actor
import org.springframework.stereotype.Component

@Component
class ActorConverter : Converter<Actor, ActorEntity> {
    override fun convertEntity(entity: ActorEntity): Actor {

        val actor = Actor()
        actor.id = entity.id!!
        actor.avatar = entity.avatar ?: ""
        actor.login = entity.login
        return actor
    }

    override fun convertModel(dto: Actor): ActorEntity {

        val actorEntity = ActorEntity()
        actorEntity.id = dto.id
        actorEntity.avatar = dto.avatar
        actorEntity.login = dto.login

        return actorEntity
    }
}