package com.graphql.play.server.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

//@Component
class EventController : GraphQLQueryResolver {
    fun version() = "1.0.0"
}