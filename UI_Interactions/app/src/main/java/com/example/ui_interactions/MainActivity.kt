package com.example.ui_interactions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    //on creation of activity, i.e when this screen is open
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // creates layout on screen

        //log cat shows the errors

        // listener which listens , when clicked i.e on clicking
        // click is an event
        btnAdd.setOnClickListener {
            //in case of empty string i.e no number is written
            // find view by id automatically using extensions , specified in build.gradle file
            // extracting editable text
            //passively
//            val var1 = try{
//                etVar1.text.toString().toInt()
//            } catch(e : NumberFormatException){
//                0
//            }
//            val var2 = try{
//                etVar2.text.toString().toInt()
//            } catch (e: NumberFormatException){
//                0
//            }

            val var1:Int
            val var2:Int
            try{
                var1 = etVar1.text.toString().toInt();
                var2 = etVar2.text.toString().toInt();
            }catch(e : NumberFormatException){
                AlertDialog.Builder(this)
                    .setTitle("Invalid operation")
                    .setMessage("Please enter both the numbers :)")
                    .setPositiveButton("OK") {dialog, _ -> dialog.dismiss()}
                    .setCancelable(false)
                    .show()
                return@setOnClickListener
            }


            val result = (var1 + var2).toString()
            // to show on screen we need to convert to string

            tvResult.text = result
            Toast.makeText(this, " ADD button clicked", Toast.LENGTH_SHORT).show()
            //small output for short duration length_short is 3sec long other is 5sec long

        }

    }

}