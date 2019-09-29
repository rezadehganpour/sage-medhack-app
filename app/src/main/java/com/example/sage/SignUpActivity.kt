package com.example.sage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.preference.PreferenceManager
import android.widget.*

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
        val viewSympthoms = findViewById<MultiAutoCompleteTextView>(R.id.symptoms)
        viewSympthoms.setAdapter<ArrayAdapter<String>>(sympthoms)
        viewSympthoms.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

    }

    fun submitSignUp(view: View) {
        val myPreferences = PreferenceManager.getDefaultSharedPreferences(this@SignUpActivity)
        val myEditor = myPreferences.edit()
        val username = findViewById<TextView>(R.id.signup_username)
        val password = findViewById<TextView>(R.id.signup_password)
        val firsname = findViewById<TextView>(R.id.signup_firstName)
        val lastname = findViewById<TextView>(R.id.signup_lastName)
        val age = findViewById<TextView>(R.id.signup_age)
        val gender = findViewById<Spinner>(R.id.signup_genrder)
        val country = findViewById<Spinner>(R.id.signup_country)
        val known_diagnosis = findViewById<MultiAutoCompleteTextView>(R.id.knownDiagnosis).text
        val currentMedications = findViewById<MultiAutoCompleteTextView>(R.id.medications).text
        val currentSyptoms = findViewById<MultiAutoCompleteTextView>(R.id.symptoms).text

        myEditor.putString(USER_USERNAME, username.text.toString())
        myEditor.putString(USER_PASSWORD, password.text.toString())
        myEditor.putString(USER_FIRSTNAME, firsname.text.toString())
        myEditor.putString(USER_LASTNAME, lastname.text.toString())
        myEditor.putString(USER_AGE, age.text.toString())
        myEditor.putString(USER_GENEDER, gender.selectedItem.toString())
        myEditor.putString(USER_COUNTRY, country.selectedItem.toString())
        myEditor.putString(USER_KNOWN_DIAGNOSIS, known_diagnosis.toString())
        myEditor.putString(USER_CURRENT_MEDICATION, currentMedications.toString())
        myEditor.putString(USER_CURRENT_SYMTOMS, currentSyptoms.toString())

        myEditor.commit()

        val randomIntent = Intent(this, MainActivity::class.java)

        startActivity(randomIntent)
    }

    companion object {
        const val USER_USERNAME = "username"
        const val USER_PASSWORD = "password"
        const val USER_FIRSTNAME = "firstname"
        const val USER_LASTNAME = "lastname"
        const val USER_AGE = "age"
        const val USER_GENEDER = "gender"
        const val USER_COUNTRY = "country"
        const val USER_KNOWN_DIAGNOSIS = "known_diagnosis"
        const val USER_CURRENT_MEDICATION = "current_medication"
        const val USER_CURRENT_SYMTOMS = "current_symptoms"
    }

    private val DIAGNOSIS = arrayOf("Diabetes", "High Cholesterol", "High Blood Pressure")
    private val MEDICATIONS = arrayOf("Insulin", "Aspirin", "Diuretics")
    private val SYMPTHOMS = arrayOf("Diarrhea", "Muscle Aaches", "Fever")
}
