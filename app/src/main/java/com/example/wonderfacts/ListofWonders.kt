package com.example.wonderfacts

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.wonderfacts.databinding.ActivityListofWondersBinding
import java.util.*

class ListofWonders : AppCompatActivity() {
    private lateinit var binding: ActivityListofWondersBinding
    lateinit var displayText : TextView
    var colorArray = arrayOf<String>("#e3adb5", "#f69284", "#95b8e3", "#95dfe3", "#a99887", "#d5ede6",
                                    "#c095e3", "#fff384", "#008080", "#f0b892", "#53af8b", "#89b65a")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_listof_wonders)

        //hide the status bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        //display name got from main activity
        val intent = intent
        val name = intent.getStringExtra("")
        val setText = binding.helloText
        setText.text = "Hi $name! Click on the following wonders of the world and learn 5 facts about them below!"

        //initializing
        displayText = binding.scrollText

        val petraButton: Button = binding.petra
        val greatPyramidButton: Button = binding.greatPyramid
        val colosseumButton: Button = binding.colosseum
        val machuPichuButton: Button = binding.machuPichu
        val sigiriaButton: Button = binding.sigiria
        val tajMahalButton: Button = binding.tajMahal
        val greatWallButton: Button = binding.greatWall
        val chichenItzaButton: Button = binding.chichenItza
        val acropolisButton: Button = binding.acropolis
        val ephesusButton: Button = binding.ephesus
        val christRemeederButton: Button = binding.christRedeemer
        val baganButton: Button = binding.bagan

        val clickableButtons : List<View> = listOf(
            petraButton, greatPyramidButton, colosseumButton, machuPichuButton,
            sigiriaButton, tajMahalButton, greatWallButton, chichenItzaButton,
            acropolisButton, ephesusButton, christRemeederButton, baganButton
        )

        for (item in clickableButtons) {
            item.setOnClickListener {

                //set random color on the buttom from the colorArray
                val i = Random()
                val c = i.nextInt(12 - 1) + 1
                it.setBackgroundColor(Color.parseColor(colorArray[c]))

                //display facts
                displayFacts(it)
            }
        }
    }

    private fun displayFacts(view: View) {
        when(view.id) {
            R.id.petra -> displayText.setText(R.string.petra_facts)
            R.id.great_pyramid -> displayText.setText(R.string.great_pyramid_facts)
            R.id.colosseum -> displayText.setText(R.string.colosseum_facts)
            R.id.machu_pichu -> displayText.setText(R.string.machu_pichu_facts)
            R.id.sigiria -> displayText.setText(R.string.sigiria_facts)
            R.id.taj_mahal -> displayText.setText(R.string.taj_mahal_facts)
            R.id.great_wall -> displayText.setText(R.string.great_wall_facts)
            R.id.chichen_itza -> displayText.setText(R.string.chichen_itza_facts)
            R.id.acropolis -> displayText.setText(R.string.acropolis_facts)
            R.id.ephesus -> displayText.setText(R.string.ephesus_facts)
            R.id.christ_redeemer -> displayText.setText(R.string.christ_redeemer_facts)
            R.id.bagan -> displayText.setText(R.string.bagan_facts)
        }
    }
}