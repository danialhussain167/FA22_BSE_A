package com.example.fa22_bse_a.login.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.login.model.LoginModel

class LoginActivity : AppCompatActivity() {


    val tag = "MainActivity"
    var passwordToggel: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        val loginButton: Button
        loginButton = findViewById(R.id.login_btn)
        val emailEt: EditText = findViewById(R.id.email_et)
        val passwordEt: EditText = findViewById(R.id.password_et)
        val passwordVisibility: ImageView = findViewById(R.id.password_visibility)
        val defaultLoginMode: LoginModel = LoginModel()

        emailEt.setText(defaultLoginMode.email)
        passwordEt.setText(defaultLoginMode.password)
        var loginModel: LoginModel
        loginButton.setOnClickListener {
            Log.e(tag, "Login button clicked")
//            Log.e(tag, "Entered Email = ${emailEt.text}" )
//            Log.e(tag, "Entered Password = ${passwordEt.text}" )
            loginModel =
                LoginModel(email = emailEt.text.toString(), password = passwordEt.text.toString())
            Log.e(tag, "Login Model = $loginModel", )
        }

        passwordVisibility.setOnClickListener { it ->
            Log.e(tag, "passwordVisibility: ${passwordEt.inputType}")
            passwordToggel = !passwordToggel
            if (passwordToggel) {
                passwordVisibility.setImageResource(R.drawable.baseline_not_interested_24)
            } else {
                passwordVisibility.setImageResource(R.drawable.baseline_remove_red_eye_24)
            }
            passwordEt.inputType = if (passwordToggel) 1 else 129
        }
    }
}