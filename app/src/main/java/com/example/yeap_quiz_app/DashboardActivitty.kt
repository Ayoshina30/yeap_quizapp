package com.example.yeap_quiz_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class  Dashboardactivitty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboardactivitty)

        val avatarView = findViewById<ImageView>(R.id.homeAvatar)
        val greetingView = findViewById<TextView>(R.id.homeGreeting)

        val name = intent.getStringExtra("EXPLORER_NAME") ?: "Explorer"
        val avatarResId = intent.getIntExtra("AVATAR_RES_ID", 0)

        greetingView.text = "Hi $name"

        if (avatarResId != 0) {
            avatarView.setImageResource(avatarResId)
        }
    }
    fun openanimalpage(view: View) {
        val intent = Intent(this, AnimalActivity::class.java)
        startActivity(intent)
    }
    fun openquizactivity(view: View) {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }
    fun openhabitatpage(view: View) {
        val intent = Intent(this, HabitattActivity::class.java)
        startActivity(intent)
    }
    fun openlearningpage(view: View) {
        val intent = Intent(this, LearningActivity::class.java)
        startActivity(intent)
    }
    fun openquizpage(view: View) {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }

}