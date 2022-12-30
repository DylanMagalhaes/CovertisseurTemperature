package com.example.convertisseurtemperature

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var numberInput: EditText
    private lateinit var celciusButton: Button
    private lateinit var fahrenheitButton: Button
    private lateinit var convertedLabel: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        numberInput = findViewById(R.id.numberInput)
        celciusButton = findViewById(R.id.celciusButton)
        fahrenheitButton = findViewById(R.id.fahrenheitButton)
        convertedLabel = findViewById(R.id.convertionResult)

        celciusButton.setOnClickListener { onCelsiusButtonClick() }
        fahrenheitButton.setOnClickListener { onFahrenheitButtonClick() }
    }

    private fun onFahrenheitButtonClick(){
        val tempInCel = numberInput.text.toString().toInt()
        val tempInFahrenheit = toFahrenheit(tempInCel)

        showResultConvert(tempInFahrenheit)
    }

    private fun onCelsiusButtonClick() {
        val tempInFar = numberInput.text.toString().toInt()
        val tempInCelsius = toCelsius(temperature = tempInFar)

        showResultConvert(tempInCelsius)
    }

    private fun toCelsius(temperature: Int): Int {
        return (temperature - 32) * 5 / 9
    }

    private fun toFahrenheit(temperature: Int): Double {
        return (temperature * 1.9) + 32
    }

    fun showResultConvert(value: Double) {
        convertedLabel.text = "$value"
    }
}
