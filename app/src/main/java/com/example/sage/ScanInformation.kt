package com.example.sage

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ScanInformation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_information)
        val response = intent.getStringExtra(QR_RESPONSE)
        val respChunks = response.split(",")
        val status = respChunks[0]
        if (status == "VALID") {
            findViewById<TextView>(R.id.scan_status).text = VALID
            findViewById<TextView>(R.id.scan_status).setTextColor(Color.parseColor("#2BFF00"))

        } else {
            findViewById<TextView>(R.id.scan_status).text = COUNTERFEIT
            findViewById<TextView>(R.id.scan_status).setTextColor(Color.parseColor("#FF0000"))
            findViewById<Button>(R.id.scan_add_drug).visibility = View.INVISIBLE

        }
        val name = respChunks[1]
        val exp = respChunks[2]
        val known_names = respChunks[3]
        val prescribed_for = respChunks[4]

        findViewById<TextView>(R.id.scan_drug_name).text = name
        findViewById<TextView>(R.id.scan_exp).text = exp
        findViewById<TextView>(R.id.scan_known_name).text = known_names
        findViewById<TextView>(R.id.scan_prescribe_for).text = prescribed_for
    }
    companion object {
        const val QR_RESPONSE = "qr_response"
        const val VALID = "Validated Drug"
        const val COUNTERFEIT = "Counterfeit Drug"
    }
}
