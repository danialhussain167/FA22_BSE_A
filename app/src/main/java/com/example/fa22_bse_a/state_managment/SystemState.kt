package com.example.fa22_bse_a.state_managment

import com.example.fa22_bse_a.products.model.Product

class SystemState {

    var a:Int = 0
    companion object {
        var playerState: Boolean = true
        var loginState: Boolean = false
        var countState: Int = 0
        var product: Product? = null
    }
}