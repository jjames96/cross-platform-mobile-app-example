package me.joejames.kmmapp.shared.screen

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import me.joejames.kmmapp.shared.model.account.AccountDetails
import me.joejames.kmmapp.shared.screen.createaccount.CreateAccountContract
import me.joejames.kmmapp.shared.screen.createaccount.CreateAccountPresenter
import kotlin.test.BeforeTest
import kotlin.test.Test

class CreateAccountPresenterTest {
    @RelaxedMockK
    private lateinit var view: CreateAccountContract.View

    private lateinit var presenter: CreateAccountContract.Presenter

    @BeforeTest
    fun setUp() {
        MockKAnnotations.init(this)

        presenter = CreateAccountPresenter()

        presenter.takeView(view)
    }

    @Test
    fun alertShownWhenCreateAccountButtonTapped() {
        val accountDetails = AccountDetails(
            "username",
            "password",
            "password"
        )

        presenter.createAccountButtonTapped(accountDetails)

        verify { view.showAlert("Create account button tapped") }
    }

    @Test
    fun createAccountButtonDisabledWhenTextInputsUpdatedWithShortUsername() {
        val accountDetails = AccountDetails(
            "ab",
            "abc",
            "abc"
        )

        presenter.textInputsUpdated(accountDetails)

        verify { view.setCreateAccountButtonIsEnabled(false) }
    }

    @Test
    fun createAccountButtonDisabledWhenTextInputsUpdatedWithShortPassword() {
        val accountDetails = AccountDetails(
            "abc",
            "ab",
            "abc"
        )

        presenter.textInputsUpdated(accountDetails)

        verify { view.setCreateAccountButtonIsEnabled(false) }
    }

    @Test
    fun createAccountButtonDisabledWhenTextInputsUpdatedWithShortConfirmPassword() {
        val accountDetails = AccountDetails(
            "abc",
            "abc",
            "ab"
        )

        presenter.textInputsUpdated(accountDetails)

        verify { view.setCreateAccountButtonIsEnabled(false) }
    }

    @Test
    fun createAccountButtonEnabledWhenTextInputsUpdatedWithLongValues() {
        val accountDetails = AccountDetails(
            "abc",
            "abc",
            "abc"
        )

        presenter.textInputsUpdated(accountDetails)

        verify { view.setCreateAccountButtonIsEnabled(true) }
    }
}
