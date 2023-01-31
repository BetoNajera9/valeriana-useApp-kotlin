package com.betonajera.valeriana_user_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var goToLogin = findViewById<TextView>(R.id.login_button)

        goToLogin.setOnClickListener{
            goToLogin()
        }
    }

    private fun goToLogin(){
        val i = Intent(this, HomeActivity::class.java)
        startActivity(i)
    }
}