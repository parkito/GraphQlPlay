package com.graphql.play.server.entity

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class JpaPersistableEntity : Serializable {

    companion object {
        private const val serialVersionUID = -5554308939380869754L
    }

    @Id
//    @GeneratedValue
    @Column(unique = true)
    var id: Long? = null

    @Column
    var creationDate: LocalDateTime = LocalDateTime.now()

    @Column
    var updateDate: LocalDateTime? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JpaPersistableEntity

        if (id != other.id) return false
        if (creationDate != other.creationDate) return false
        if (updateDate != other.updateDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + creationDate.hashCode()
        result = 31 * result + (updateDate?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "JpaPersistableEntity(id=$id, creationDate=$creationDate, updateDate=$updateDate)"
    }
}