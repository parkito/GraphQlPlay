package com.graphql.play.server.model.page

import java.util.*

open class Paginated<T>(
        val pageInfo: PageInfo = PageInfo.EMPTY_PAGE,
        val content: List<T> = Collections.emptyList()
)