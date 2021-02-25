package me.joejames.kmmapp.androidApp.screen

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import me.joejames.kmmapp.shared.model.alert.AlertAction
import me.joejames.kmmapp.shared.screen.BaseView

abstract class BaseActivity : AppCompatActivity(), BaseView {
    override fun showAlert(message: String) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .show()
    }

    override fun showAlert(
        message: String,
        positiveAction: AlertAction,
        negativeAction: AlertAction?
    ) {
        val alertBuilder = AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton(positiveAction.actionText) { _, _ -> positiveAction.actionCallback() }

        negativeAction?.let {
            alertBuilder.setNegativeButton(it.actionText) { _, _, -> it.actionCallback() }
        }

        alertBuilder.show()
    }

    override fun closeSelf() {
        finish()
    }
}
