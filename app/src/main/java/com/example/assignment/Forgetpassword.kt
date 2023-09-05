package com.example.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.assignment.databinding.ActivityForgetpasswordBinding
import com.example.assignment.databinding.ActivityLoginUpBinding
import com.google.firebase.auth.FirebaseAuth

class Forgetpassword: AppCompatActivity() {
    private lateinit var binding: ActivityForgetpasswordBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forgetpassword)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.forgetPassword.setOnClickListener{
            val email = binding.email.editText?.text.toString()
            if(email.isEmpty())
            {
                Toast.makeText(this,"Please enter Your email",Toast.LENGTH_LONG).show()
            }
            else
            {
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener{task->
                    if(task.isSuccessful)
                    {
                        Toast.makeText(this,"Email sent successfully to reset your email",Toast.LENGTH_LONG).show()
                        val intent = Intent(this,LoginUpActivity::class.java)
                        startActivity(intent)
                    }
                    else
                    {
                        Toast.makeText(this,task.exception!!.message.toString(),Toast.LENGTH_LONG).show()
                    }

                }
            }
        }
    }
}