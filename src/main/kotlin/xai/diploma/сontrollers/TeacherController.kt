package xai.diploma.сontrollers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import xai.diploma.entities.Teacher
import xai.diploma.repositories.TeacherRepository

@RestController
@RequestMapping("/api/teacher")
class TeacherController(@Autowired val teacherRepository: TeacherRepository) {

    @PostMapping("/add")
    fun addTeacher(@RequestParam("user_id") _user_id: Int,
                   @RequestParam("dept") _dept: Int,
                   @RequestParam("job") _job:Enum<Teacher.Job>): String {
        teacherRepository.save(Teacher(
                user = _user_id, dept = _dept, job = _job))
        return "teacher_id"
    }

    @GetMapping("/all")
    fun allTeachers() = teacherRepository.findAll()

    @RequestMapping("/dropAll")
    fun dropTeachers() {
        teacherRepository.deleteAll()
    }

    @GetMapping("/user/{user}")
    fun findByUserId(@PathVariable user:Int)
            = teacherRepository.findByuser(user)

    @GetMapping("/dept{dept}")
    fun findByDept(@PathVariable dept:Int)
            = teacherRepository.findBydept(dept)
}