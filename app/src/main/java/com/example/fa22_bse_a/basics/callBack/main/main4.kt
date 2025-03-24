package com.example.fa22_bse_a.basics.callBack.main

import com.example.fa22_bse_a.basics.nested_strctures.model.Address
import com.example.fa22_bse_a.basics.nested_strctures.model.City

fun main() {

    showDataIfNotEmpty(
        Address(
            houseNumber = "123",
            streetNumber = "1",
            blockNumber = "AD",
            society = "COMSATS",
            city = City(name = "Sahiwal", postalCode = arrayListOf("4532"))
        ),
        showCallBack = {
            println("Address = $it")
        }
    )

}


fun showDataIfNotEmpty(address: Address, showCallBack: (Address) -> Unit) {
    if(address.houseNumber != "") {
        showCallBack.invoke(address)
    }
}