package com.example.gymfit
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.gymfit.R
import com.example.gymfit.MenuActivity
import com.example.gymfit.TimetableActivity

fun AppCompatActivity.setupBottomNavigation(selectedItemId: Int) {
    val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
    bottomNavigationView.selectedItemId = selectedItemId

    bottomNavigationView.setOnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.menuPage -> {
                if (this !is MenuActivity) {
                    startActivity(Intent(this, MenuActivity::class.java))
                }
            }
            R.id.timetablePage -> {
                if (this !is TimetableActivity) {
                    startActivity(Intent(this, TimetableActivity::class.java))
                }
            }
            R.id.calorieDeficitPage -> {
                if (this !is CalorieDeficitCalculatorActivity) {
                    startActivity(Intent(this, CalorieDeficitCalculatorActivity::class.java))
                }
            }
        }
        true
    }
}
