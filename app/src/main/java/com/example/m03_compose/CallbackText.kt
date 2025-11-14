package com.example.m03_compose

fun C1(){
    var v1 = 123
    C2(){
        v1 = it
    }
}

fun C2(callBack : (Int) -> Unit) {
    var v2 = 456
    callBack(v2)
}