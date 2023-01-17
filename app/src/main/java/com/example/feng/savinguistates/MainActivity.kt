package com.example.feng.savinguistates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var numDisplay: TextView

    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        numDisplay = findViewById(R.id.value_text)

        numDisplay.text = number.toString()

        button.setOnClickListener {
            number++
            numDisplay.text = number.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //outState.putString("saved_number", numDisplay.text.toString())
        outState.putInt("current_value", number)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        number = savedInstanceState.getInt("current_value")
        numDisplay.text = number.toString()
    }


}