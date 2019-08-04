package com.graphql.play.server.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp

data class EventDto(
        val id: Long,

        val type: String,

        var actorDto: ActorDto,

        var repoDto: RepoDto = RepoDto(),

        @JsonProperty("created_at")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        var createdAt: Timestamp = Timestamp(0)
)