package me.joejames.kmmapp.androidApp.listener

import android.text.Editable
import android.text.TextWatcher

class TextChangedListener(private val callback: () -> Unit) : TextWatcher {
    override fun afterTextChanged(s: Editable?) { }
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        callback()
    }
}
