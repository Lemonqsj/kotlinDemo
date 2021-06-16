package com.lemon.module_login.viewmodel

import androidx.databinding.ObservableField
import com.lemon.lib_base.base.BaseViewModel
import com.lemon.lib_base.base.MyApplication
import com.lemon.lib_base.data.DataRespository

class LoginViewModel(application: MyApplication, data: DataRespository) :
    BaseViewModel<DataRespository>(application, data) {
    var account = ObservableField("")
    var pwd = ObservableField("")

}