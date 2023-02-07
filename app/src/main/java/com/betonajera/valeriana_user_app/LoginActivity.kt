package com.betonajera.valeriana_user_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.betonajera.valeriana_user_app.util.PreferenceHelper
import com.betonajera.valeriana_user_app.util.PreferenceHelper.set

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val goToHome = findViewById<TextView>(R.id.login_button)
        val emailEditText = findViewById<EditText>(R.id.emailText)
        val passwordEditText = findViewById<EditText>(R.id.passwordText)

        goToHome.setOnClickListener{
            val emailText = emailEditText.text.toString()
            val passwordText = passwordEditText.text.toString()

            if(emailText == "chivas99mn@hotmail.com"){
                if(passwordText == "password"){
                    goToHome()
                }
            }

        }
    }

    private fun goToHome(){
        val i = Intent(this, HomeActivity::class.java)
        createSessionPreference()
        startActivity(i)
        finish()
    }

    private fun createSessionPreference(){
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = true
    }
}