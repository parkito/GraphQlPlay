package com.graphql.play.server.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class ActorEntity : JpaPersistableEntity() {

    @Column(unique = true)
    var login: String? = null

    var avatar: String? = null

    @OneToMany(mappedBy = "actor")
    var events: List<EventEntity> = ArrayList<EventEntity>()
}