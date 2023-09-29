package com.codingwithmitch.espressouitestexamples

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    private val TAG: String = "AppDebug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_launch_dialog).setOnClickListener {
            showDialog()
        }

    }

    private fun showDialog(){

        val builder : AlertDialog.Builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val dialogView = inflater.inflate(R.layout.dialog_name, null)

        builder
            .setMessage("Type your name")
            .setView(dialogView)
            .setPositiveButton(R.string.text_ok){ dialog, id ->
                setNameToTextView(dialogView.findViewById<EditText>(R.id.etUserName).text.toString())
                dialog.cancel()
            }
            .create().show()
    }

    private fun setNameToTextView(name: String){
        findViewById<TextView>(R.id.text_name).text = name
    }

}















