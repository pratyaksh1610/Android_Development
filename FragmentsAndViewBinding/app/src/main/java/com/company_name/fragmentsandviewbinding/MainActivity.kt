package com.company_name.fragmentsandviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Toast
import com.company_name.fragmentsandviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //view binding generated binding class to access views
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inflate layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tv.setOnClickListener {
            Toast.makeText(this, "Yes", Toast.LENGTH_LONG).show()
        }

//        no need now
//        setContentView(R.layout.activity_main)

        //if we do not use view binding then we can access those views from layout also which are not part of the setContentView that we set up
        //this caused NPE as it is not part of layout this activity is rendering
//        btnDemo.setOnClickListener{
//            Toast.makeText(this,"Fds",Toast.LENGTH_LONG).show()
//        }

        //view bindings avoids null pointer exception (NPE) and multiple referencing, and avoid confusion

        //how to reference text view in this activity

        binding.btn1.setOnClickListener {

            //replacing parent fragment from fragment 1
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl, fragment1())
                commit()
            }

        }

        binding.btn2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl, fragment2())
                commit()
            }
        }

    }
}