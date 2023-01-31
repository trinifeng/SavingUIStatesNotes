package com.example.feng.savinguistates

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var numDisplay: TextView
    lateinit var nameText: EditText
    lateinit var radioGroup: RadioGroup
    lateinit var standardFontButton: RadioButton
    lateinit var monospaceFontButton: RadioButton

    var number = 0
    var name = ""
    var standardFont = true
    var monospaceFont = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        numDisplay = findViewById(R.id.value_text)
        nameText = findViewById(R.id.name_text)
        radioGroup = findViewById(R.id.radio_group)
        standardFontButton = findViewById(R.id.standard_font_button)
        monospaceFontButton = findViewById(R.id.monospace_font_button)

        numDisplay.text = number.toString()

        button.setOnClickListener {
            number++
            numDisplay.text = number.toString()
            button.text = nameText.text.toString()
            if(standardFontButton.isChecked)
                button.setTypeface(Typeface.SANS_SERIF)
            else if(monospaceFontButton.isChecked)
                button.setTypeface(Typeface.MONOSPACE)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //outState.putString("saved_number", numDisplay.text.toString())
        outState.putInt("current_value", number)
        outState.putString("current_name", name)
        outState.putBoolean("standard_font", standardFontButton.isChecked)
        outState.putBoolean("monospace_font", monospaceFontButton.isChecked)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        number = savedInstanceState.getInt("current_value")
        name = savedInstanceState.getString("current_name").toString()
        standardFont = savedInstanceState.getBoolean("standard_font")
        monospaceFont = savedInstanceState.getBoolean("monospace_font")
        numDisplay.text = number.toString()
        button.text = name
        if(standardFont)
            button.setTypeface(Typeface.SANS_SERIF)
        if(monospaceFont)
            button.setTypeface(Typeface.MONOSPACE)
    }


}