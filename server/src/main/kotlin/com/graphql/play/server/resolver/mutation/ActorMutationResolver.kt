package com.graphql.play.server.resolver.mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.graphql.play.server.model.actor.ActorDto
import com.graphql.play.server.service.ActorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ActorMutationResolver(
        @Autowired
        private val actorService: ActorService
) : GraphQLMutationResolver {

    fun save(actorDto: ActorDto) {
        actorService.save(actorDto)
    }
}