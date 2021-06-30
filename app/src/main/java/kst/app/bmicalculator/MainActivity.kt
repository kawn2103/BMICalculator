package kst.app.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEt: EditText = findViewById(R.id.height_et)
        val weightEt = findViewById<EditText>(R.id.weight_et)
        val resultBt = findViewById<Button>(R.id.result_bt )

        resultBt.setOnClickListener {

            if (heightEt.text.isEmpty() || weightEt.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val height: Int = heightEt.text.toString().toInt()
            val weight: Int = weightEt.text.toString().toInt()

            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("height",height)
            intent.putExtra("weight",weight)
            startActivity(intent)
        }
    }
}