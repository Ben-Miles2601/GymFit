package com.example.gymfit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

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
    }
}
