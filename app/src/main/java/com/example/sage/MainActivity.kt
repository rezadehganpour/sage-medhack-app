package com.example.sage

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import com.example.sage.ScanInformation.Companion.QR_RESPONSE

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        qr_camera.setOnClickListener{
            val scanner = IntentIntegrator(this)
            scanner.initiateScan()
        }
    }

    fun user_info(view: View) {
        val randomIntent = Intent(this, UserInformation::class.java)

        startActivity(randomIntent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(this, "No Data Found", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                    val randomIntent = Intent(this, ScanInformation::class.java)
                    randomIntent.putExtra(QR_RESPONSE, result.contents)
// Start the new activity.
                    startActivity(randomIntent)
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
}

