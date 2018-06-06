package xai.diploma.repositories

import xai.diploma.entities.Teacher
import org.springframework.data.repository.CrudRepository

interface TeacherRepository: CrudRepository<Teacher, Long> {
    fun findByuser(user: Int): Iterable<Teacher>
    fun findBydept(dept: Int): Iterable<Teacher>
}

