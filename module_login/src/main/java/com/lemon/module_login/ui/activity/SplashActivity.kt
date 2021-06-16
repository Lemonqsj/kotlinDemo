package com.lemon.module_login.ui.activity

import com.blankj.utilcode.util.ScreenUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.lemon.lib_base.base.BaseActivity
import com.lemon.lib_base.config.AppConstants
import com.lemon.lib_base.route.RouteCenter
import com.lemon.lib_base.utils.DayModeUtil
import com.lemon.module_login.BR
import com.lemon.module_login.R
import com.lemon.module_login.databinding.LoginActivitySplashBinding
import com.lemon.module_login.viewmodel.SplashViewModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.*
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity<LoginActivitySplashBinding, SplashViewModel>() {

    private val arrayLight = arrayListOf(R.drawable.splash_bg_light, R.drawable.bg_splash_light2)
    private val arrayDark = arrayListOf(R.drawable.splash_bg_dark, R.drawable.bg_splash_dark2)


    override fun initLayoutContentView(): Int {
        return R.layout.login_activity_splash
    }

    /**
     * 初始化页面传入的数据
     */
    override fun initParam() {

    }

    override fun initData() {
        initSplashBg()
        toLogin()
    }

    private fun toLogin() {
        viewModel.addSubscribe(
            Flowable.timer(1500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (viewModel.model.getLoginName().isNullOrBlank()) {
                        startContainerActivity(AppConstants.Router.Login.F_LOGIN)
                        overridePendingTransition(R.anim.h_fragment_enter, 0)
                    } else {
                        RouteCenter.navigate(AppConstants.Router.Main.A_MAIN)
                    }

                    finish()
                }
        )
    }

    private fun initSplashBg() {
        Glide.with(this)
            .load(
                if (DayModeUtil.isNightMode(this))
                    arrayDark[Random().nextInt(arrayDark.size)]
                else arrayLight[Random().nextInt(arrayLight.size)]
            )
            .override(ScreenUtils.getAppScreenWidth(), ScreenUtils.getAppScreenHeight())
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .skipMemoryCache(true)
            .into(binding.ivSplash)
    }

    override fun initViewObservable() {

    }

    override fun initViewModelId(): Int {
        return BR.viewmodel
    }
}