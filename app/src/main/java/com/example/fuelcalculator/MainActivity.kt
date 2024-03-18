package com.example.fuelcalculator

// MainActivity.kt
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate = findViewById<Button>(R.id.btn_Calculate)
        val edtDistance = findViewById<EditText>(R.id.edt_Distance)
        val edtFuelConsumption = findViewById<EditText>(R.id.edt_FuelConsumption)
        val edtFuelPrice = findViewById<EditText>(R.id.edt_FuelPrice)
        val edtPassengers = findViewById<EditText>(R.id.edt_Passengers)

        btnCalculate.setOnClickListener {
            val distanceStr = edtDistance.text.toString()
            val fuelConsumptionStr = edtFuelConsumption.text.toString()
            val fuelPriceStr = edtFuelPrice.text.toString()
            val passengersStr = edtPassengers.text.toString()

            if (distanceStr == "" || fuelConsumptionStr == "" || fuelPriceStr == "" || passengersStr == "") {
                Snackbar
                    .make(
                        edtDistance,
                        "Fields are require",
                        Snackbar.LENGTH_LONG
                    ).show()
            } else {

                val distance = edtDistance.text.toString().toFloat()
                val fuelConsumption = edtFuelConsumption.text.toString().toFloat()
                val fuelPrice = edtFuelPrice.text.toString().toFloat()
                val passengers = edtPassengers.text.toString().toFloat()

                val cost = (distance / fuelConsumption) * fuelPrice

                val passengerResult = cost / passengers

                val litersResult = distance / fuelConsumption


                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_COST, cost)
                intent.putExtra(KEY_RESULT_PASSENGER, passengerResult)
                intent.putExtra(KEY_RESULT_LITERS, litersResult)
                startActivity(intent)


                }
            }
        }
    }

