package com.example.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.assignment.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class SignupActivity : BaseActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.goToLoginBtn.setOnClickListener{
            val intent = Intent(this,LoginUpActivity::class.java)
            startActivity(intent)

        }
        binding.signUpBtn.setOnClickListener {
            val name = binding.Name.editText?.text.toString()
            val email = binding.email.editText?.text.toString()
            val password = binding.password.editText?.text.toString()
            val confirmPassword = binding.confirmPassword.editText?.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter Your Name", Toast.LENGTH_LONG).show()
            } else if (email.isEmpty()) {
                Toast.makeText(this, "Please enter your Email", Toast.LENGTH_LONG).show()
            } else if (password.isEmpty()) {
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_LONG).show()
            } else if (password.length < 8) {
                Toast.makeText(this, "Minimum password length should be 8", Toast.LENGTH_LONG).show()
            } else {
                val hasNumeric = password.any { it.isDigit() }
                val specialCharacters = "!@#$%^&*()_-+=<>?/[]{},.:;|"
                val hasSpecialCharacter = password.any { specialCharacters.contains(it) }

                if (!hasNumeric) {
                    Toast.makeText(
                        this,
                        "Password should contain at least 1 numeric character",
                        Toast.LENGTH_LONG
                    ).show()
                } else if (!hasSpecialCharacter) {
                    Toast.makeText(
                        this,
                        "Password should contain at least 1 special character",
                        Toast.LENGTH_LONG
                    ).show()
                } else if (confirmPassword.isEmpty()) {
                    Toast.makeText(this, "Please Enter your confirm password", Toast.LENGTH_LONG).show()
                } else if (password != confirmPassword) {
                    Toast.makeText(this, "Password and confirm Password do not match", Toast.LENGTH_LONG).show()
                } else {
                    // Perform signup
                    signup(email, password)
                }
            }
        }
    }

    private fun signup(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Signup success
                    Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,testing::class.java)
                    startActivity(intent)

                } else {
                    // Signup failed
                    val errorMessage = when (task.exception) {
                        is FirebaseAuthWeakPasswordException -> "Weak password. Password should be at least 8 characters."
                        is FirebaseAuthInvalidCredentialsException -> "Invalid email address."
                        is FirebaseAuthUserCollisionException -> "This email is already registered."
                        else -> "Signup failed. Please try again."
                    }
                    Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
                }
            }
    }
}
