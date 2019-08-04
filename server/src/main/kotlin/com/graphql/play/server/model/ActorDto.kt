package com.graphql.play.server.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class ActorDto(
        val id: Long,

        val login: String,

        @JsonProperty("avatar_url")
        val avatar: String

) : Serializable