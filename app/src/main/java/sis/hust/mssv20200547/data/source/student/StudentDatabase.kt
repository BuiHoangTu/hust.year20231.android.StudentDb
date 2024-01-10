package sis.hust.mssv20200547.data.source.student

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StudentEntity::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
    companion object {
        @Volatile
        private var INSTANCE: StudentDatabase? = null
        fun getInstance(context: Context): StudentDatabase {
            // if null, lock thread then
            return INSTANCE ?: synchronized(this) {
                // check again if during lock, new instance created
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext, // context
                    StudentDatabase::class.java, // db class
                    "student_database" // db_file name
                ).fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it } // exec after done
            }
        }
    }
}