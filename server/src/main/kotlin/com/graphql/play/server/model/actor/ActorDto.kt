package com.graphql.play.server.model.actor

import com.fasterxml.jackson.annotation.JsonProperty

data class ActorDto(
        val id: Long,

        val login: String,

        @JsonProperty("avatar_url")
        val avatar: String
)