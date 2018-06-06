package xai.diploma.сontrollers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import xai.diploma.entities.*
import xai.diploma.repositories.StudyRepository

@RestController
@RequestMapping("/api/study")
class StudyController(@Autowired val studyRepository: StudyRepository) {

    @PostMapping("/add")
    fun addStudy(@RequestParam("user_id") _user_id: Int,
                 @RequestParam("student_id") _student_id: Int,
                 @RequestParam("course_id") _course_id: Int,
                 @RequestParam("modules") _modules: Study.Modules,
                 @RequestParam("lectures") _lectures: Study.Lectures,
                 @RequestParam("labs") _labs: Study.Labs,
                 @RequestParam("pract") _pract: Study.Pract,
                 @RequestParam("control") _control: Study.Control,
                 @RequestParam("mark") _mark: Int,
                 @RequestParam("pass") _pass: Enum<Study.Pass>): String {
        studyRepository.save(Study(
                user = _user_id, student = _student_id, course = _course_id,
                modules = _modules, lectures = _lectures, labs = _labs, pract = _pract,
                control = _control, mark = _mark, pass = _pass))
        return "index"
    }

    @GetMapping("/all")
    fun allStudies() = studyRepository.findAll()

    @RequestMapping("/dropAll")
    fun dropStudies() {
        studyRepository.deleteAll()
    }

    @GetMapping("/user/{user}")
    fun findByUserId(@PathVariable user:Int)
            = studyRepository.findByuser(user)

    @GetMapping("/student/{student}")
    fun findByStudent(@PathVariable student:Int)
            = studyRepository.findBystudent(student)

    @GetMapping("/course/{course}")
    fun findByCourse(@PathVariable course:Int)
            = studyRepository.findBycourse(course)
}