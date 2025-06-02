package com.example.fa22_bse_a.login_migrated.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_a.FA22BSEApplication
import com.example.fa22_bse_a.app_local_database.data_base.LocalDataBase
import com.example.fa22_bse_a.login.model.LoginModel
import com.example.fa22_bse_a.login_migrated.model.LoginEntity
import com.example.fa22_bse_a.share_pref.SharedPreferenceHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// ViewModel
class LoginViewModel : ViewModel() {
    val TAG = this@LoginViewModel.javaClass.simpleName

    //    var context: Context? = null
    val loginModel: LoginModel = LoginModel(email = "ali@gmail.com", password = "", name = "")
    var sharedPreferenceHelper: SharedPreferenceHelper? = null


    val counterMLD: MutableLiveData<Int> = MutableLiveData(0)

    val loginStateMLD: MutableLiveData<Pair<String, Boolean>> = MutableLiveData()
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

    fun onLoginClick() {
        Log.e(TAG, "Login Attempt Successful")
        sharedPreferenceHelper?.saveData("IsLoggedIn", "YES")
        viewModelScope.launch(Dispatchers.IO) {
            val loginRecord: LoginEntity? = LocalDataBase.getInstance().getLoginEntityDao()
                .getLoginEntity(email = loginModel.email)
            if (loginRecord?.password == loginModel.password) {
                loginStateMLD.postValue(Pair(loginModel.email, true))
            } else {
                loginStateMLD.postValue(Pair(loginModel.email, false))
            }
        }
    }

    fun onSignUpTriggerClick() {
        runCatching {
            viewModelScope.launch(Dispatchers.IO) {
                val db: LocalDataBase = LocalDataBase.getInstance()
                db.getLoginEntityDao().insertLoginEntity(
                    LoginEntity(
                        email = loginModel.email,
                        password = loginModel.password,
                        name = loginModel.name
                    )
                )

            }
            signUpStateMLD.value = true
        }.fold(onSuccess = {
            Toast.makeText(
                FA22BSEApplication.getAppContext(),
                "SignUp Successful",
                Toast.LENGTH_SHORT
            ).show()
        }, onFailure = {
            Toast.makeText(FA22BSEApplication.getAppContext(), "SignUp Failed", Toast.LENGTH_SHORT)
                .show()
        })

    }

}