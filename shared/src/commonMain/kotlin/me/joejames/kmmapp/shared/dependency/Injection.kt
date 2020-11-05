package me.joejames.kmmapp.shared.dependency

import me.joejames.kmmapp.shared.screen.authentication.AuthenticationContract
import me.joejames.kmmapp.shared.screen.createaccount.CreateAccountContract

interface Injection {
    fun authenticationPresenter(): AuthenticationContract.Presenter
    fun createAccountPresenter(): CreateAccountContract.Presenter
}
