package com.graphql.play.server.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp

data class Event(
        val id: Long,

        val type: String,

        val actor: Actor,

        val repo: Repo,

        @JsonProperty("created_at")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        val createdAt: Timestamp
)