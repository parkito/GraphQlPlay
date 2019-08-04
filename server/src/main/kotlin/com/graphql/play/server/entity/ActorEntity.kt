package com.graphql.play.server.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class ActorEntity(
        @Column(unique = true)
        val login: String,

        @Column
        val avatar: String,

        @OneToMany(mappedBy = "actor")
        val events: List<EventEntity>

) : JpaPersistableEntity() {
}