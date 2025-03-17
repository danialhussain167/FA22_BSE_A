package com.example.fa22_bse_a.login.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.TiktakActivity
import com.example.fa22_bse_a.databinding.LoginPageUsingVbBinding
import com.example.fa22_bse_a.login.model.LoginModel
import com.example.fa22_bse_a.state_managment.SystemState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginVBActivity : AppCompatActivity() {


    val tag = "MainActivity"
    var passwordToggel: Boolean = false

    val actualEmail = "ali@gmail.com"
    val actualPassword = "123456"

    var binding: LoginPageUsingVbBinding? = null
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.login_page)
        binding = DataBindingUtil.setContentView(this, R.layout.login_page_using_vb)
        Toast.makeText(this, "$tag onCreate", Toast.LENGTH_SHORT).show()




//
//        lifecycleScope.launch(Dispatchers.IO) {
//            while (true) {
//                withContext(Dispatchers.Main) {
        val loginModel = LoginModel(email = "ali1@gmail.com", password = "456789")
        binding?.loginButtonText = "Login"
        binding?.loginModel = loginModel

        lifecycleScope.launch(Dispatchers.IO) {
            while(true) {
                Log.e(tag, "onCreate: loginModel = ${loginModel}", )
                delay(1000)
            }
        }



//                }
//                count++
//                delay(50)
//            }
//        }


//        val loginButton: Button
//        loginButton = findViewById(R.id.login_btn)
//        val emailEt: EditText = findViewById(R.id.email_et)
//        val passwordEt: EditText = findViewById(R.id.password_et)
//        val passwordVisibility: ImageView = findViewById(R.id.password_visibility)
//        val defaultLoginMode: LoginModel = LoginModel()
//
//        binding?.emailEt?.setText(defaultLoginMode.email)
//        binding?.passwordEt?.setText(defaultLoginMode.password)


//        var loginModel: LoginModel
        binding?.loginBtn?.setOnClickListener {
            Log.e(tag, "Login button clicked")
//            Log.e(tag, "Entered Email = ${emailEt.text}" )
//            Log.e(tag, "Entered Password = ${passwordEt.text}" )
//            loginModel =
//                LoginModel(
//                    email = binding?.emailEt?.text.toString(),
//                    password = binding?.passwordEt?.text.toString()
//                )
            if (loginModel.email == actualEmail && loginModel.password == actualPassword) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                SystemState.loginState = true
                val tiktackIntent =
                    Intent(this, TiktakActivity::class.java).putExtra("email", actualEmail)
                        .putExtra("password", actualPassword)
                startActivity(tiktackIntent)
                finish()
            } else {
                Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show()
            }
            Log.e(tag, "Login Model = $loginModel")
        }

        binding?.passwordVisibility?.setOnClickListener { it ->
            Log.e(tag, "passwordVisibility: ${binding?.passwordEt?.inputType}")
            passwordToggel = !passwordToggel
            if (passwordToggel) {
                binding?.passwordVisibility?.setImageResource(R.drawable.baseline_not_interested_24)
            } else {
                binding?.passwordVisibility?.setImageResource(R.drawable.baseline_remove_red_eye_24)
            }
            binding?.passwordEt?.inputType = if (passwordToggel) 1 else 129
        }
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "$tag onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "$tag onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "$tag onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "$tag onDestroy", Toast.LENGTH_SHORT).show()
    }
}