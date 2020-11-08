package me.joejames.kmmapp.shared.screen.authentication

import me.joejames.kmmapp.shared.util.isValidPassword
import me.joejames.kmmapp.shared.util.isValidUsername

class AuthenticationPresenter : AuthenticationContract.Presenter() {
    override fun logInButtonTapped(username: String, password: String) {
        view.showAlert("Log In button tapped")
    }

    override fun createAccountButtonTapped(populateUsername: String, populatePassword: String) {
//        view.showAlert("Register button tapped")
        view.goToCreateAccountScreen(populateUsername, populatePassword)
    }

    override fun forgotPasswordButtonTapped() {
        view.showAlert("Forgot password button tapped")
    }

    override fun textInputsChanged(username: String, password: String) {
        val shouldEnableLogInButton =
            username.isValidUsername() && password.isValidPassword()

        view.setLogInButtonEnabled(shouldEnableLogInButton)
    }
}
