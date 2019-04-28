package com.graphql.play.server.entity

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class EventEntity : JpaPersistableEntity() {

    @Column
    var type: String? = null

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "actor")
    var actor: ActorEntity? = null

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "repo")
    var repo: RepoEntity? = null
}