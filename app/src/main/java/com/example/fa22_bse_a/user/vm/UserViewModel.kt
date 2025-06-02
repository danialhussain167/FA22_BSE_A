package com.example.fa22_bse_a.user.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.fa22_bse_a.app_local_database.data_base.LocalDataBase
import com.example.fa22_bse_a.login_migrated.model.LoginEntity

class UserViewModel : ViewModel() {

    var loggedInPersonEmail: String = ""
    val loginList: LiveData<List<LoginEntity>> =
        LocalDataBase.getInstance().getLoginEntityDao().getAllLoginsAsFLow().asLiveData()

    val initiateChatMLD: MutableLiveData<String> = MutableLiveData()


    fun triggerChatProcess(userEmail: String) {
        initiateChatMLD.value = userEmail
    }


}