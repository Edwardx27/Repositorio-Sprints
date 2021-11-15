package com.example.appgrupo13

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_search -> {
                Toast.makeText(this, R.string.text_action_search, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_settings -> {
                Toast.makeText(this, R.string.text_action_settings, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_logout -> {
                val intento = Intent(this, ToDoActivity::class.java)
                startActivity(intento)
                //Toast.makeText(this, R.string.text_action_logout, Toast.LENGTH_LONG).show()
                return true
            }
            else ->  return super.onOptionsItemSelected(item)
        }
    }

    fun onLogin(view: android.view.View) {
        val positiveButton = {
            dialog: DialogInterface, which: Int ->
            val intento = Intent(this, WelcomeActivity::class.java)
            intento.putExtra("username", edtUsername.text.toString())
            startActivity(intento)
        }

        val negativeButton = { _: DialogInterface, _: Int -> }

        if (edtUsername.text.toString().equals("lfa@gmail.com") && edtPassword.text.toString().equals("1234")){

            var dialog = AlertDialog.Builder(this )
                .setTitle("Welcome")
                .setMessage("User: " + edtUsername.text.toString())
                .setPositiveButton("ok", positiveButton )
                .setNegativeButton("cancel", negativeButton)
                .create()
                .show()
        }
        else {
            Toast.makeText(this, R.string.text_error_message, Toast.LENGTH_LONG).show()
     /*       var dialog = AlertDialog.Builder(this)
                .setTitle(R.string.text_error)
                .setMessage(R.string.text_error_message)
                .create().show() */
        }
    }

}