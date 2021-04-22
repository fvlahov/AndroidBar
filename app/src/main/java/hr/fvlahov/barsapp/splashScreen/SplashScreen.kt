package hr.fvlahov.barsapp.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import hr.fvlahov.barsapp.MainActivity
import hr.fvlahov.barsapp.R
import hr.fvlahov.barsapp.login.Login

class SplashScreen : AppCompatActivity() {
    private var TIME_OUT:Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        loadSplashScreen()
    }

    private fun loadSplashScreen(){
        Handler().postDelayed({
            // You can declare your desire activity here to open after finishing splash screen. Like MainActivity
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        },TIME_OUT)
    }
}