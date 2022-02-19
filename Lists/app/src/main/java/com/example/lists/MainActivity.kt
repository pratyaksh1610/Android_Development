package com.example.lists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val courses = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
    21,22,23,24,25,26,27,28,29,30)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvNumbers.adapter = ArrayAdapter<Int>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            courses
        )
        lvNumbers.setOnItemClickListener{ _, _, position, _ ->
            Toast.makeText(this, "clicked on ${courses[position]}", Toast.LENGTH_SHORT).show()
        }

    }
}