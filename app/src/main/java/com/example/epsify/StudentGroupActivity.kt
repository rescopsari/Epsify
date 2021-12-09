package com.example.epsify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StudentGroupActivity : AppCompatActivity() {
    fun <K,V> getKey(hashMap: Map<K,V>, target: V):K{
        return hashMap.filter { target== it.value }.keys.first()
    }
    fun <K,V> buttonStudent (buttonStu : Button, mapStudent : Map<K,V>){

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonStudent1: Button = findViewById(R.id.buttonStudent1)
        val buttonStudent2: Button = findViewById(R.id.buttonStudent2)
        val buttonStudent3: Button = findViewById(R.id.buttonStudent3)
        val student = listOf(
            mapOf(
                "avatar" to "lien avatar",
                "student_info" to "Jeune et beau",
                "name" to "Richard",
                "forname" to "Jason",
                "mail" to "jason.richard@epsi.fr",
                "group" to "groupe epsify"
            ),
            mapOf(
                "avatar" to "lien avatar",
                "student_info" to "Jeune et beau",
                "name" to "Richard",
                "forname" to "Jason",
                "mail" to "jason.richard@epsi.fr",
                "group" to "groupe epsify"
            ),
            mapOf(
                "avatar" to "lien avatar",
                "student_info" to "Jeune et beau",
                "name" to "Richard",
                "forname" to "Jason",
                "mail" to "jason.richard@epsi.fr",
                "group" to "groupe epsify"
            )
        )

        buttonStudent1.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentGroupActivity::class.java)
            newIntent.putExtra(getKey(student[0], 0), student[0].getValue(getKey(student[0], 0)))
//            newIntent.putExtra("student_info", student[0][1])
//            newIntent.putExtra("name", student[0][2])
//            newIntent.putExtra("forname", student[0][3])
//            newIntent.putExtra("mail", student[0][4])
//            newIntent.putExtra("group", student[0][5])
            startActivity(newIntent)

        })

        buttonStudent2.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentGroupActivity::class.java)
            startActivity(newIntent)
        })

        buttonStudent3.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentGroupActivity::class.java)
            startActivity(newIntent)
        })
    }

}