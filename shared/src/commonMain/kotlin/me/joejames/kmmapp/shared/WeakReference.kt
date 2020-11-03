package me.joejames.kmmapp.shared

expect class WeakReference<T : Any>(referred: T) {
    fun clear()
    fun get(): T?
}
