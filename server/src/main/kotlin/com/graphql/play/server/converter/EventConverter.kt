package com.graphql.play.server.converter

import com.graphql.play.server.entity.EventEntity
import com.graphql.play.server.model.EventDto
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.ZoneOffset
import java.util.*

@Component
class EventConverter(
        private val actorConverter: ActorConverter,
        private val repoConverter: RepoConverter
) : Converter<EventDto, EventEntity> {

    override fun convertEntity(entity: EventEntity): EventDto {
        return EventDto(
                id = entity.id!!,
                type = entity.type,
                actorDto = actorConverter.convertEntity(entity.actor),
                createdAt = Timestamp(Date.from(entity.creationDate.toInstant(ZoneOffset.UTC)).time),
                repoDto = repoConverter.convertEntity(entity.repo)
        )
    }

    override fun convertModel(dto: EventDto): EventEntity {
        return EventEntity(
                actor = actorConverter.convertModel(dto.actorDto),
                type = dto.type,
                repo = repoConverter.convertModel(dto.repoDto)
        )
    }
}
