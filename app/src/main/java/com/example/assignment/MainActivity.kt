package com.example.assignment

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // AutoCompleteTextView setup
        val autoCompleteTextView: AutoCompleteTextView = binding.menu
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            resources.getStringArray(R.array.pg_names)
        )
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            val selectedPG = adapter.getItem(position) as String
            showToast(selectedPG)
        }

        // Spinner1 setup
        val spinner1: Spinner? = binding.spinner1
        val courseOptions = arrayOf("Computer Science", "Information Technology", "Mechanical", "Chemical")
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, courseOptions)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        if (spinner1 != null) {
            spinner1.adapter = adapter1
        }
        if (spinner1 != null) {
            spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    val selectedCourse = parent.getItemAtPosition(position) as String
                    showToast(selectedCourse)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Handle case when nothing is selected.
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
