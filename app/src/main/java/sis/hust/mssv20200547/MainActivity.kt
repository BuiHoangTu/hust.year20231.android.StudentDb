package sis.hust.mssv20200547

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sis.hust.mssv20200547.data.source.student.StudentDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val studentDao = StudentDatabase.getInstance(this).studentDao()
        lifecycleScope.launch(Dispatchers.IO) {
            val students = studentDao.getAllStudents()
            val recyclerView = findViewById<RecyclerView>(R.id.recycle_view)

            recyclerView.adapter = StudentAdapter(students.map { Student(it) }, this@MainActivity)
        }
    }
}