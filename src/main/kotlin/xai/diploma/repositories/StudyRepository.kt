package xai.diploma.repositories

import xai.diploma.entities.Study
import org.springframework.data.repository.CrudRepository

interface StudyRepository: CrudRepository<Study, Long> {
    fun findByuser(user: Int):Iterable<Study>
    fun findBystudent(student:Int):Iterable<Study>
    fun findBycourse(course:Int):Iterable<Study>
}

