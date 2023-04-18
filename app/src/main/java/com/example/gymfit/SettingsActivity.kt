package com.example.gymfit.ui.settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.gymfit.R
import com.example.gymfit.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.example.gymfit.LoginActivity
import com.example.gymfit.PermissionsActivity


class SettingsActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        auth = FirebaseAuth.getInstance()

        val userEmailTextView = findViewById<TextView>(R.id.user_email)
        val logoutButton = findViewById<Button>(R.id.logout_button)

        val currentUser = auth.currentUser
        if (currentUser != null) {
            userEmailTextView.text = currentUser.email
        }

        logoutButton.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        val permissionsButton = findViewById<Button>(R.id.permissions_button)

        permissionsButton.setOnClickListener {
            val intent = Intent(this, PermissionsActivity::class.java)
            startActivity(intent)
        }
        private fun pickImageFromGallery() {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, IMAGE_PICK_REQUEST)
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_REQUEST) {
                val imageUri = data?.data
                findViewById<ImageView>(R.id.profile_picture).setImageURI(imageUri)

            }
        }


    }
}
