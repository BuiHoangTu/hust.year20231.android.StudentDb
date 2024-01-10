package sis.hust.mssv20200547

import sis.hust.mssv20200547.data.source.student.StudentEntity
import java.time.LocalDate

class Student(
    val mssv: String,
    val name: String,
    val birthday: LocalDate,
    val homeTown: String,
) {
    constructor(
        studentEntity: StudentEntity
    ) : this(
        studentEntity.mssv,
        studentEntity.name,
        studentEntity.birthday,
        studentEntity.homeTown
    )

    val email: String
        get() {
            val nameParts = name.split(" ")
            val lastName = nameParts.last()
            val otherPartsName = nameParts
                .filter { it != lastName }
            val otherPartsNameFirstLetter = otherPartsName
                .map { it[0] }
                .joinToString("")
            return "$lastName.$otherPartsNameFirstLetter@sis.hust.edu.vn"
        }

}
