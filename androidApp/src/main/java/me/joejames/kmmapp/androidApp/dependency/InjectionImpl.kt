package me.joejames.kmmapp.androidApp.dependency

import me.joejames.kmmapp.shared.dependency.Injection
import me.joejames.kmmapp.shared.screen.authentication.AuthenticationPresenter
import me.joejames.kmmapp.shared.screen.createaccount.CreateAccountPresenter

class InjectionImpl : Injection {
    override fun authenticationPresenter() = AuthenticationPresenter()
    override fun createAccountPresenter() = CreateAccountPresenter()
}

val injection = InjectionImpl()
