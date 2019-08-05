package com.graphql.play.server.model.page

data class PageInfo(
        val pageSize: Int,
        val pageNumber: Int,
        val isFirstPage: Boolean,
        val isLastPage: Boolean,
        val totalElements: Long,
        val totalPages: Int
) {
    companion object {
        val EMPTY_PAGE = PageInfo(
                pageSize = 0,
                pageNumber = 0,
                isFirstPage = false,
                isLastPage = false,
                totalElements = 0,
                totalPages = 0
        )
    }
}