package com.example.fa22_bse_a.signup.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.databinding.ActivitySignupBinding
import com.example.fa22_bse_a.login.model.SignUpModel
import com.example.fa22_bse_a.login_migrated.ui.LoginMigratedActivity
import com.example.fa22_bse_a.share_pref.SharedPreferenceHelper

class SignUpActivity : AppCompatActivity() {

    val tag = "SignUpActivity"

    var binding: ActivitySignupBinding? = null

    var sharedPreferenceHelper: SharedPreferenceHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        val signupModel: SignUpModel = SignUpModel(email = "ali@gmail.com", password = "")
        sharedPreferenceHelper = SharedPreferenceHelper(this)
        binding?.signupModel = signupModel

        binding?.signupBtn?.setOnClickListener {
            sharedPreferenceHelper?.saveData("email", signupModel.email)
            sharedPreferenceHelper?.saveData("password", signupModel.password)

            startActivity(Intent(this, LoginMigratedActivity::class.java))
            finish()
        }
    }
}