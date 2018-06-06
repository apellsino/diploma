package xai.diploma.entities

import javax.persistence.*

@Entity
@Table(name = "teachers")
data class Teacher(
        @Id @GeneratedValue
        val teacher_id: Int=0,
        @Column(name = "user_id")
        val user: Int,
        val dept: Int,
        val job: Enum<Job>
) {

    enum class Job(val value: String){
        ASSISTANT("Ассистент"),
        SENIOR_LECTURER("Старший преподаватель"),
        DOCENT("Доцент"),
        PROFESSOR("Профессор")
    }

}

/*@OneToMany(mappedBy = "taecher_id", cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
private var teacher: MutableList<Course>? = null*/