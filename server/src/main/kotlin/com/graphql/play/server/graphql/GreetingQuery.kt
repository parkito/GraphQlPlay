package com.graphql.play.server.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class GreetingQuery : GraphQLQueryResolver {

    fun getGreeting(): String {
        return "HI"
    }
}