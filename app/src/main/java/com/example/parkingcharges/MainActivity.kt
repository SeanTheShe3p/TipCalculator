package com.example.parkingcharges

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.lifecycle.viewmodel.viewModelFactory
import java.text.DecimalFormat


var mealCost: Double = 0.00
var tipAmount: Double = 0.00
var tipSelection: String = ""
var tipDecimal: Double = 0.00
var formatAmount: String = ""
val decimal = DecimalFormat("$###,###.00")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnResult :Button = findViewById(R.id.btnResult)
        val subMealCost: EditText = findViewById(R.id.costMeal)
        val subTipSelection: Spinner = findViewById(R.id.spnTip)
        val result: TextView = findViewById(R.id.totalAmount)

        btnResult.setOnClickListener{
            mealCost = subMealCost.text.toString().toDouble()
            tipSelection= subTipSelection.getSelectedItem().toString()
            if (tipSelection=="5%"){
                tipAmount = .05
            }
            if (tipSelection=="10%"){
                tipAmount = .1
            }
            if (tipSelection=="15%"){
                tipAmount = .15
            }
            if (tipSelection == "20%"){
                tipAmount = .2
            }
            if (tipSelection == "25%"){
                tipAmount = .25
            }
            tipDecimal = mealCost* tipAmount
            formatAmount = decimal.format(tipDecimal)
            result.setText("The tip amount is $formatAmount")
        }
    }
}