package com.graphql.play.server.entity

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class EventEntity(
        @Column
        val type: String,

        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "actor")
        val actor: ActorEntity,

        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "repo")
        val repo: RepoEntity

) : JpaPersistableEntity()