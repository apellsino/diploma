package xai.diploma.entities

import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import com.vladmihalcea.hibernate.type.json.JsonStringType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import java.util.*
import javax.persistence.*

@TypeDefs(TypeDef(name = "json", typeClass = JsonStringType::class),
        TypeDef(name = "jsonb", typeClass = JsonBinaryType::class))
@Entity
@Table(name = "users")
data class User (
        @Id @GeneratedValue
        val user_id: Int = 0,
        val first_name_rus: String,
        val second_name_rus: String,
        @Column (name="last_name_rus")
        val lastname1: String,
        val first_name_ukr: String,
        val second_name_ukr: String,
        @Column (name="last_name_ukr")
        val lastname2: String,
        val first_name_eng: String,
        val second_name_eng: String,
        @Column (name="last_name_eng")
        val lastname3: String,
        val born_date: Date,
        @Type(type = "json")
        @Column(columnDefinition = "json")
        val contact: Contact,
        @Type(type = "json")
        @Column(columnDefinition = "json")
        val links: Links
) {

    class Contact (
            val phone: String,
            val email: String,
            val skype: String

    )

    class Links(
            val instagram: String,
            val vkontakte: String

    )

    override fun toString(): String {
        return "${this.first_name_rus} ${this.second_name_rus} ${this.lastname1}"
    }

}

/*@OneToMany(mappedBy = "user_id", cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
private var user_student: MutableList<Student>? = null*/