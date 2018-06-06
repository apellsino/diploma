package xai.diploma.repositories

import xai.diploma.entities.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository: CrudRepository<User, Long> {
    fun findBylastname1(lastname1: String): Iterable<User>
    fun findBylastname2(lastname2: String): Iterable<User>
    fun findBylastname3(lastname3: String): Iterable<User>

}