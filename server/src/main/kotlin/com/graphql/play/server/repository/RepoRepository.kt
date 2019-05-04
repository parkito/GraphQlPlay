package com.graphql.play.server.repository

import com.graphql.play.server.entity.RepoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface RepoRepository : JpaRepository<RepoEntity, Long>, JpaSpecificationExecutor<RepoEntity>