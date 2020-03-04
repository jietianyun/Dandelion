package com.jty.dandelion.splash.ui


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jty.dandelion.R
import com.jty.dandelion.splash.viewmodel.SplashViewModel
import com.jty.expand.getViewModel


/**
 * A simple [Fragment] subclass.
 *
 */
class SplashFragment : Fragment() {

    private val handler by lazy {
        Handler()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkLogin()
    }

    private fun checkLogin(){
        val viewModel = getViewModel<SplashViewModel>()
        viewModel.loginStatus.observe(this, Observer {
            if (it) {
                delayStartLoginActivity()
            }else{
                findNavController().navigate(R.id.registerFragment)
            }
        })
        viewModel.checkLogin()
    }


    private fun delayStartLoginActivity(){
        handler.postDelayed({
        findNavController().navigate(R.id.loginFragment)
        }, 2000)
    }

}
