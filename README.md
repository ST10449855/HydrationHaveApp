<div align="center">
  <h1 align="center">Hydration Haven App</h1>
  <h2>Introduction</h2>
  <p>Welcome to an application that keeps track of how much water you drink in a day.
  This app was created so that it could help students that drink to much caffeine then they should, instead they should drink water.</p>
  <h3>How will the App </h3>
  <p>class MainActivity extends AppCompatActivity {

    // Declare UI components
    private ImageView imageView
    private TextView textView
    private TextView textView2
    private Button Openbutton
    private Button Exitbutton

    onCreate(savedInstanceState) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize UI components
        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        Openbutton = findViewById(R.id.button)
        Exitbutton = findViewById(R.id.button2)

        // Set click listeners for buttons
        Openbutton.setOnClickListener {
            // Navigate to ActivityInput
            Intent intent = new Intent(this, ActivityInput.class)
            startActivity(intent)
            finish() // Finish MainActivity
        }

        Exitbutton.setOnClickListener {
            // Exit the application
            finish()
        }
    }
}
class ActivityInput extends AppCompatActivity {

    // Declare UI components and data lists
    private EditText editTextDay
    private EditText editTextMorningScreenTime
    private EditText editTextAfternoonScreenTime
    private EditText editTextActivityNotes
    private Button buttonSave
    private Button buttonViewDetails

    private List<String> days = new ArrayList<String>()
    private List<Float> morningScreenTimes = new ArrayList<Float>()
    private List<Float> afternoonScreenTimes = new ArrayList<Float>()
    private List<String> activityNotes = new ArrayList<String>()

    onCreate(savedInstanceState) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input2)

        // Initialize UI components
        editTextDay = findViewById(R.id.editTextDay)
        editTextMorningScreenTime = findViewById(R.id.editTextMorningScreenTime)
        editTextAfternoonScreenTime = findViewById(R.id.editTextAfternoonScreenTime)
        editTextActivityNotes = findViewById(R.id.editTextActivityNotes)
        buttonSave = findViewById(R.id.buttonSave)
        buttonViewDetails = findViewById(R.id.buttonViewDetails)

        // Set click listener for save button
        buttonSave.setOnClickListener {
            saveData()
        }

        // Set click listener for view details button
        buttonViewDetails.setOnClickListener {
            // Navigate to DetailedViewsActivity and pass data
            Intent intent = new Intent(this, DetailedViewsActivity.class)
            intent.putExtra("DAY", days.toArray(new String[days.size()]))
            intent.putExtra("MORNING_Intake_TIME", toFloatArray(morningScreenTimes))
            intent.putExtra("AFTERNOON_Intake_TIME", toFloatArray(afternoonScreenTimes))
            intent.putExtra("Hydration_NOTES", activityNotes.toArray(new String[activityNotes.size()]))
            startActivity(intent)
        }
    }

    saveData() {
        // Retrieve data from input fields
        String day = editTextDay.getText().toString()
        Float morningScreenTime = Float.parseFloat(editTextMorningScreenTime.getText().toString())
        Float afternoonScreenTime = Float.parseFloat(editTextAfternoonScreenTime.getText().toString())
        String activityNote = editTextActivityNotes.getText().toString()

        // Validate and save data
        if (day.isNotEmpty() && morningScreenTime != null && afternoonScreenTime != null) {
            days.add(day)
            morningScreenTimes.add(morningScreenTime)
            afternoonScreenTimes.add(afternoonScreenTime)
            activityNotes.add(activityNote)

            // Show success message
            showToast("Data saved successfully!")

            // Clear input fields
            editTextDay.setText("")
            editTextMorningScreenTime.setText("")
            editTextAfternoonScreenTime.setText("")
            editTextActivityNotes.setText("")
        } else {
            // Show error message
            showToast("Please enter valid data")
        }
    }
}
class DetailedViewsActivity extends AppCompatActivity {

    // Declare UI components
    private TextView textViewDayDetail
    private TextView textViewMorningScreenTimeDetail
    private TextView textViewAfternoonScreenTimeDetail
    private TextView textViewActivityNotesDetail

    onCreate(savedInstanceState) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_views)

        // Initialize UI components
        textViewDayDetail = findViewById(R.id.textViewDayDetail)
        textViewMorningScreenTimeDetail = findViewById(R.id.textViewMorningScreenTimeDetail)
        textViewAfternoonScreenTimeDetail = findViewById(R.id.textViewAfternoonScreenTimeDetail)
        textViewActivityNotesDetail = findViewById(R.id.textViewActivityNotesDetail)

        // Retrieve data from intent extras
        List<String> dayList = Arrays.asList(getIntent().getStringArrayExtra("DAY"))
        List<Float> morningScreenTimeList = Arrays.asList(getIntent().getFloatArrayExtra("MORNING_Intake_TIME"))
        List<Float> afternoonScreenTimeList = Arrays.asList(getIntent().getFloatArrayExtra("AFTERNOON_Intake_TIME"))
        List<String> activityNotesList = Arrays.asList(getIntent().getStringArrayExtra("Hydration_NOTES"))

        // Display data in TextViews
        textViewDayDetail.setText("Day: " + dayList.toString())
        textViewMorningScreenTimeDetail.setText("Morning Intake Time: " + morningScreenTimeList.toString())
        textViewAfternoonScreenTimeDetail.setText("Afternoon Intake Time: " + afternoonScreenTimeList.toString())
        textViewActivityNotesDetail.setText("Hydration Notes: " + activityNotesList.toString())
    }
}


</p>
  
[Hydration Haven App.pptx](https://github.com/user-attachments/files/16330823/Hydration.Haven.App.pptx)
