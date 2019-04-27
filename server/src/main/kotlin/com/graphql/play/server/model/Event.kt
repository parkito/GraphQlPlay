package com.graphql.play.server.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp

data class Event(
        var id: Long = -1,

        var type: String = "",

        var actor: Actor = Actor(),

        var repo: Repo = Repo(),

        @JsonProperty("created_at")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        var createdAt: Timestamp = Timestamp(0)
)