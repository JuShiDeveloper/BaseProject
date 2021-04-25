package com.ibat.bridge.app

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.support.multidex.MultiDex
import com.jushi.library.base.BaseApplication
import com.jushi.library.share_data.ShareSparse
import com.jushi.library.share_data.user.User
import com.jushi.library.utils.ToastUtil

class BridgeApplication : BaseApplication(), Application.ActivityLifecycleCallbacks {

    companion object {
        private lateinit var app: BridgeApplication
        fun getInstance(): BridgeApplication = app
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        if (getUIPName(this) == packageName) {
            registerActivityLifecycleCallbacks(this)
        }
        val user = User()
        user.id = "6"
        user.psd = "admin123"
        user.email = "wangyufei@mobilecpx.com"
//        user.email = "wangyufei@qq.com"
        user.city = "ChengDu"
        user.userName = "wangyufei@mobilecpx.com"
        user.localLg = "ar_IL"
        user.isLogin = true
        user.token =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MywiZXhwIjoxNTQ2ODIzMTAwfQ.TI9-QAtar-9cQ4lvIkJXF_mf_bSRkpJ6ZKAjCKULL_E"
        ShareSparse.putValue(ShareSparse.USER_CLS, user, true)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        if (getUIPName(this) != packageName) return
        MultiDex.install(this)
    }

    override fun onActivityPaused(activity: Activity?) {
//        handler.postDelayed({ ToastUtil.showToast(activity, "温馨提示：程序已经切换到后台") }, 1000)
    }

    override fun onActivityResumed(activity: Activity?) {
    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
    }

}