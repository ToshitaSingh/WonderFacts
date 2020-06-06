package com.example.wonderfacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.wonderfacts.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_listof_wonders.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        binding.startButton.setOnClickListener {
            val name = binding.enterName.text.toString()
            val intent = Intent(this, ListofWonders::class.java)
            intent.putExtra("", name)
            startActivity(intent)
        }
    }
}