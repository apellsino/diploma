package xai.diploma.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import xai.diploma.entities.Course
import xai.diploma.repositories.CourseRepository

@RestController
@RequestMapping("/api/course")
class CourseController(@Autowired val courseRepository: CourseRepository) {

    @PostMapping("/add")
    fun addCourse(@RequestParam("teacher_id") _teacher_id: Int,
                  @RequestParam("name") _name: String,
                  @RequestParam("semester") _semester: Int,
                  @RequestParam("control_form") _control_form: Enum<Course.ControlForm>,
                  @RequestParam("lectures_num") _lectures_num: Int,
                  @RequestParam("labs_num") _labs_num: Int,
                  @RequestParam("pract_num") _pract_num: Int,
                  @RequestParam("modules_num") _modules_num: Int,
                  @RequestParam("control_approach") _control_approach: Enum<Course.ControlApproach>
                  ): String {
        courseRepository.save(Course(
                teacherid = _teacher_id, name = _name, semester = _semester,
                control_form = _control_form, lectures_num = _lectures_num, labs_num = _labs_num,
                pract_num = _pract_num, modules_num = _modules_num, control_approach = _control_approach ))
        return "course_id"
    }

    @GetMapping("/all")
    fun allCourses() = courseRepository.findAll()

    @RequestMapping("/dropAll")
    fun dropCourses() {
        courseRepository.deleteAll()
    }

    @GetMapping("/teacher/{teacherid}")
    fun findByTeacherId(@PathVariable teacherid:Int)
            = courseRepository.findByteacherid(teacherid)

    @GetMapping("/name/{name}")
    fun findByName(@PathVariable name:String)
            = courseRepository.findByname(name)

}