package com.graphql.play.server.repository

import com.graphql.play.server.entity.ActorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ActorRepository : JpaRepository<ActorEntity, Long> {

    @Query(value = "SELECT ACTOR as ID, AVATAR, LOGIN, MAX(CREATION_DATE) as LATEST_EVENT, count(*) AS EVENT_COUNT " +
            "FROM EVENT_ENTITY INNER JOIN ACTOR_ENTITY ON EVENT_ENTITY.ACTOR = ACTOR_ENTITY.ID  " +
            "GROUP BY ID " +
            "ORDER BY EVENT_COUNT DESC, LATEST_EVENT DESC, LOGIN", nativeQuery = true)
    fun findActorsSortedByEvents(): List<ActorEntity>

    @Query(value = "SELECT a FROM ActorEntity a WHERE a.id NOT IN (SELECT e.actor FROM EventEntity e)")
    fun findActorsWithoutEvents(): List<ActorEntity>
}