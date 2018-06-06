package xai.diploma.сontrollers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import xai.diploma.entities.Group
import xai.diploma.repositories.GroupRepository

@RestController
@RequestMapping("/api/group")
class GroupController(@Autowired val groupRepository: GroupRepository) {

    @PostMapping("/add")
    fun addGroup(@RequestParam("num") _num: String,
                 @RequestParam("specialty") _specialty: String,
                 @RequestParam("course") _year: Int): String {
        groupRepository.save(Group(
                num = _num, specialty = _specialty, year = _year))
        return "group_id"
    }

    @GetMapping("/all")
    fun allGroups() = groupRepository.findAll()

    @RequestMapping("/dropAll")
    fun dropGroups() {
        groupRepository.deleteAll()
    }

    @GetMapping("/select/{num}")
    fun findBynum(@PathVariable num:String)
            = groupRepository.findBynum(num)

}