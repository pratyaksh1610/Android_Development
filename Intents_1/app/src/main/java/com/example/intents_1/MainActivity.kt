package com.example.intents_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnBrowse.setOnClickListener{
            val url = et1.text.toString()
            if(url.isEmpty() || !url.startsWith("https://")) {
                AlertDialog.Builder(this)
                    .setTitle("Invalid address")
                    .setMessage("Write a valid URL :)")
                    .setPositiveButton("OK")  {dialog, _ -> dialog.dismiss()}
                    .setCancelable(false)
                    .show()
                return@setOnClickListener
            }
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        btnDial.setOnClickListener {
            val x = et2.text.toString()
            if (x.isEmpty() || x.toString().length != 10) {
                AlertDialog.Builder(this)
                    .setTitle("Invalid number")
                    .setMessage("Write a valid phone number :)")
                    .setPositiveButton("OK")  {dialog, _ -> dialog.dismiss()}
                    .setCancelable(false)
                    .show()
                return@setOnClickListener
            }
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$x"))
            startActivity(intent)
        }

    }

}