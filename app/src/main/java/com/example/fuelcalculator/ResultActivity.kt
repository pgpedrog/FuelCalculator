package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

    const val KEY_RESULT_COST = "ResultActivity.KEY_COST"

    const val KEY_RESULT_PASSENGER = "ResultActivity.KEY_PASSENGER"

    const val KEY_RESULT_LITERS = "ResultActivity.KEY_LITERS"


    class ResultActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_result)

            val cost = intent.getFloatExtra(KEY_RESULT_COST, 0f)
            val passengerResult = intent.getFloatExtra(KEY_RESULT_PASSENGER, 0f)
            val litersResult = intent.getFloatExtra(KEY_RESULT_LITERS,0f)

            val tvResult = findViewById<TextView>(R.id.tv_Result)
            val btnRecalculate = findViewById<Button>(R.id.btn_Recalculate)
            val tvPassengerResult = findViewById<TextView>(R.id.tv_passengerResult)
            val tvLitersResult = findViewById<TextView>(R.id.tv_litersResult)


            tvResult.text = "$%.2f".format(cost)

            tvPassengerResult.text = "$%.2f".format(passengerResult)

            tvLitersResult.text = "%.0fL".format(litersResult)


            btnRecalculate.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }