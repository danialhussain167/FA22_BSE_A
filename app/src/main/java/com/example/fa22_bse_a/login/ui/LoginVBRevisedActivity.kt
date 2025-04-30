package com.example.fa22_bse_a.login.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.circle_game.ui.GameActivity
import com.example.fa22_bse_a.databinding.LoginPageUsingVbRevisedBinding
import com.example.fa22_bse_a.login.model.LoginModel
import com.example.fa22_bse_a.share_pref.SharedPreferenceHelper
import com.example.fa22_bse_a.signup.ui.SignUpActivity
import com.example.fa22_bse_a.state_managment.SystemState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginVBRevisedActivity : AppCompatActivity() {

    val tag = "LoginVBRevisedActivity"

    var binding: LoginPageUsingVbRevisedBinding? = null
    var sharedPreferenceHelper: SharedPreferenceHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.login_page_using_vb_revised)

        val loginModel: LoginModel = LoginModel(email = "ali@gmail.com", password = "")
        binding?.loginModel = loginModel
        sharedPreferenceHelper = SharedPreferenceHelper(this)

        binding?.root?.setOnClickListener {
            Log.e(tag, "onCreate: email = ${sharedPreferenceHelper?.getData("email")}", )
            Log.e(tag, "onCreate: password = ${sharedPreferenceHelper?.getData("password")}", )
        }

        binding?.signupBtn?.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

        binding?.loginBtn?.setOnClickListener {
            if(loginModel.email == sharedPreferenceHelper?.getData("email") && loginModel.password == sharedPreferenceHelper?.getData("password"))
            {
                sharedPreferenceHelper?.saveData("IsLoggedIn", "YES")
                startActivity(Intent(this, GameActivity::class.java))
                finish()
            }
        }




//        lifecycleScope.launch(Dispatchers.IO) {
//            while(true) {
//                Log.e(tag, "loginModel: ${loginModel}", )
//                delay(1000)
//            }
//
//        }






//        val a:Int = 30
//
//        val systemState: SystemState = SystemState()
//        systemState.a = a
//
//
//
//        Toast.makeText(this, "SystemState().a = ${systemState.a}", Toast.LENGTH_SHORT).show()
    }
}