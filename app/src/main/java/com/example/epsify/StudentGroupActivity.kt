package com.example.epsify

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class StudentGroupActivity : AppCompatActivity() {
    fun <K, V> getKey(hashMap: Map<K, V>, target: V): K {
        return hashMap.filter { target == it.value }.keys.first()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun <K, V> buttonStudent(buttonStu: Button, mapStudent: Map<K, V>) {
        buttonStu.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentInfoActivity::class.java)
            mapStudent.forEach  { k, v ->
                newIntent.putExtra(
                    getKey(mapStudent, v) as String,
                    mapStudent.getValue(getKey(mapStudent, v)) as String
                )
            }
            startActivity(newIntent)
        })
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_group)
        val buttonStudent1: Button = findViewById(R.id.buttonStudent1)
        val buttonStudent2: Button = findViewById(R.id.buttonStudent2)
        val buttonStudent3: Button = findViewById(R.id.buttonStudent3)

        val student = listOf(
            mapOf(
                "avatar" to "jason",
                "student_info" to "Jeune et beau",
                "name" to "Richard",
                "forname" to "Jason",
                "mail" to "jason.richard@epsi.fr",
                "group" to "groupe epsify"
            ),
            mapOf(
                "avatar" to "alexandre",
                "student_info" to "Jeune et grand",
                "name" to "Alexandre",
                "forname" to "Stoppini",
                "mail" to "alexandre.stoppini@epsi.fr",
                "group" to "groupe epsify"
            ),
            mapOf(
                "avatar" to "jonathan",
                "student_info" to "Agé et expérimenté",
                "name" to "Jonathan",
                "forname" to "Dupau",
                "mail" to "jonathan.dupau@epsi.fr",
                "group" to "groupe epsify"
            )
        )




        buttonStudent(buttonStudent1, student[0])
        buttonStudent(buttonStudent2, student[1])
        buttonStudent(buttonStudent3, student[2])
    }

}