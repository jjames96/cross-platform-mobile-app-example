package me.joejames.kmmapp.shared.screen

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import me.joejames.kmmapp.shared.screen.authentication.AuthenticationContract
import me.joejames.kmmapp.shared.screen.authentication.AuthenticationPresenter
import kotlin.test.BeforeTest
import kotlin.test.Test

class AuthenticationPresenterTest {
    @RelaxedMockK
    private lateinit var view: AuthenticationContract.View

    private lateinit var presenter: AuthenticationContract.Presenter

    @BeforeTest
    fun setUp() {
        MockKAnnotations.init(this)

        presenter = AuthenticationPresenter()

        presenter.takeView(view)
    }

    @Test
    fun alertShownWhenLogInButtonTapped() {
        presenter.logInButtonTapped("username", "password")

        verify { view.showAlert("Log In button tapped") }
    }

    @Test
    fun alertShownWhenCreateAccountButtonTapped() {
        presenter.createAccountButtonTapped("username", "password")

        verify { view.showAlert("Register button tapped") }
    }

    @Test
    fun alertShownWhenForgotPasswordButtonTapped() {
        presenter.forgotPasswordButtonTapped()

        verify { view.showAlert("Forgot password button tapped") }
    }

    @Test
    fun createAccountScreenShownWhenCreateAccountButtonTapped() {
        val populateUsername = "username"
        val populatePassword = "password"

        presenter.createAccountButtonTapped(populateUsername, populatePassword)

        verify { view.goToCreateAccountScreen(populateUsername, populatePassword) }
    }

    @Test
    fun logInButtonDisabledWhenTextFieldUpdatedWithShortUsernameAndPassword() {
        val username = "ab"
        val password = "cd"

        presenter.textInputsChanged(username, password)

        verify { view.setLogInButtonEnabled(false) }
    }

    @Test
    fun logInButtonDisabledWhenTextFieldUpdatedWithLongUsernameAndShortPassword() {
        val username = "abc"
        val password = "de"

        presenter.textInputsChanged(username, password)

        verify { view.setLogInButtonEnabled(false) }
    }

    @Test
    fun logInButtonDisabledWhenTextFieldUpdatedWithShortUsernameAndLongPassword() {
        val username = "ab"
        val password = "cde"

        presenter.textInputsChanged(username, password)

        verify { view.setLogInButtonEnabled(false) }
    }

    @Test
    fun logInButtonEnabledWhenTextFieldUpdatedWithLongUsernameAndPassword() {
        val username = "abc"
        val password = "def"

        presenter.textInputsChanged(username, password)

        verify { view.setLogInButtonEnabled(true) }
    }
}
