package com.example.assignment_2.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.example.assignment_2.Data
import com.example.assignment_2.R
import com.example.assignment_2.Shopping
import com.example.assignment_2.User

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val dummyUser = User("Santosh", "santosh", "santosh");
        Data.userList.add(dummyUser);

        val signIn: Button = findViewById(R.id.sign_in)
        val signUp: Button = findViewById(R.id.sign_up)
        val email: EditText = findViewById(R.id.email)

        val password: EditText = findViewById(R.id.password)


        val showPasswordCheckbox: CheckBox = findViewById(R.id.show_password)

        // Set default input type to password
        password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        // Set a listener for the checkbox to toggle password visibility
        showPasswordCheckbox.setOnCheckedChangeListener { _, isChecked ->
            // Toggle the password visibility based on the checkbox state
            password.inputType =
                if (isChecked) InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                else InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

            // Move the cursor to the end of the text after changing input type
            password.setSelection(password.text.length)
        }

        signIn.setOnClickListener(View.OnClickListener {

            val user: User? = Data.userList.find {
                it.emailOrPhone == email.text.toString()
            }
            if(user == null){
                Toast.makeText(this, "Invalid Email or password", Toast.LENGTH_SHORT).show()
            }else{
                if(user.password == password.text.toString()){
                    val intent =  Intent(this, Shopping::class.java)
                    Data.user  = user;
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Invalid Email or password", Toast.LENGTH_SHORT).show()
                }
            }
        })

        signUp.setOnClickListener(View.OnClickListener {
            val intent =  Intent(this, Signup::class.java)
            startActivity(intent)
        })

    }
}