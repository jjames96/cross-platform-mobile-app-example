package me.joejames.kmmapp.androidApp.screen.authentication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import me.joejames.kmmapp.androidApp.R
import me.joejames.kmmapp.androidApp.dependency.injection
import me.joejames.kmmapp.androidApp.listener.TextChangedListener
import me.joejames.kmmapp.androidApp.screen.BaseActivity
import me.joejames.kmmapp.shared.screen.authentication.AuthenticationContract

class AuthenticationActivity : BaseActivity(), AuthenticationContract.View {
    private lateinit var presenter: AuthenticationContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        presenter = injection.authenticationPresenter()

        setUpButtonTappedListeners()
        setUpInputTextChangedListeners()
    }

    override fun onStart() {
        super.onStart()
        presenter.takeView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.dropView()
    }

    override fun setLogInButtonEnabled(isEnabled: Boolean) {
        val logInButton = findViewById<Button>(R.id.logInButton)
        logInButton.isEnabled = isEnabled
    }

    override fun goToCreateAccountScreen(populateUsername: String, populatePassword: String) {
        // TODO
    }

    private fun setUpButtonTappedListeners() {
        val logInButton = findViewById<Button>(R.id.logInButton)
        val createAccountButton = findViewById<Button>(R.id.createAccountButton)
        val forgotPasswordButton = findViewById<Button>(R.id.forgotPasswordButton)
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)

        logInButton.setOnClickListener {
            presenter.logInButtonTapped(
                usernameEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }

        createAccountButton.setOnClickListener {
            presenter.createAccountButtonTapped(
                usernameEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }

        forgotPasswordButton.setOnClickListener { presenter.forgotPasswordButtonTapped() }
    }

    private fun setUpInputTextChangedListeners() {
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)

        val textChangedListener = TextChangedListener {
            presenter.textInputsChanged(
                usernameEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }

        usernameEditText.addTextChangedListener(textChangedListener)
        passwordEditText.addTextChangedListener(textChangedListener)
    }
}
