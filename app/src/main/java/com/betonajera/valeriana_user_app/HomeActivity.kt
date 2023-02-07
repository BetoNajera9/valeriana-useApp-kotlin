package com.betonajera.valeriana_user_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.betonajera.valeriana_user_app.databinding.ActivityHomeBinding
import com.betonajera.valeriana_user_app.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_calendar -> replaceFragment(CalendarFragment())
                R.id.nav_search -> replaceFragment(SearchFragment())
                R.id.nav_prescription -> replaceFragment(PrescriptionFragment())
                R.id.nav_profile -> replaceFragment(ProfileFragment())

                else -> {}
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManger = supportFragmentManager
        val fragmentTransaction = fragmentManger.beginTransaction()

        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}