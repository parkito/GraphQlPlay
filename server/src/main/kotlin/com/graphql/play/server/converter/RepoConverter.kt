package com.graphql.play.server.converter

import com.graphql.play.server.entity.RepoEntity
import com.graphql.play.server.model.Repo
import org.springframework.stereotype.Component


@Component
class RepoConverter : Converter<Repo, RepoEntity> {
    override fun convertEntity(entity: RepoEntity): Repo {

        val repo = Repo()
        repo.id = entity.id
        repo.name = entity.name ?: ""
        repo.url = entity.url ?: ""
        return repo
    }

    override fun convertModel(dto: Repo): RepoEntity {

        val repoEntity = RepoEntity()
        repoEntity.id = dto.id
        repoEntity.name = dto.name
        repoEntity.url = dto.url

        return repoEntity
    }
}