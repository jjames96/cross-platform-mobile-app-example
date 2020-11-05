package me.joejames.kmmapp.shared.dependency

import me.joejames.kmmapp.shared.screen.authentication.AuthenticationContract

interface Injection {
    fun authenticationPresenter(): AuthenticationContract.Presenter
}
