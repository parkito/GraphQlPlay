package com.graphql.play.server.converter

import com.graphql.play.server.entity.ActorEntity
import com.graphql.play.server.model.Actor
import org.springframework.stereotype.Component
import java.util.*

@Component
class ActorConverter : Converter<Actor, ActorEntity> {

    override fun convertEntity(entity: ActorEntity): Actor {
        return Actor(
                id = entity.id!!,
                avatar = entity.avatar,
                login = entity.login
        )
    }

    override fun convertModel(dto: Actor): ActorEntity {
        return ActorEntity(
                login = dto.login,
                avatar = dto.avatar,
                events = Collections.emptyList()
        )
    }
}