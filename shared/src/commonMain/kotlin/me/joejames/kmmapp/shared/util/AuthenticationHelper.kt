package me.joejames.kmmapp.shared.util

const val MINIMUM_USERNAME_LENGTH = 3
const val MINIMUM_PASSWORD_LENGTH = 3

fun String.isValidUsername() =
    this.length >= MINIMUM_USERNAME_LENGTH

fun String.isValidPassword() =
    this.length >= MINIMUM_PASSWORD_LENGTH
