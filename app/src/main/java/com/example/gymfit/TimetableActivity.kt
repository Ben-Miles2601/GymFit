package com.example.gymfit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.gymfit.R



class TimetableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)

        val submitButton: Button = findViewById(R.id.submitButton)
        submitButton.setOnClickListener {
            updateWorkoutSplits()
        }
    }

    private fun updateWorkoutSplits() {
        val mondaySplitInput: EditText = findViewById(R.id.mondaySplitInput)
        val tuesdaySplitInput: EditText = findViewById(R.id.tuesdaySplitInput)
        val wednesdaySplitInput: EditText = findViewById(R.id.wednesdaySplitInput)
        val thursdaySplitInput: EditText = findViewById(R.id.thursdaySplitInput)
        val fridaySplitInput: EditText = findViewById(R.id.fridaySplitInput)
        val saturdaySplitInput: EditText = findViewById(R.id.saturdaySplitInput)
        val sundaySplitInput: EditText = findViewById(R.id.sundaySplitInput)

        updateWorkoutSplit(R.id.mondayRow, mondaySplitInput.text.toString())
        updateWorkoutSplit(R.id.tuesdayRow, tuesdaySplitInput.text.toString())
        updateWorkoutSplit(R.id.wednesdayRow, wednesdaySplitInput.text.toString())
        updateWorkoutSplit(R.id.thursdayRow, thursdaySplitInput.text.toString())
        updateWorkoutSplit(R.id.fridayRow, fridaySplitInput.text.toString())
        updateWorkoutSplit(R.id.saturdayRow, saturdaySplitInput.text.toString())
        updateWorkoutSplit(R.id.sundayRow, sundaySplitInput.text.toString())
    }

    private fun updateWorkoutSplit(splitTextViewId: Int, workoutSplit: String) {
        val splitTextView: TextView = findViewById(splitTextViewId)
        splitTextView.text = workoutSplit
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
