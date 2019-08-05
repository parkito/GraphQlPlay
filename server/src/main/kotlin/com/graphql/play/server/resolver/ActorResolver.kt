package com.graphql.play.server.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.graphql.play.server.model.actor.ActorDto
import com.graphql.play.server.model.actor.PagedActorDto
import com.graphql.play.server.model.page.PageQuery
import com.graphql.play.server.service.ActorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ActorResolver(
        @Autowired
        private val actorService: ActorService
) : GraphQLQueryResolver {

    fun findAll(page: PageQuery): PagedActorDto {
        return actorService.findAll(page)
    }

    fun findById(id: Long): ActorDto {
        return actorService.findById(id)
    }
}
