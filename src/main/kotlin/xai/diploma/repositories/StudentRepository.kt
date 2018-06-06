package xai.diploma.repositories

import xai.diploma.entities.Student
import org.springframework.data.repository.CrudRepository

interface StudentRepository: CrudRepository<Student, Long> {
    fun findBydept(dept: Int):Iterable<Student>
    fun findBygroupid(groupid: Int):Iterable<Student>
    fun findByuserid(user: Int):Iterable<Student>
}
