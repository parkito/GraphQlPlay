package com.graphql.play.server.converter

import com.graphql.play.server.entity.ActorEntity
import com.graphql.play.server.model.actor.ActorDto
import org.springframework.stereotype.Component
import java.util.*

@Component
class ActorConverter : Converter<ActorDto, ActorEntity> {

    override fun convertEntity(entity: ActorEntity): ActorDto {
        return ActorDto(
                id = entity.id!!,
                avatar = entity.avatar,
                login = entity.login
        )
    }

    override fun convertModel(dto: ActorDto): ActorEntity {
        return ActorEntity(
                login = dto.login,
                avatar = dto.avatar,
                events = Collections.emptyList()
        )
    }
}