package com.example.fa22_bse_a.login.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.databinding.LoginPageUsingVbRevisedBinding
import com.example.fa22_bse_a.login.model.LoginModel
import com.example.fa22_bse_a.state_managment.SystemState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginVBRevisedActivity : AppCompatActivity() {

    val tag = "MainActivity"
    var passwordToggel: Boolean = false

    val actualEmail = "ali@gmail.com"
    val actualPassword = "123456"

    var binding: LoginPageUsingVbRevisedBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.login_page)
        binding = DataBindingUtil.setContentView(this, R.layout.login_page_using_vb_revised)

        Toast.makeText(this, "${intent.extras?.get("abc")}", Toast.LENGTH_SHORT).show()

        binding?.emailEt?.setText("ali@gmail.com")
        binding?.passwordEt?.setText("123456")

        val loginModel: LoginModel = LoginModel(email = "ali@gmail.com", password = "123456")
        binding?.loginModel = loginModel

        lifecycleScope.launch(Dispatchers.IO) {
            while(true) {
                Log.e(tag, "loginModel: ${loginModel}", )
                delay(1000)
            }

        }






        val a:Int = 30

        val systemState: SystemState = SystemState()
        systemState.a = a



        Toast.makeText(this, "SystemState().a = ${systemState.a}", Toast.LENGTH_SHORT).show()
    }
}