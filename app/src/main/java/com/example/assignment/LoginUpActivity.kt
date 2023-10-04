package com.example.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.assignment.databinding.ActivityLoginUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class LoginUpActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var remember: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_up)

        firebaseAuth = FirebaseAuth.getInstance()

//        if(firebaseAuth.currentUser!=null)
//        {
//            Toast.makeText(this,"User already logged in",Toast.LENGTH_LONG).show()
//            startActivity(Intent(this,testing::class.java))
//        }

        val preferences = getSharedPreferences("checkbox", MODE_PRIVATE)
        val isRemembered = preferences.getBoolean("remember", false)
        binding.rememberMe.isChecked = isRemembered

        binding.goToSignupPage.setOnClickListener{
            val intent  = Intent(this,SignupActivity::class.java)
            startActivity(intent)

        }
        binding.signInBtn.setOnClickListener {
            val email = binding.email.editText?.text.toString()
            val password = binding.password.editText?.text.toString()
            if (email.isEmpty()) {
                Toast.makeText(this, "Please enter your Email", Toast.LENGTH_LONG).show()
            } else if (password.isEmpty()) {
                Toast.makeText(this, "Please enter your Password", Toast.LENGTH_LONG).show()
            } else {
                login(email, password)
                val editor = preferences.edit()
                editor.putBoolean("remember", binding.rememberMe.isChecked)
                editor.apply()
            }
        }
        binding.forgetPassword.setOnClickListener{
            val intent =  Intent(this,Forgetpassword::class.java)
            startActivity(intent)
        }

        binding.rememberMe.setOnCheckedChangeListener { _, isChecked ->
            val preferences = getSharedPreferences("checkbox", MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putBoolean("remember", isChecked)
            editor.apply()
            Toast.makeText(this, if (isChecked) "Checked" else "Unchecked", Toast.LENGTH_LONG).show()
        }

        binding.backButton.setOnClickListener {
            onBackPressed()
        }

    }

    private fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, testing::class.java)
                    startActivity(intent)

                } else {

                    val errorMessage = when (task.exception) {
                        is FirebaseAuthInvalidUserException -> "User not found. Please check your email."
                        is FirebaseAuthInvalidCredentialsException -> "Invalid password. Please try again."
                        else -> "Login failed. Please try again later."
                    }
                    Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
                }
            }
    }

}
