package com.example.fa22_bse_a.login_migrated.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.circle_game.ui.GameActivity
import com.example.fa22_bse_a.databinding.LoginPageMigratedBinding
import com.example.fa22_bse_a.login_migrated.viewmodel.LoginViewModel
import com.example.fa22_bse_a.signup.ui.SignUpActivity

// View
class LoginMigratedActivity : AppCompatActivity() {

    private val tag = "LoginMigratedActivity"
    private var binding: LoginPageMigratedBinding? = null
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.login_page_migrated)

        binding?.loginViewModel = loginViewModel
        loginViewModel.context = this
        loginViewModel.initSharedPref()

        loginViewModel.loginStateMLD.observe(this) {
            if (it) {
                startActivity(Intent(this, GameActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid Email/Password", Toast.LENGTH_SHORT).show()
            }
        }

        loginViewModel.signUpStateMLD.observe(this) {
            if (it == true) {
                startActivity(Intent(this, SignUpActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            }
        }
    }
}