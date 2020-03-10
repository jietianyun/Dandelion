package com.jty.dandelion.login.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_login.*
import com.jty.dandelion.R
import com.jty.dandelion.home.ui.HomeActivity
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
        tv_login.setOnClickListener {
            activity?.startActivity<HomeActivity>()
        }
        tv_register.setOnClickListener {
         view.findNavController().navigate(R.id.registerFragment)
    }
    }

}
