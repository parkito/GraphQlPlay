package com.graphql.play.server.model.actor

import com.fasterxml.jackson.annotation.JsonProperty
import com.graphql.play.server.model.page.Paginated

data class ActorDto(
        val id: Long,

        val login: String,

        @JsonProperty("avatar_url")
        val avatar: String
) {
    class PagedActorDto : Paginated<ActorDto>()
}