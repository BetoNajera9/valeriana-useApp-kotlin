package com.betonajera.valeriana_user_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.betonajera.valeriana_user_app.util.PreferenceHelper
import com.betonajera.valeriana_user_app.util.PreferenceHelper.get
import com.betonajera.valeriana_user_app.util.PreferenceHelper.set

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferences = PreferenceHelper.defaultPrefs(this)
        if(preferences["session", false]){
            goToHome()
            println("false")
        } else{
            println("true")
        }

         val goToLogin = findViewById<TextView>(R.id.go_to_login_button)

        goToLogin.setOnClickListener{
            goToLogin()
        }
    }

    private fun goToLogin(){
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
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