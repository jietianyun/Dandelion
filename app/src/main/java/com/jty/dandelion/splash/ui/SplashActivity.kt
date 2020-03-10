package com.jty.dandelion.splash.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import com.jty.dandelion.R
import com.jty.dandelion.home.ui.HomeActivity
import com.jty.dandelion.login.ui.LoginActivity
import com.jty.dandelion.splash.viewmodel.SplashViewModel
import com.jty.expand.getViewModel
import com.jty.expand.hideStatusBar
import com.jty.expand.startActivity

class SplashActivity : AppCompatActivity() {

    private val handler by lazy {
        Handler()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusBar()
        setContentView(R.layout.activity_splash)
        checkLogin()
    }

    private fun checkLogin(){
        val viewModel = getViewModel<SplashViewModel>()
        viewModel.loginStatus.observe(this, Observer {
            if (it) {
                startActivity<HomeActivity>()
                finish()
            }else{
                delayStartLoginActivity()
            }
        })
        viewModel.checkLogin(this)
    }


    private fun delayStartLoginActivity(){
        handler.postDelayed({
            startActivity<LoginActivity>()
            finish()
        }, 2000)
    }
}
