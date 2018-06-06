package xai.diploma.repositories

import xai.diploma.entities.Group
import org.springframework.data.repository.CrudRepository

interface GroupRepository: CrudRepository<Group, Long> {
    fun findBynum(num: String): Iterable<Group>
}