package sis.hust.mssv20200547.data.source.student

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Insert
    suspend fun insert(user: StudentEntity)

    @Query("SELECT * FROM StudentEntity")
    suspend fun getAllStudents(): List<StudentEntity>
}