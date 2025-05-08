package com.example.fa22_bse_a.login_migrated.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_a.FA22BSEApplication
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.app_local_database.data_base.LocalDataBase
import com.example.fa22_bse_a.circle_game.ui.GameActivity
import com.example.fa22_bse_a.databinding.LoginPageMigratedBinding
import com.example.fa22_bse_a.login_migrated.model.LoginEntity
import com.example.fa22_bse_a.login_migrated.viewmodel.LoginViewModel
import com.example.fa22_bse_a.signup.ui.SignUpActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


// View
class LoginMigratedActivity : AppCompatActivity() {

    private val tag = "LoginMigratedActivity"
    private var binding: LoginPageMigratedBinding? = null
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.login_page_migrated)

        binding?.loginViewModel = loginViewModel
//        loginViewModel.context = this
//        loginViewModel.initSharedPref()

        // database

        lifecycleScope.launch(Dispatchers.IO) {
            val db: LocalDataBase = LocalDataBase.getInstance()
            val loginList: List<LoginEntity> = db.getLoginEntityDao().getAllLogins()

            Log.e(tag, "onCreate: loginList = $loginList", )
        }






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