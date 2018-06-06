package xai.diploma.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "students")
data class Student (
        @Id @GeneratedValue
        val student_id: Int=0,
        @Column(name = "user_id")
        val userid: Int,
        @Column(name = "group_id")
        val groupid: Int,
        val dept: Int,
        val doc_id: Int,
        val book_id: Int,
        val year: Int,
        val type: Enum<Role>,
        val start_date: Date,
        val end_date: Date
) {

    enum class Role (val value: String) {
        STUDENT_ONE("Студент"),
        CLASS_LEADER("Староста"),
        DEPUTY_CLASS_LEADER("Заместитель старосты"),
        PROFESSIONAL_ORGANIZER("Профорг")
    }

}

/*@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id")
private var student_user: User? = null

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "group_id")
private var student_group: Group? = null*/