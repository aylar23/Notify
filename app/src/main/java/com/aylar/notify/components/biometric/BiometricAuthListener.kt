package com.aylar.notify.components.biometric

interface BiometricAuthListener {
    fun onBiometricAuthSuccess()
    fun onUserCancelled()
    fun onErrorOccurred()
}
