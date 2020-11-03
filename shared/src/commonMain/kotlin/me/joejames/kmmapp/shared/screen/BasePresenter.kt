package me.joejames.kmmapp.shared.screen

import me.joejames.kmmapp.shared.WeakReference
import me.joejames.kmmapp.shared.exception.ViewAccessException

abstract class BasePresenter<T: BaseView> {
    abstract val name: String

    private var _view: WeakReference<T>? = null

    val view: T
        get() = _view?.get() ?: throw ViewAccessException()

    fun takeView(view: T) {
        this._view = WeakReference(view)
    }

    fun dropView() {
        this._view?.clear()
        this._view = null
    }
}
