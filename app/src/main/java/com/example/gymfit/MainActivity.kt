package com.example.gymfit
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gymfit.CalorieDeficitCalculatorActivity
import com.example.gymfit.MenuActivity
import com.example.gymfit.TimetableActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.gymfit.R


class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Launch HomeActivity
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_calculator -> {
                    val intent = Intent(this, CalorieDeficitCalculatorActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_timetable -> {
                    val intent = Intent(this, TimetableActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
