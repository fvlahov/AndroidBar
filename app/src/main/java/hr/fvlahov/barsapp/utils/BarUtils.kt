package hr.fvlahov.barsapp.utils

import android.util.Base64
import hr.fvlahov.barsapp.model.Bar
import hr.fvlahov.barsapp.model.User
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class BarUtils {
    companion object {
        val encryptionPassword = "AJQTSSjdXh"
        lateinit var currentUser: User
    }
}