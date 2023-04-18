package com.example.gymfit.ui.permissions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.gymfit.R

class PermissionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)
        val backButton = findViewById<Button>(R.id.back_button)

        backButton.setOnClickListener {
            finish()
        }

    }
}
