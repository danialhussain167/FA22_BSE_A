package com.example.fa22_bse_a.state_managment

class SystemState {

    var a:Int = 0
    companion object {
        var playerState: Boolean = true
        var loginState: Boolean = false
        var countState: Int = 0
    }
}