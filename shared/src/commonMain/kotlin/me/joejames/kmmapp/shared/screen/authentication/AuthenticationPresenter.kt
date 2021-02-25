package me.joejames.kmmapp.shared.screen.authentication

import me.joejames.kmmapp.shared.model.alert.AlertAction
import me.joejames.kmmapp.shared.util.isValidPassword
import me.joejames.kmmapp.shared.util.isValidUsername

class AuthenticationPresenter : AuthenticationContract.Presenter() {
    override fun logInButtonTapped(username: String, password: String) {
        view.showAlert(
            "Log In button tapped",
            AlertAction("OK") { println("Log In button closed") },
            AlertAction("Cancel") { println("Log In button cancelled") }
        )
    }

    override fun createAccountButtonTapped(populateUsername: String, populatePassword: String) {
        view.showAlert(
            "Register button tapped",
            AlertAction("OK") { println("Register button closed") },
            AlertAction("Cancel") { println("Register button cancelled") }
        )
        view.goToCreateAccountScreen(populateUsername, populatePassword)
    }

    override fun forgotPasswordButtonTapped() {
        view.showAlert(
            "Forgot password button tapped",
            AlertAction("OK") { println("Forgot password button closed") },
            AlertAction("Cancel") { println("Forgot password button cancelled") }
        )
    }

    override fun textInputsChanged(username: String, password: String) {
        val shouldEnableLogInButton =
            username.isValidUsername() && password.isValidPassword()

        view.setLogInButtonEnabled(shouldEnableLogInButton)
    }
}
