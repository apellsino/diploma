package xai.diploma.сontrollers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import xai.diploma.entities.User
import xai.diploma.repositories.UserRepository
import java.util.*

@RestController
@RequestMapping("/api/user")
class UserController(@Autowired val userRepository: UserRepository) {

    @PostMapping("/add")
    fun addUser(@RequestParam("first_name_rus") _first_name_rus: String,
                @RequestParam("second_name_rus") _second_name_rus: String,
                @RequestParam("lastname1") _last_name_rus: String,
                @RequestParam("first_name_ukr") _first_name_ukr: String,
                @RequestParam("second_name_ukr") _second_name_ukr: String,
                @RequestParam("lastname2") _last_name_ukr: String,
                @RequestParam("first_name_eng") _first_name_eng: String,
                @RequestParam("second_name_eng") _second_name_eng: String,
                @RequestParam("lastname3") _last_name_eng: String,
                @RequestParam("born_date") _born_date: Date,
                @RequestParam("contact") _contact: User.Contact,
                @RequestParam("links") _links: User.Links): String {
        userRepository.save(User(
                first_name_rus = _first_name_rus, second_name_rus = _second_name_rus, lastname1 = _last_name_rus,
                first_name_ukr = _first_name_ukr, second_name_ukr = _second_name_ukr, lastname2 = _last_name_ukr,
                first_name_eng = _first_name_eng, second_name_eng = _second_name_eng, lastname3 = _last_name_eng,
                born_date = _born_date, contact = _contact, links = _links))
        return "index"
    }

    @GetMapping("/all")
    fun allUsers() = userRepository.findAll()

    @RequestMapping("/dropAll")
    fun dropUsers() {
        userRepository.deleteAll()
    }

       @GetMapping("/selectrus/{lastname1}")
       fun findlastname1(@PathVariable lastname1:String)
               = userRepository.findBylastname1(lastname1)

       @GetMapping("/selectukr/{lastname2}")
       fun findBylastname2(@PathVariable lastname2:String)
               = userRepository.findBylastname2(lastname2)


       @GetMapping("/selecteng/{lastname3}")
       fun findBylastname3(@PathVariable lastname3:String)
               = userRepository.findBylastname3(lastname3)

}