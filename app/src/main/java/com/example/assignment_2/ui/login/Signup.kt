package com.example.assignment_2.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.assignment_2.Data
import com.example.assignment_2.R
import com.example.assignment_2.Shopping
import com.example.assignment_2.User

class Signup : AppCompatActivity() {
    private val userList = Data.userList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_new_account)

        val nameEditText: EditText = findViewById(R.id.name)
        val mobileNumberEditText: EditText = findViewById(R.id.mobile_number)
        val passwordEditText: EditText = findViewById(R.id.password)
        val reEnterPasswordEditText: EditText = findViewById(R.id.re_enter_password)
        val createAccountButton: Button = findViewById(R.id.create_new_account)

        createAccountButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val emailOrPhone = mobileNumberEditText.text.toString()
            val password = passwordEditText.text.toString()
            val reEnterPassword = reEnterPasswordEditText.text.toString()

            if (validateForm(name, emailOrPhone, password, reEnterPassword)) {
                // Form is valid, proceed to save the user
                val user = User(name, emailOrPhone, password)
                saveUser(user)
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                val intent =  Intent(this, Login::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validateForm(
        name: String,
        emailOrPhone: String,
        password: String,
        reEnterPassword: String
    ): Boolean {
        // Perform your form validation here
        if (name.isEmpty() || emailOrPhone.isEmpty() || password.isEmpty() || reEnterPassword.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return false
        }

        if (userList.any {
                it.emailOrPhone == emailOrPhone
        }) {
            Toast.makeText(this, "Email/Phone already exists", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password != reEnterPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun saveUser(user: User) {
        // Add the user to the list
        userList.add(user)
    }
}