package com.example.assignment_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val dataArrayList: ArrayList<DataModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton: Button = findViewById(R.id.addButton)
        val tableLayout: TableLayout = findViewById(R.id.tableLayout)

        addButton.setOnClickListener {
            addDataToArrayList()
            updateTable(tableLayout)

        }
    }

    private fun addDataToArrayList() {
        val editTextWaterSource: EditText = findViewById(R.id.editTextWaterSource)
        val editTextLocation: EditText = findViewById(R.id.editTextLocation)
        val editTextType: EditText = findViewById(R.id.editTextType)

        val waterSource = editTextWaterSource.text.toString()
        val location = editTextLocation.text.toString()
        val type = editTextType.text.toString()

        if(waterSource.equals("") || location.equals("") || type.equals("")){
            Toast.makeText(this, "Please fill up all the fields", Toast.LENGTH_SHORT).show();
        }else{
            val dataModel = DataModel(waterSource, location, type)
            dataArrayList.add(dataModel)
            clearEditTextFields()
        }
    }

    private fun updateTable(tableLayout: TableLayout) {
        // Clear existing data rows
        tableLayout.removeViews(1, tableLayout.childCount - 1)

        // Populate table with data
        for (dataModel in dataArrayList) {
            val dataRow = TableRow(this)
            dataRow.addView(createTextView(dataModel.waterSource))
            dataRow.addView(createTextView(dataModel.location))
            dataRow.addView(createTextView(dataModel.type))
            tableLayout.addView(dataRow)
        }
    }


    private fun createTextView(text: String): TextView {
        val textView = TextView(this)
        textView.text = text
        textView.gravity = Gravity.CENTER

        // Set cell borders
        val borderWidth = 1 // in pixels
        val borderColor = Color.BLACK // replace with your desired color

        textView.setBackgroundResource(R.drawable.cell_border)
        val params = TableRow.LayoutParams(
            0,
            TableRow.LayoutParams.WRAP_CONTENT,
            1f
        )
        params.setMargins(borderWidth, borderWidth, borderWidth, borderWidth)
        textView.layoutParams = params

        return textView
    }



    private fun clearEditTextFields() {
        val editTextWaterSource: EditText = findViewById(R.id.editTextWaterSource)
        val editTextLocation: EditText = findViewById(R.id.editTextLocation)
        val editTextType: EditText = findViewById(R.id.editTextType)

        editTextWaterSource.text.clear()
        editTextLocation.text.clear()
        editTextType.text.clear()
    }
}
data class DataModel(val waterSource: String, val location: String, val type: String)