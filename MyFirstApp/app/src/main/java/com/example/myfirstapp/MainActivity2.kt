package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //what to show on screen, path is given res->layout->activity_main.xml
        //frame layout
        setContentView(R.layout.activity_main2)


    }
}