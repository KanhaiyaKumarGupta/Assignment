package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.Toast

class testing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)

        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.menu)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            resources.getStringArray(R.array.pg_names)
        )
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            val selectedPG = adapter.getItem(position) as String
            Toast.makeText(this,selectedPG,Toast.LENGTH_LONG).show()
        }

        val spinner1: Spinner? = findViewById(R.id.spinner1)
        val courseOptions = arrayOf("Dosa", "Sambar", "Idli")
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, courseOptions)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        if (spinner1 != null) {
            spinner1.adapter = adapter1
        }
        if (spinner1 != null) {
            spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    val selectedCourse = parent.getItemAtPosition(position) as String
                  //
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Handle case when nothing is selected.
                }
            }
        }

        val spinner2: Spinner? = findViewById(R.id.spinner2)
        val courseOptions1 = arrayOf("Dosa", "Sambar", "Idli")
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, courseOptions)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        if (spinner2 != null) {
            spinner2.adapter = adapter2
        }
        if (spinner2 != null) {
            spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    val selectedCourse = parent.getItemAtPosition(position) as String
                    //showToast(selectedCourse)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Handle case when nothing is selected.
                }
            }
        }

        val spinner3: Spinner? = findViewById(R.id.spinner3)
        val courseOptions2 = arrayOf("Dosa", "Sambar", "Idli")
        val adapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, courseOptions)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        if (spinner3!= null) {
            spinner3.adapter = adapter3
        }
        if (spinner3 != null) {
            spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    val selectedCourse = parent.getItemAtPosition(position) as String
                    //showToast(selectedCourse)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Handle case when nothing is selected.
                }
            }
        }
        val spinner4: Spinner? = findViewById(R.id.spinner4)
        val courseOptions3 = arrayOf("Dosa", "Sambar", "Idli")
        val adapter4 = ArrayAdapter(this, android.R.layout.simple_spinner_item, courseOptions)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        if (spinner4!= null) {
            spinner4.adapter = adapter4
        }
        if (spinner3 != null) {
            spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    val selectedCourse = parent.getItemAtPosition(position) as String
                    //showToast(selectedCourse)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Handle case when nothing is selected.
                }
            }
        }

        val spinner5: Spinner? = findViewById(R.id.spinner5)
        val courseOptions4 = arrayOf("Dosa", "Sambar", "Idli")
        val adapter5 = ArrayAdapter(this, android.R.layout.simple_spinner_item, courseOptions)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        if (spinner5!= null) {
            spinner5.adapter = adapter5
        }
        if (spinner5 != null) {
            spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    val selectedCourse = parent.getItemAtPosition(position) as String
                    //showToast(selectedCourse)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Handle case when nothing is selected.
                }
            }
        }

        val spinner6: Spinner? = findViewById(R.id.spinner6)
        val courseOptions5 = arrayOf("Dosa", "Sambar", "Idli")
        val adapter6 = ArrayAdapter(this, android.R.layout.simple_spinner_item, courseOptions)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        if (spinner6!= null) {
            spinner6.adapter = adapter6
        }
        if (spinner6 != null) {
            spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    val selectedCourse = parent.getItemAtPosition(position) as String
                    //showToast(selectedCourse)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Handle case when nothing is selected.
                }
            }
        }


    }
}