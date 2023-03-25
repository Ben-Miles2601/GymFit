package com.example.gymfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CalorieDeficitCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calorie_deficit_calculator)

        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        val calculateBmrButton = findViewById<Button>(R.id.calculateBmrButton)
        val bmrResultTextView = findViewById<TextView>(R.id.bmrResultTextView)

        calculateBmrButton.setOnClickListener {
            val weight = weightEditText.text.toString().toDoubleOrNull()
            val height = heightEditText.text.toString().toDoubleOrNull()
            val age = ageEditText.text.toString().toIntOrNull()

            if (weight != null && height != null && age != null) {
                val bmr = calculateBmr(weight, height, age)
                bmrResultTextView.text = String.format("BMR: %.2f", bmr)
            } else {
                Toast.makeText(this, "Please fill in all fields with valid numbers.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateBmr(weight: Double, height: Double, age: Int): Double {
        return 10 * weight + 6.25 * height - 5 * age + 5
    }
}
