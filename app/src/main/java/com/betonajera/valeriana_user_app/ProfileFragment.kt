package com.betonajera.valeriana_user_app

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.betonajera.valeriana_user_app.util.PreferenceHelper
import com.betonajera.valeriana_user_app.util.PreferenceHelper.set

class ProfileFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val logoutBtn = view.findViewById<Button>(R.id.logout_button)
        logoutBtn.setOnClickListener{
            clearSessionPreference()
            goToLogin()
        }

        return view
    }

    private fun goToLogin(){
        val i = Intent(activity, MainActivity::class.java)
        startActivity(i)
    }

    private fun clearSessionPreference(){
        val preferences = activity?.let { PreferenceHelper.defaultPrefs(it) }
        preferences?.set("session", false)
    }
}