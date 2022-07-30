package com.example.notesrecyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val todoList = mutableListOf(
        NotesData("task 1", false),
        NotesData("task 2", true),
        NotesData("task 3", false),
        NotesData("task 4", true),
        NotesData("task 5", false)
    )

    private val adapter = NotesAdapter(todoList, this)

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //to-do list without saving data in database

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        btnAdd.setOnClickListener {
            val t = et.text.toString()
            if (t.isNotEmpty()) {
                val obj = NotesData(t, true)
                todoList.add(obj)
                adapter.notifyDataSetChanged()
                adapter.notifyItemInserted(todoList.size - 1)
            } else {
                return@setOnClickListener
            }
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun callDel(position: Int) {
        todoList.removeAt(position)
        adapter.notifyDataSetChanged()
    }
}