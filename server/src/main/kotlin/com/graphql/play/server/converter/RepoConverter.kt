package com.graphql.play.server.converter

import com.graphql.play.server.entity.RepoEntity
import com.graphql.play.server.model.RepoDto
import org.springframework.stereotype.Component

@Component
class RepoConverter : Converter<RepoDto, RepoEntity> {
    override fun convertEntity(entity: RepoEntity): RepoDto {

        val repo = RepoDto()
        repo.id = entity.id
        repo.name = entity.name ?: ""
        repo.url = entity.url ?: ""
        return repo
    }

    override fun convertModel(dto: RepoDto): RepoEntity {

        val repoEntity = RepoEntity()
        repoEntity.id = dto.id
        repoEntity.name = dto.name
        repoEntity.url = dto.url

        return repoEntity
    }
}