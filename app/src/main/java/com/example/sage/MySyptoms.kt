package com.example.sage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_my_syptoms.*

class MySyptoms : AppCompatActivity() {

    private val SYMPTHOMS = arrayOf("Diarrhea", "Muscle Aaches", "Fever")

    private val DRUGS = arrayOf("bismuth subsalicylate", "ibuprofen (Advil)", "acetaminophen (Tylenol, others) or ibuprofen (Advil, Motrin IB, others)")

    val description = arrayOf<String>(
        "You have diarrhea if you have loose stools three or more times in one day",
        "Muscle pain is most often related to tension, overuse, or muscle injury from exercise or hard physical work.",
        "A fever is a body temperature that is higher than normal. A normal temperature can vary from person to person, but it is usually around 98.6 F (37 C)"
    )

    val imageId = arrayOf<Int>(
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_syptoms)

        val myListAdapter = MyListAdapter(this,SYMPTHOMS,description,imageId)
        listView.adapter = myListAdapter

        listView.setOnItemClickListener(){adapterView, view, position, id ->
            val inflater:LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            // Inflate a custom view using layout inflater
            val view = inflater.inflate(R.layout.pop_up,null)
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            val drug = DRUGS[position]
            view.findViewById<TextView>(R.id.pop_up_text_view).text = "Suggestion Drug for " + itemAtPos.toString() + " is " + drug.toString()
            val popupWindow = PopupWindow(
                view, // Custom view to show in popup window
                LinearLayout.LayoutParams.WRAP_CONTENT, // Width of popup window
                LinearLayout.LayoutParams.WRAP_CONTENT // Window height
            )

            val buttonPopup = view.findViewById<Button>(R.id.button_popup)

            buttonPopup.setOnClickListener{
                // Dismiss the popup window
                popupWindow.dismiss()
            }
            //TransitionManager.beginDelayedTransition(root_layout)
            popupWindow.showAtLocation(
                root_layout, // Location to display popup window
                Gravity.CENTER, // Exact position of layout to display popup
                0, // X offset
                0 // Y offset
            )
            //Toast.makeText(this, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_LONG).show()
        }
    }
}
