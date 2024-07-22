package com.st10449855.screentime

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityInput : AppCompatActivity() {
    private lateinit var editTextDay: EditText
    private lateinit var editTextMorningScreenTime: EditText
    private lateinit var editTextAfternoonScreenTime: EditText
    private lateinit var editTextActivityNotes: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonViewDetails: Button

    private val days = mutableListOf<String>()
    private val morningScreenTimes = mutableListOf<Float>()
    private val afternoonScreenTimes = mutableListOf<Float>()
    private val activityNotes = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input2)

        editTextDay = findViewById(R.id.editTextDay)
        editTextMorningScreenTime = findViewById(R.id.editTextMorningScreenTime)
        editTextAfternoonScreenTime = findViewById(R.id.editTextAfternoonScreenTime)
        editTextActivityNotes = findViewById(R.id.editTextActivityNotes)
        buttonSave = findViewById(R.id.buttonSave)
        buttonViewDetails = findViewById(R.id.buttonViewDetails)

        buttonSave.setOnClickListener {
            saveData()

        }
        buttonViewDetails.setOnClickListener {
            val intent = Intent(this, DetailedViewsActivity::class.java)
            intent.putExtra("DAY", days.toTypedArray())
            intent.putExtra("MORNING_Intake_in_Liters", morningScreenTimes.toFloatArray())
            intent.putExtra("AFTERNOON_Intake_in_Liters", afternoonScreenTimes.toFloatArray())
            intent.putExtra("Hydration_NOTES", activityNotes.toTypedArray())
            startActivity(intent)
        }
    }

    fun saveData() {
        val day = editTextDay.text.toString()
        val morningScreenTime = editTextMorningScreenTime.text.toString()
        val afternoonScreenTime = editTextAfternoonScreenTime.text.toString()
        val activityNote = editTextActivityNotes.text.toString()

        if (day.isNotEmpty() && morningScreenTime.isNotEmpty() && afternoonScreenTime.isNotEmpty()) {
            days.add(day)
            morningScreenTimes.add(morningScreenTime.toFloat())
            afternoonScreenTimes.add(afternoonScreenTime.toFloat())
            activityNotes.add(activityNote)

            Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show()

            // Clear the input fields
            editTextDay.text.clear()
            editTextMorningScreenTime.text.clear()
            editTextAfternoonScreenTime.text.clear()
            editTextActivityNotes.text.clear()
        } else {
            Toast.makeText(this, "Please enter valid data", Toast.LENGTH_SHORT).show()
        }
    }
}