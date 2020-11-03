package me.joejames.kmmapp.shared.screen.authentication

import me.joejames.kmmapp.shared.screen.BasePresenter
import me.joejames.kmmapp.shared.screen.BaseView

interface AuthenticationContract {
    interface View : BaseView {
        fun setLogInButtonEnabled(isEnabled: Boolean)
        fun goToCreateAccountScreen(populateUsername: String, populatePassword: String)
    }

    abstract class Presenter : BasePresenter<View>() {
        override val name = "Authentication"
        abstract fun logInButtonTapped(username: String, password: String)
        abstract fun createAccountButtonTapped()
        abstract fun forgotPasswordButtonTapped()
        abstract fun textInputsChanged(username: String, password: String)
    }
}