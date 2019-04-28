package com.graphql.play.server.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class RepoEntity : JpaPersistableEntity() {

    @Column(unique = true)
    var name: String? = null

    @Column
    var url: String? = null

    @OneToMany(mappedBy = "repo")
    var events: List<EventEntity> = ArrayList()
}