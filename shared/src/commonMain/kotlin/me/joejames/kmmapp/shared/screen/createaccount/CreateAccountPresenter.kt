package me.joejames.kmmapp.shared.screen.createaccount

import me.joejames.kmmapp.shared.model.account.AccountDetails
import me.joejames.kmmapp.shared.model.alert.AlertAction
import me.joejames.kmmapp.shared.util.isValidPassword
import me.joejames.kmmapp.shared.util.isValidUsername

class CreateAccountPresenter : CreateAccountContract.Presenter() {
    override fun createAccountButtonTapped(accountDetails: AccountDetails) {
        view.showAlert(
            "Create account button tapped",
            AlertAction("OK") { println("Create account button closed") },
            AlertAction("Cancel") { println("Create account button cancelled") }
        )
    }

    override fun textInputsUpdated(accountDetails: AccountDetails) {
        val createAccountButtonShouldBeEnabled =
            accountDetails.username.isValidUsername() &&
            accountDetails.password.isValidPassword() &&
            accountDetails.confirmPassword.isValidPassword()

        view.setCreateAccountButtonIsEnabled(createAccountButtonShouldBeEnabled)
    }
}
