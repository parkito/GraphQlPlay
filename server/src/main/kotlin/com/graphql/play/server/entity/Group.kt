package com.graphql.play.server.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Group(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0
)