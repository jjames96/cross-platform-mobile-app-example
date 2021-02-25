package me.joejames.kmmapp.shared.model.alert

class AlertAction(
    val actionText: String,
    val actionCallback: () -> Unit
)
