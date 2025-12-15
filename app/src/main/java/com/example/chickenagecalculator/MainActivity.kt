package com.example.chickenagecalculator

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    
    private lateinit var dateTextView: TextView
    private lateinit var timeTextView: TextView
    private lateinit var resultTextView: TextView
    private lateinit var calculateButton: Button
    
    private var selectedDateTime = Calendar.getInstance()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        dateTextView = findViewById(R.id.dateTextView)
        timeTextView = findViewById(R.id.timeTextView)
        resultTextView = findViewById(R.id.resultTextView)
        calculateButton = findViewById(R.id.calculateButton)
        
        dateTextView.setOnClickListener { showDatePicker() }
        timeTextView.setOnClickListener { showTimePicker() }
        calculateButton.setOnClickListener { calculateAge() }
        
        updateDateTimeText()
    }
    
    private fun showDatePicker() {
        DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                selectedDateTime.set(year, month, dayOfMonth)
                updateDateTimeText()
            },
            selectedDateTime.get(Calendar.YEAR),
            selectedDateTime.get(Calendar.MONTH),
            selectedDateTime.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
    
    private fun showTimePicker() {
        TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                selectedDateTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                selectedDateTime.set(Calendar.MINUTE, minute)
                updateDateTimeText()
            },
            selectedDateTime.get(Calendar.HOUR_OF_DAY),
            selectedDateTime.get(Calendar.MINUTE),
            true
        ).show()
    }
    
    private fun updateDateTimeText() {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        
        dateTextView.text = "Tarih: ${dateFormat.format(selectedDateTime.time)}"
        timeTextView.text = "Saat: ${timeFormat.format(selectedDateTime.time)}"
    }
    
    private fun calculateAge() {
        val now = Calendar.getInstance()
        val diff = now.timeInMillis - selectedDateTime.timeInMillis
        
        val days = diff / (1000 * 60 * 60 * 24)
        val hours = (diff % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)
        val minutes = (diff % (1000 * 60 * 60)) / (1000 * 60)
        
        resultTextView.text = """
            Civciv Yaşı:
            $days gün
            $hours saat
            $minutes dakika
            
            Toplam: ${days} gün
        """.trimIndent()
    }
}
