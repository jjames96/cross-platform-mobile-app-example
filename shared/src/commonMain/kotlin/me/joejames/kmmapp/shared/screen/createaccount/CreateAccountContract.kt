package me.joejames.kmmapp.shared.screen.createaccount

import me.joejames.kmmapp.shared.model.account.AccountDetails
import me.joejames.kmmapp.shared.screen.BasePresenter
import me.joejames.kmmapp.shared.screen.BaseView

interface CreateAccountContract {
    interface View : BaseView {
        fun setCreateAccountButtonIsEnabled(isEnabled: Boolean)
    }

    abstract class Presenter : BasePresenter<View>() {
        override val name = "CreateAccount"
        abstract fun textInputsUpdated(accountDetails: AccountDetails)
        abstract fun createAccountButtonTapped(accountDetails: AccountDetails)
    }
}
