package com.graphql.play.server.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class Actor(
        var id: Long,

        var login: String,

        @JsonProperty("avatar_url")
        var avatar: String

) : Serializable