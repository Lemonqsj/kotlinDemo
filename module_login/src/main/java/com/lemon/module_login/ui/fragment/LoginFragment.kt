package com.lemon.module_login.ui.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.lemon.lib_base.base.BaseFragment
import com.lemon.lib_base.config.AppConstants
import com.lemon.module_login.BR
import com.lemon.module_login.R
import com.lemon.module_login.databinding.LoginFragmentLoginBinding
import com.lemon.module_login.viewmodel.LoginViewModel
@Route(path = AppConstants.Router.Login.F_LOGIN)
class LoginFragment:BaseFragment<LoginFragmentLoginBinding,LoginViewModel>() {
    override fun initContentView(): Int {
        return R.layout.login_fragment_login
    }

    override fun initVariableId(): Int {
        return BR.viewmodel
    }
}