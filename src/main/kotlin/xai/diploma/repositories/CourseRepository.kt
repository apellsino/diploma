package xai.diploma.repositories

import xai.diploma.entities.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository: CrudRepository<Course, Long> {
    fun findByteacherid(teacherid: Int):Iterable<Course>
    fun findByname(name: String):Iterable<Course>
}