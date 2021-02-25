package me.joejames.kmmapp.shared.screen

import me.joejames.kmmapp.shared.model.alert.AlertAction

interface BaseView {
    fun showAlert(message: String)
    fun showAlert(message: String, positiveAction: AlertAction, negativeAction: AlertAction? = null)
    fun closeSelf()
}
