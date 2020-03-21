package com.jty.dandelion.login.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_login.*
import com.jty.dandelion.R
import com.jty.dandelion.application.DandelionApplication
import com.jty.dandelion.home.ui.HomeActivity
import com.jty.dandelion.login.viewmodel.LoginViewModel
import com.jty.expand.emptyHint
import com.jty.expand.getViewModel
import com.jty.expand.showToast
import com.jty.expand.startActivity


/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
    }

    private fun initView(view: View) {
        getViewModel<LoginViewModel>().checkIsLogin.observe(this){
            if (it.success){
                DandelionApplication.getAccount().saveAcountId(it.message,activity)
                activity?.startActivity<HomeActivity>()
                activity?.finish()
            }else{
                activity?.showToast(it.message)
            }
        }
        tv_login.setOnClickListener {
            val emptyError = resources.getString(R.string.empty_error_text)
            var isEmpty = false
            val account = aet_account.text.toString().apply {
                isEmpty = emptyHint(emptyError, til_account)
            }
            val password = aet_password.text.toString().apply {
                isEmpty = emptyHint(emptyError, til_password)
            }
            if (isEmpty) return@setOnClickListener
            getViewModel<LoginViewModel>().checkLogin(account,password)
        }
        tv_register.setOnClickListener {
         view.findNavController().navigate(R.id.registerFragment)
    }
    }


}
