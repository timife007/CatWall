package com.example.catwall.common.data.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import dagger.hilt.android.qualifiers.ApplicationContext
import java.net.ContentHandler
import javax.inject.Inject


//Created on 16/04/22 by Timife

//Check network status of device
class ConnectionManager @Inject constructor(@ApplicationContext private val context:Context){
    fun isConnected():Boolean{
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo : NetworkInfo? = manager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting == true
    }
}