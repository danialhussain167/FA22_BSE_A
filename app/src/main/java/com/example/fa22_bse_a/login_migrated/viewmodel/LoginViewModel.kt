package com.example.fa22_bse_a.login_migrated.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_a.login.model.LoginModel
import com.example.fa22_bse_a.share_pref.SharedPreferenceHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// ViewModel
class LoginViewModel : ViewModel() {
    val TAG = this@LoginViewModel.javaClass.simpleName
    var context: Context? = null
    val loginModel: LoginModel = LoginModel(email = "ali@gmail.com", password = "")
    var sharedPreferenceHelper: SharedPreferenceHelper? = null

    val counterMLD: MutableLiveData<Int> = MutableLiveData(0)

    val loginStateMLD: MutableLiveData<Boolean> = MutableLiveData()
    val signUpStateMLD: MutableLiveData<Boolean> = MutableLiveData()

    // constructor
    init {

        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                delay(1000)
                withContext(Dispatchers.Main) {
                    counterMLD.value = (counterMLD.value ?: 0) + 1
                }
            }
        }
    }

    fun initSharedPref() {
        sharedPreferenceHelper = SharedPreferenceHelper(context!!)
    }


    fun onLoginClick() {
        if (loginModel.email == sharedPreferenceHelper?.getData("email") && loginModel.password == sharedPreferenceHelper?.getData(
                "password"
            )
        ) {
            Log.e(TAG, "Login Attempt Successful")
            sharedPreferenceHelper?.saveData("IsLoggedIn", "YES")
            loginStateMLD.value = true

        } else {
            Log.e(TAG, "Invalid Email / Password")
            loginStateMLD.value = false
        }
    }

    fun onSignUpTriggerClick() {
//        if(loginModel.email.isNotEmpty() && loginModel.password.isNotEmpty() && loginModel.password.length > 5) {
//
//        } else {
        signUpStateMLD.value = true
//        }
    }

}