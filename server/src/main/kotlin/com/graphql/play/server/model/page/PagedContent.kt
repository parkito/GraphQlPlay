package com.graphql.play.server.model.page

import java.io.Serializable
import java.util.*

data class PagedContent<T>(
        val pageSize: Int = 0,
        val pageNumber: Int = 0,
        val isFirstPage: Boolean = false,
        val isLastPage: Boolean = false,
        val totalElements: Long = 0,
        val totalPages: Int = 0,
        val content: List<T> = Collections.emptyList()
) : Serializable