package me.joejames.kmmapp.androidApp.dependency

import me.joejames.kmmapp.shared.dependency.Injection
import me.joejames.kmmapp.shared.screen.authentication.AuthenticationPresenter

class InjectionImpl : Injection {
    override fun authenticationPresenter() = AuthenticationPresenter()
}

val injection = InjectionImpl()
