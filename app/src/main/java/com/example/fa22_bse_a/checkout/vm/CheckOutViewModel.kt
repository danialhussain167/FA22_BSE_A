package com.example.fa22_bse_a.checkout.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CheckOutViewModel: ViewModel() {

    val cardNumberMLD: MutableLiveData<String> = MutableLiveData("")

}