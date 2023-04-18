package com.example.gymfit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.gymfit.CalorieDeficitCalculatorActivity
import com.example.gymfit.TimetableActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val navigateToTimetableButton = findViewById<Button>(R.id.navigateToTimetableButton)
        val navigateToCalorieDeficitCalculatorButton = findViewById<Button>(R.id.navigateToCalorieDeficitCalculatorButton)

        navigateToTimetableButton.setOnClickListener {
            val intent = Intent(this, TimetableActivity::class.java)
            startActivity(intent)
        }

        navigateToCalorieDeficitCalculatorButton.setOnClickListener {
            val intent = Intent(this, CalorieDeficitCalculatorActivity::class.java)
            startActivity(intent)
        }

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.menuPage // Change this based on the current activity

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuPage -> {
                    if (this::class.simpleName != MenuActivity::class.simpleName) {
                        startActivity(Intent(this, MenuActivity::class.java))
                    }
                }
                R.id.timetablePage -> {
                    if (this::class.simpleName != TimetableActivity::class.simpleName) {
                        startActivity(Intent(this, TimetableActivity::class.java))
                    }
                }
                R.id.calorieDeficitPage -> {
                    if (this::class.simpleName != CalorieDeficitCalculatorActivity::class.simpleName) {
                        startActivity(Intent(this, CalorieDeficitCalculatorActivity::class.java))
                    }
                }
            }
            true
        }
        setupBottomNavigation()
    }


}
