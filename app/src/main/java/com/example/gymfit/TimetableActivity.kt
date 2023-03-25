package com.example.gymfit

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TimetableActivity : AppCompatActivity() {
    private val timetable = mutableMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)

        val daySpinner = findViewById<Spinner>(R.id.daySpinner)
        val workoutSpinner = findViewById<Spinner>(R.id.workoutSpinner)
        val addWorkoutButton = findViewById<Button>(R.id.addWorkoutButton)
        val timetableTextView = findViewById<TextView>(R.id.timetableTextView)

        val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val workouts = arrayOf("Shoulders and Arms", "Chest and Back", "Legs")

        val dayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, days)
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        daySpinner.adapter = dayAdapter

        val workoutAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, workouts)
        workoutAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        workoutSpinner.adapter = workoutAdapter

        addWorkoutButton.setOnClickListener {
            val selectedDay = daySpinner.selectedItem.toString()
            val selectedWorkout = workoutSpinner.selectedItem.toString()
            timetable[selectedDay] = selectedWorkout
            updateTimetableTextView(timetableTextView)
        }
    }

    private fun updateTimetableTextView(textView: TextView) {
        val timetableText = timetable.entries.joinToString(separator = "\n") { "${it.key}: ${it.value}" }
        textView.text = timetableText
    }
}
