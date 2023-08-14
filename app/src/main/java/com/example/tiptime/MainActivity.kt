package com.example.tiptime

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton: Button = findViewById(R.id.calculate_button)


        calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    public fun calculateTip() {
        val tipResult: TextView = findViewById(R.id.tip_result)
        val costOfService: EditText = findViewById(R.id.cost_of_service)
        val serviceRatingGroup: RadioGroup = findViewById(R.id.tip_options)
        val roundUpSwitch: Switch = findViewById(R.id.round_up_switch)
        val option_twenty_percent: RadioButton = findViewById(R.id.option_twenty_percent)
        val option_eighteen_percent: RadioButton = findViewById(R.id.option_eighteen_percent)
        val tip_result: TextView = findViewById(R.id.tip_result)

        val costString = costOfService.text.toString()
        if (costString.isNotEmpty()) {
            val cost = costString.toDouble()
            val selectedRating = findViewById<RadioButton>(serviceRatingGroup.checkedRadioButtonId)
            val tipPercentage = when (selectedRating) {
                option_twenty_percent -> 0.2
                option_eighteen_percent -> 0.18
                else -> 0.15
            }

            var tipAmount = cost * tipPercentage

            if (roundUpSwitch.isChecked) {
                tipAmount = kotlin.math.ceil(tipAmount)
            }

           tip_result.text = getString(R.string.tip_amount, tipAmount)
        }
    }
}
