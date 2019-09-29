package com.example.sage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import android.preference.PreferenceManager
import android.content.SharedPreferences
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import sun.jvm.hotspot.utilities.IntArray
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import sun.jvm.hotspot.utilities.IntArray






class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val knownDiagnosises = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line, DIAGNOSIS
        )
        val viewKnowDiadnosis = findViewById<MultiAutoCompleteTextView>(R.id.knownDiagnosis)
        viewKnowDiadnosis.setAdapter<ArrayAdapter<String>>(knownDiagnosises)
        viewKnowDiadnosis.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        val medhication = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line, MEDICATIONS
        )
        val viewMedications = findViewById<MultiAutoCompleteTextView>(R.id.medications)
        viewMedications.setAdapter<ArrayAdapter<String>>(medhication)
        viewMedications.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        val sympthoms = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line, SYMPTHOMS
        )
        val viewSympthoms = findViewById<MultiAutoCompleteTextView>(R.id.Symptoms)
        viewSympthoms.setAdapter<ArrayAdapter<String>>(sympthoms)
        viewSympthoms.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

    }

    fun submitSignUp(view: View) {
        val myPreferences = PreferenceManager.getDefaultSharedPreferences(this@SignUpActivity)
        val myEditor = myPreferences.edit()
        val
        val randomIntent = Intent(this, MainActivity::class.java)

        startActivity(randomIntent)
    }

    private val DIAGNOSIS = arrayOf("Diabetes", "High Cholesterol", "High Blood Pressure")
    private val MEDICATIONS = arrayOf("Insulin", "Aspirin", "Diuretics")
    private val SYMPTHOMS = arrayOf("Diarrhea", "Weakness", "Fever")
}
