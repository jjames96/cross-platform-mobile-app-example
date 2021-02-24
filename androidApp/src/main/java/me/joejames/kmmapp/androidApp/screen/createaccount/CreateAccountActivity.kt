package me.joejames.kmmapp.androidApp.screen.createaccount

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import me.joejames.kmmapp.androidApp.R
import me.joejames.kmmapp.androidApp.dependency.injection
import me.joejames.kmmapp.androidApp.listener.TextChangedListener
import me.joejames.kmmapp.androidApp.screen.BaseActivity
import me.joejames.kmmapp.androidApp.screen.createaccount.CreateAccountActivity.Companion.CREATE_ACCOUNT_POPULATE_PASSWORD
import me.joejames.kmmapp.androidApp.screen.createaccount.CreateAccountActivity.Companion.CREATE_ACCOUNT_POPULATE_USERNAME
import me.joejames.kmmapp.shared.model.account.AccountDetails
import me.joejames.kmmapp.shared.screen.createaccount.CreateAccountContract

class CreateAccountActivity : BaseActivity(), CreateAccountContract.View {
    companion object {
        const val CREATE_ACCOUNT_POPULATE_USERNAME = "CREATE_ACCOUNT_POPULATE_USERNAME"
        const val CREATE_ACCOUNT_POPULATE_PASSWORD = "CREATE_ACCOUNT_POPULATE_PASSWORD"
    }

    private lateinit var presenter: CreateAccountContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        presenter = injection.createAccountPresenter()

        setUpPrePopulatedUsernameAndPasswordValues()
        setUpButtonClickListeners()
        setUpEditTextUpdateListeners()
    }

    override fun onStart() {
        super.onStart()
        presenter.takeView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.dropView()
    }

    override fun setCreateAccountButtonIsEnabled(isEnabled: Boolean) {
        val createAccountButton = findViewById<Button>(R.id.createAccountButton)

        createAccountButton.isEnabled = isEnabled
    }

    private fun setUpPrePopulatedUsernameAndPasswordValues() {
        val populateUsername = intent.getStringExtra(CREATE_ACCOUNT_POPULATE_USERNAME)
        val populatePassword = intent.getStringExtra(CREATE_ACCOUNT_POPULATE_PASSWORD)

        populateUsername?.let {
            val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
            usernameEditText.setText(it)
        }

        populatePassword?.let {
            val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
            passwordEditText.setText(it)
        }
    }

    private fun setUpButtonClickListeners() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val createAccountButton = findViewById<Button>(R.id.createAccountButton)

        toolbar.setNavigationOnClickListener {
            closeSelf()
        }

        createAccountButton.setOnClickListener {
            presenter.createAccountButtonTapped(getAccountDetails())
        }
    }

    private fun setUpEditTextUpdateListeners() {
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val confirmPasswordEditText = findViewById<EditText>(R.id.confirmPasswordEditText)

        val textChangedListener = TextChangedListener {
            presenter.textInputsUpdated(getAccountDetails())
        }

        usernameEditText.addTextChangedListener(textChangedListener)
        passwordEditText.addTextChangedListener(textChangedListener)
        confirmPasswordEditText.addTextChangedListener(textChangedListener)
    }

    private fun getAccountDetails(): AccountDetails {
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val confirmPasswordEditText = findViewById<EditText>(R.id.confirmPasswordEditText)

        return AccountDetails(
            usernameEditText.text.toString(),
            passwordEditText.text.toString(),
            confirmPasswordEditText.text.toString()
        )
    }
}

fun Context.startCreateAccountActivity(populateUsername: String, populatePassword: String) {
    startActivity(
        Intent(this, CreateAccountActivity::class.java)
            .putExtra(CREATE_ACCOUNT_POPULATE_USERNAME, populateUsername)
            .putExtra(CREATE_ACCOUNT_POPULATE_PASSWORD, populatePassword)
    )
}
