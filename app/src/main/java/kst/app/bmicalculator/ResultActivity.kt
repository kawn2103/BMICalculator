package kst.app.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)

        Log.d("resultActivity","height : $height //// weight : $weight")

        val bmi = weight / (weight / 100.0).pow(2.0)

        val finalText = when {
            bmi >= 35.0 -> "$bmi 고도 비만"

            bmi >= 30.0 -> "$bmi 중정도 비만"
            bmi >= 25.0 -> "$bmi 경도 비만"
            bmi >= 23.0 -> "$bmi 과체중"
            bmi >= 18.5 -> "$bmi 정상체중"
            else -> "$bmi 저체중"
        }

        val finalTv = findViewById<TextView>(R.id.final_tv)
        finalTv.text = finalText
    }
}