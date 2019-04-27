package com.graphql.play.server.converter

import com.graphql.play.server.entity.EventEntity
import com.graphql.play.server.model.Event
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.ZoneOffset
import java.util.*

@Component
class EventConverter(@Autowired
                     private val actorConverter: ActorConverter,
                     @Autowired
                     private val repoConverter: RepoConverter) : Converter<Event, EventEntity> {

    override fun convertEntity(entity: EventEntity): Event {

        val event = Event()
        event.id = entity.id
        event.type = entity.type ?: ""
        event.createdAt = Timestamp(Date.from(entity.creationDate?.toInstant(ZoneOffset.UTC)).time)
        event.actor = actorConverter.convertEntity(entity.actor!!)
        event.repo = repoConverter.convertEntity(entity.repo!!)

        return event
    }

    override fun convertModel(event: Event): EventEntity {

        val eventEntity = EventEntity()
        eventEntity.id = event.id
        eventEntity.type = event.type
        eventEntity.creationDate = event.createdAt.toLocalDateTime()

        eventEntity.actor = actorConverter.convertModel(event.actor)
        eventEntity.repo = repoConverter.convertModel(event.repo)

        return eventEntity
    }
}
