package com.graphql.play.server.converter

import com.graphql.play.server.entity.EventEntity
import com.graphql.play.server.model.Event
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.ZoneOffset
import java.util.*

@Component
class EventConverter(
        private val actorConverter: ActorConverter,
        private val repoConverter: RepoConverter
) : Converter<Event, EventEntity> {

    override fun convertEntity(entity: EventEntity): Event {
        return Event(
                id = entity.id!!,
                type = entity.type,
                actor = actorConverter.convertEntity(entity.actor),
                createdAt = Timestamp(Date.from(entity.creationDate.toInstant(ZoneOffset.UTC)).time),
                repo = repoConverter.convertEntity(entity.repo)
        )
    }

    override fun convertModel(dto: Event): EventEntity {
        return EventEntity(
                actor = actorConverter.convertModel(dto.actor),
                type = dto.type,
                repo = repoConverter.convertModel(dto.repo)
        )
    }
}
