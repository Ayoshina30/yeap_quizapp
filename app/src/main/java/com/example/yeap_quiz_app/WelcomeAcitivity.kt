package com.example.yeap_quiz_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class WelcomeAcitivity : AppCompatActivity() {

    private var selectedAvatarResId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_acitivity)

        val panda = findViewById<ImageView>(R.id.avatarPanda)
        val elephant = findViewById<ImageView>(R.id.avatarElephant)
        val tiger = findViewById<ImageView>(R.id.avatarTiger)
        val zebra = findViewById<ImageView>(R.id.avatarZebra)

        val nameInput = findViewById<TextInputEditText>(R.id.nameInput)
        val startBtn = findViewById<Button>(R.id.StartBtn)

        fun selectAvatar(resId: Int, selectedView: ImageView) {
            selectedAvatarResId = resId

            // simple “selected” highlight (no new layout needed)
            panda.alpha = 0.6f
            elephant.alpha = 0.6f
            tiger.alpha = 0.6f
            zebra.alpha = 0.6f

            panda.scaleX = 1f; panda.scaleY = 1f
            elephant.scaleX = 1f; elephant.scaleY = 1f
            tiger.scaleX = 1f; tiger.scaleY = 1f
            zebra.scaleX = 1f; zebra.scaleY = 1f

            selectedView.alpha = 1f
            selectedView.scaleX = 1.08f
            selectedView.scaleY = 1.08f
        }

        panda.setOnClickListener { selectAvatar(R.drawable.panda_avatar, panda) }
        elephant.setOnClickListener { selectAvatar(R.drawable.elephant_avatar, elephant) }
        tiger.setOnClickListener { selectAvatar(R.drawable.lion_avatar, tiger) }
        zebra.setOnClickListener { selectAvatar(R.drawable.zebara_avatar, zebra) }

        startBtn.setOnClickListener {
            val name = nameInput.text?.toString()?.trim().orEmpty()

            // 1) validate name
            if (name.isBlank()) {
                Toast.makeText(this, "Enter your explorer name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 2) max 8 characters rule
            if (name.length > 8) {
                Toast.makeText(this, "Name must be 8 characters or less", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 3) validate avatar picked
            val avatarRes = selectedAvatarResId
            if (avatarRes == null) {
                Toast.makeText(this, "Choose an explorer avatar", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 4) go to dashboard with data
            val intent = Intent(this, Dashboardactivitty::class.java).apply {
                putExtra("EXPLORER_NAME", name)
                putExtra("AVATAR_RES_ID", avatarRes)
            }
            startActivity(intent)
        }
    }
}
