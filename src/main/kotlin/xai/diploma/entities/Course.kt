package xai.diploma.entities

import javax.persistence.*
import kotlin.Enum

@Entity
@Table(name = "courses")
data class Course(
        @Id @GeneratedValue
        val course_id: Int = 0,
        @Column(name = "teacher_id")
        val teacherid: Int,
        val name: String,
        val semester: Int,
        val control_form: Enum<ControlForm>,
        val lectures_num: Int,
        val labs_num: Int = 0,
        val pract_num: Int = 0,
        val modules_num: Int = 0,
        val control_approach: Enum<ControlApproach>
) {

    enum class ControlForm (val value: String) {
        EXAM("Экзамен"),
        DIFF_CREDIT("Дифференцированный зачёт"),
        CREDIT("Зачёт")
    }

    enum class ControlApproach (val value: String) {
        NONE("Нет"),
        COMP_GRAPH("Расчётная работа"),
        COMP_GRAPH_WORK("Расчётно-графическая работа"),
        COURSE_PROJECT("Курсовой проект"),
        COURSE_WORK("Курсовая работа")
    }

}

/*@OneToMany(mappedBy = "course_id", cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
private var course: MutableList<Study>? = null

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id")
private var course_user: User? = null

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "teacher_id")
private var course_teacher: Teacher? = null*/