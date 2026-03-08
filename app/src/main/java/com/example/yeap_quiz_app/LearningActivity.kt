package com.example.yeap_quiz_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LearningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_learning)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun tomenu(view: View) {
        val intent = Intent(this, Dashboardactivitty::class.java)
        startActivity(intent)
    }
    fun toanimal(view: View) {
        val intent = Intent(this, AnimalActivity::class.java)
        startActivity(intent)
    }
    fun tohabitat(view: View) {
        val intent = Intent(this, HabitattActivity::class.java)
        startActivity(intent)
    }
}