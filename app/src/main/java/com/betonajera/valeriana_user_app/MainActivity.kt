package com.betonajera.valeriana_user_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         var goToLogin = findViewById<TextView>(R.id.go_to_login_button)

        goToLogin.setOnClickListener{
            goToLogin()
        }
    }

    private fun goToLogin(){
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
    }
}