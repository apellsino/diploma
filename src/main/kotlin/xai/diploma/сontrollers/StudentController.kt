package xai.diploma.сontrollers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import xai.diploma.entities.Student
import xai.diploma.repositories.StudentRepository
import java.util.*

@RestController
@RequestMapping("/api/student")
class StudentController(@Autowired val studentRepository: StudentRepository) {

    @PostMapping("/add")
    fun addStudent(@RequestParam("userid") _user_id: Int,
                   @RequestParam("groupid") _group_id: Int,
                   @RequestParam("dept") _dept: Int,
                   @RequestParam("doc_id") _doc_id: Int,
                   @RequestParam("book_id") _book_id: Int,
                   @RequestParam("year") _year: Int,
                   @RequestParam("type") _type: Enum<Student.Role>,
                   @RequestParam("start_date") _start_date: Date,
                   @RequestParam("end_date") _end_date: Date): String {
        studentRepository.save(Student(
                userid = _user_id, groupid = _group_id, dept = _dept,
                doc_id = _doc_id, book_id = _book_id, year = _year,
                 type = _type,start_date = _start_date, end_date = _end_date))
        return "student_id"
    }

    @GetMapping("/all")
    fun allStudents() = studentRepository.findAll()

    @RequestMapping("/dropAll")
    fun dropStudents() {
        studentRepository.deleteAll()
    }

    @GetMapping("/user/{userid}")
    fun findUserId(@PathVariable userid:Int)
            = studentRepository.findByuserid(userid)

    @GetMapping("/group/{groupid}")
    fun findGroupId(@PathVariable groupid:Int)
            = studentRepository.findBygroupid(groupid)

    @GetMapping("/dept/{dept}")
    fun findDept(@PathVariable dept:Int)
            = studentRepository.findBydept(dept)

}