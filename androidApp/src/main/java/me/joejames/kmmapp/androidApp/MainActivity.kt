package me.joejames.kmmapp.androidApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.joejames.kmmapp.shared.Greeting
import android.widget.TextView
import me.joejames.kmmapp.androidApp.screen.authentication.AuthenticationActivity

fun greet(): String {
    return Greeting().greeting()
}

// TODO Refactor MainActivity into launch screen
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        startActivity(Intent(this, AuthenticationActivity::class.java))
    }
}
