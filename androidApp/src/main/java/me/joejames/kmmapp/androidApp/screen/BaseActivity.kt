package me.joejames.kmmapp.androidApp.screen

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import me.joejames.kmmapp.shared.screen.BaseView

abstract class BaseActivity : AppCompatActivity(), BaseView {
    override fun showAlert(message: String) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .show()
    }

    override fun closeSelf() {
        finish()
    }
}
