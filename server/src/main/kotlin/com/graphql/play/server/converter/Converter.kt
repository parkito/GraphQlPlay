package com.graphql.play.server.converter

interface Converter<D, E> {

    fun convertEntity(entity: E): D

    fun convertModel(dto: D): E

    fun convertEntities(entities: List<E>): List<D> {
        return entities.map(this::convertEntity)
                .toList()
    }

    fun convertModels(dtos: List<D>): List<E> {
        return dtos.map(this::convertModel)
                .toList()
    }
}