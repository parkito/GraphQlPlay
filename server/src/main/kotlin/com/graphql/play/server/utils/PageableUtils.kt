package com.graphql.play.server.utils

import com.graphql.play.server.model.page.PageQuery
import com.graphql.play.server.model.page.PagedContent
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.util.*
import java.util.regex.Pattern

private const val DEFAULT_MAX_PAGE_SIZE = Integer.MAX_VALUE
private const val DEFAULT_PAGE_NUMBER = 0
private val SORT_STRING_PATTERN = Pattern.compile("(([^,]*),(asc|desc),?)*")
private val SORT_COLUMN_PATTERN = Pattern.compile("([^,]*),(asc|desc)")

fun constructPageable(page: Int, size: Int, field: String?, sortDirection: String?): Pageable {
    return if (field != null && sortDirection != null) {
        PageRequest.of(page, size, Sort(Sort.Direction.fromString(sortDirection), field))
    } else {
        PageRequest.of(page, size)
    }
}

fun constructPageable(page: Int, size: Int, sort: Sort): Pageable {
    return PageRequest.of(page, size, sort)
}

fun <T> paging(list: List<T>, pageable: Pageable): List<T> {
    val from = pageable.getPageNumber() * pageable.getPageSize()
    var to = from + pageable.getPageSize()
    val last = list.size
    if (from > last) {
        return Collections.emptyList()
    }
    if (to > last) {
        to = last
    }
    if (from == 0 && to == last) {
        return list
    }
    try {
        return list.subList(from, to)
    } catch (ex: Exception) {
        throw IllegalStateException("Incorrect pageble parameters", ex)
    }
}

fun convertPageQuery(pageQuery: PageQuery?): Pageable {
    //No pagination
    if (pageQuery == null) {
        return PageRequest.of(DEFAULT_PAGE_NUMBER, DEFAULT_MAX_PAGE_SIZE)
    }

    val pageSize = pageQuery.pageSize
    val pageNumber = pageQuery.pageNumber - 1

    if (pageQuery.sort == null) {
        return PageRequest.of(pageNumber, pageSize)
    }

    val orders = getOrdersBySort(pageQuery.sort)
    return PageRequest.of(pageNumber, pageSize, Sort.by(orders))
}

fun <T> toPagedContent(page: Page<T>): PagedContent<T> {
    return toPaged(page, page.content)
}

fun <E,M> toPagedContent(page: Page<E>, content: List<M>): PagedContent<M> {
    return toPaged(page, content)
}

fun getOrdersBySort(sort: String?): List<Sort.Order> {
    val orders = ArrayList<Sort.Order>()
    if (sort == null) {
        return orders
    }

    if (!SORT_STRING_PATTERN.matcher(sort).matches()) {
        throw IllegalArgumentException("Incorrect sort query")
    }

    val sortColumnsMatcher = SORT_COLUMN_PATTERN.matcher(sort)
    while (sortColumnsMatcher.find()) {
        orders.add(Sort.Order(Sort.Direction.fromString(sortColumnsMatcher.group(2)), sortColumnsMatcher.group(1)))
    }
    return orders
}

private fun <E,M> toPaged(page: Page<E>, content: List<M>): PagedContent<M> {
    return PagedContent(
            pageSize = page.size,
            pageNumber = page.number + 1,
            isFirstPage = page.isFirst,
            isLastPage = page.isLast,
            totalElements = page.totalElements,
            totalPages = page.totalPages,
            content = content
    )
}

