package com.graphql.play.server.service

import com.graphql.play.server.converter.EventConverter
import com.graphql.play.server.exception.ActorDoesNotExistException
import com.graphql.play.server.exception.EntityAlreadyExistsException
import com.graphql.play.server.model.EventDto
import com.graphql.play.server.repository.ActorRepository
import com.graphql.play.server.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class EventService(
        @Autowired
        private val eventRepository: EventRepository,
        @Autowired
        private val actorRepository: ActorRepository,
        @Autowired
        private val eventConverter: EventConverter) {

    fun getAll(): List<EventDto> {
        return eventConverter.convertEntities(eventRepository.findAllOrderById())
    }

    fun deleteAll() {
        eventRepository.deleteAll()
    }

    @Transactional
    fun save(eventDto: EventDto) {
        if (eventRepository.findByIdOrNull(eventDto.id) != null) {
            throw EntityAlreadyExistsException("Event with id = ${eventDto.id} already exists")
        }

        val eventEntity = eventConverter.convertModel(eventDto)
        eventRepository.save(eventEntity)
    }

    fun findByActor(actorId: Long?): List<EventDto> {
        if (actorRepository.findByIdOrNull(actorId) == null) {
            throw ActorDoesNotExistException("Can't find actor with id = $actorId")
        }
        return eventConverter.convertEntities(eventRepository.findByActorIdOrderById(actorId))
    }
}
