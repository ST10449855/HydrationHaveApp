package com.st10449855.screentime

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViewsActivity : AppCompatActivity() {

    private lateinit var textViewDayDetail: TextView
    private lateinit var textViewMorningScreenTimeDetail: TextView
    private lateinit var textViewAfternoonScreenTimeDetail: TextView
    private lateinit var textViewActivityNotesDetail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_views)

        textViewDayDetail = findViewById(R.id.textViewDayDetail)
        textViewMorningScreenTimeDetail = findViewById(R.id.textViewMorningScreenTimeDetail)
        textViewAfternoonScreenTimeDetail = findViewById(R.id.textViewAfternoonScreenTimeDetail)
        textViewActivityNotesDetail = findViewById(R.id.textViewActivityNotesDetail)

        val day = intent.getStringArrayExtra("DAY")?.toList()
        val morningScreenTime = intent.getFloatArrayExtra("MORNING_Intake_TIME")?.toList()
        val afternoonScreenTime = intent.getFloatArrayExtra("AFTERNOON_Intake_TIME")?.toList()
        val activityNotes = intent.getStringArrayExtra("Hydration_NOTES")?.toList()

        // Set data to TextViews
        textViewDayDetail.text = "Day: $day"
        textViewMorningScreenTimeDetail.text = "Morning Intake Time: $morningScreenTime "
        textViewAfternoonScreenTimeDetail.text = "Afternoon Intake Time: $afternoonScreenTime "
        textViewActivityNotesDetail.text = "Hydration Notes: $activityNotes"
    }
}