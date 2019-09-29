package com.example.sage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.TextView
import com.example.sage.SignUpActivity.Companion.USER_USERNAME

class UserInformation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_information)

        val myPreferences = PreferenceManager.getDefaultSharedPreferences(this@UserInformation)
        val name = myPreferences.getString(USER_USERNAME, "EMPTY")
//        findViewById<TextView>(R.id.MyInformation).text = name

    }

    fun getMySyptoms(view: View) {
//        val signUp = Toast.makeText(this, "Sign Up", Toast.LENGTH_SHORT);
//        signUp.show();
        val randomIntent = Intent(this, MySyptoms::class.java)

// Start the new activity.
        startActivity(randomIntent)
    }

}
