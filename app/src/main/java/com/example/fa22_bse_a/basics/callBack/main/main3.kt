package com.example.fa22_bse_a.basics.callBack.main

import com.example.fa22_bse_a.basics.callBack.model.DownloadResponseModel

fun main() {

    downloadFile(fileUrl = "www.bin.com/cv.pdf", urlVerifyCallBack = { message ->
        println(message)
    }, downloadStartedCallBack = { message ->
        println(message)
    }, inProgressCallBack = { message, progress ->
//        println("$message $progress")
    }, inProgressCallBack2 = {
        println("${it.message} ${it.progress}")
    }, completedCallBack = { message ->
        println(message)
    }, storedCallBack = { message, path ->
        println("$message $path")
    })

}

fun downloadFile(
    fileUrl: String, urlVerifyCallBack: (String) -> Unit,
    downloadStartedCallBack: (String) -> Unit,
    inProgressCallBack: (String, Int) -> Unit,
    inProgressCallBack2: (DownloadResponseModel) -> Unit,
    completedCallBack: (String) -> Unit,
    storedCallBack: (String, String) -> Unit
) {
    println("We are going to download file -> ${fileUrl}")
    urlVerifyCallBack.invoke("The URL ($fileUrl) is a valid url")
    downloadStartedCallBack.invoke("Downloading URL ($fileUrl) is started")
    for (progress in 0..100) {
        if (progress % 10 == 0) {
            inProgressCallBack.invoke("Current download progreess of file ($fileUrl) = ", progress)
            inProgressCallBack2.invoke(DownloadResponseModel(message = "Current download progreess of file ($fileUrl) = ", progress = progress))
        }
    }
    completedCallBack.invoke("File ($fileUrl) is now downloaded")
    storedCallBack.invoke("File stored in folder : ", "C:/Users/ali/download/documents/")
}