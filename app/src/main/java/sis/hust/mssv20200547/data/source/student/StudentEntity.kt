package sis.hust.mssv20200547.data.source.student

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class StudentEntity(
    @PrimaryKey val id: Int,
    val mssv: String,
    val name: String,
    val birthday: String,
    val homeTown: String
)
