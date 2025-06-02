package com.example.fa22_bse_a.login_migrated.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.app_local_database.data_base.LocalDataBase
import com.example.fa22_bse_a.databinding.LoginPageMigratedBinding
import com.example.fa22_bse_a.login_migrated.model.LoginEntity
import com.example.fa22_bse_a.login_migrated.viewmodel.LoginViewModel
import com.example.fa22_bse_a.user.ui.UserListActivity
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

            Log.e(tag, "onCreate: loginList = $loginList")
        }

        loginViewModel.loginStateMLD.observe(this) {
            if (it.second) {
                startActivity(
                    Intent(this, UserListActivity::class.java).putExtra(
                        "email",
                        it.first
                    )
                )
                finish()
            } else {
                Toast.makeText(this, "Invalid Email/Password", Toast.LENGTH_SHORT).show()
            }
        }

        loginViewModel.signUpStateMLD.observe(this) {
        }
    }
}