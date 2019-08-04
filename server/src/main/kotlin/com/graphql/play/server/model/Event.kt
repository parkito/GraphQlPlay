package com.graphql.play.server.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import ru.siksmfp.kcomv.extension.data.type.constant.EMPTY
import ru.siksmfp.kcomv.extension.data.type.constant.MINUS_ONE
import java.sql.Timestamp

data class Event(
        val id: Long,

        val type: String,

        var actor: Actor,

        var repo: Repo = Repo(),

        @JsonProperty("created_at")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        var createdAt: Timestamp = Timestamp(0)
)