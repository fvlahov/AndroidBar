package hr.fvlahov.barsapp.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import hr.fvlahov.barsapp.MainActivity
import hr.fvlahov.barsapp.R
import hr.fvlahov.barsapp.dal.implementations.UserRepo
import hr.fvlahov.barsapp.model.Bar
import hr.fvlahov.barsapp.model.User
import hr.fvlahov.barsapp.utils.BarUtils
import hr.fvlahov.barsapp.utils.encrypt

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    fun login(view: View) {
        val error = findViewById<TextView>(R.id.tv_Error)
        error.visibility = View.INVISIBLE

        var user = UserRepo().authenticateUser(findViewById<EditText>(R.id.et_Username).text.toString(), findViewById<EditText>(R.id.et_Password).text.toString())

        if(user != null){
            BarUtils.currentUser = user
        } else{
            error.visibility = View.VISIBLE
        }


        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}