package com.example.drugpandaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var numberEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var signUpButton: Button
    private lateinit var loginHereButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        emailEditText = findViewById(R.id.editTextTextEmailAddress)
        numberEditText = findViewById(R.id.editTextNumber)
        passwordEditText = findViewById(R.id.editTextPassword)
        confirmPasswordEditText = findViewById(R.id.editTextConfirmPassword)
        signUpButton = findViewById(R.id.btnSignUp)
        loginHereButton = findViewById(R.id.btnloginhere)

        signUpButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val number = numberEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            if (email.isNotEmpty() && number.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    //Saving User data
                    Toast.makeText(this, "SignUp Successful", Toast.LENGTH_SHORT).show()
                    //Adto siya sa dashboard after sign up
                    val intent = Intent(this, BottomNav::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
                } else {
                    Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                }
                loginHereButton.setOnClickListener {
                    val intent = Intent(this, LogIn::class.java)
                    startActivity(intent)
                }
            }
        }
    }