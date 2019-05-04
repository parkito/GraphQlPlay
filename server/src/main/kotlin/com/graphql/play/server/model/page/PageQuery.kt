package com.graphql.play.server.model.page

import java.io.Serializable

data class PageQuery(
        val pageNumber: Int,
        val pageSize: Int,
        val sort: String? = null
) : Serializable