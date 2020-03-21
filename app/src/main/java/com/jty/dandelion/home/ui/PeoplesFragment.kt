package com.jty.dandelion.home.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jty.dandelion.R
import com.jty.dandelion.home.adapter.PeoplesAdapter
import com.jty.dandelion.home.adapter.PeoplesItemDecoration
import com.jty.dandelion.register.bean.User
import kotlinx.android.synthetic.main.fragment_peoples.*

class PeoplesFragment : Fragment(){
    private var userList:MutableList<User>? =null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_peoples, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        userList = mutableListOf()
        userList?.add(User("张三"))
        userList?.add(User("王五"))
        userList?.add(User("李四"))
        userList?.add(User("赵六"))
        userList?.add(User("周期"))
        userList?.add(User("倩儿"))
        userList?.add(User("算悟空"))
        userList?.add(User("猪八戒"))
        userList?.add(User("沙僧"))
        userList?.add(User("安妮"))
        userList?.add(User("河马"))
        userList?.add(User("豹子"))
        userList?.add(User("晁盖"))
        userList?.add(User("宋江"))
        userList?.add(User("花荣"))
        userList?.add(User("柴进"))
        userList?.add(User("鲁智深"))
        userList?.add(User("石秀"))
        userList?.add(User("武松"))
        val peoplesAdapter = PeoplesAdapter(userList)
        val layoutManager = LinearLayoutManager(activity)
        val peoplesItemDecoration = PeoplesItemDecoration().apply {
            groupHeaderTop =30
            groupHeaderLeft =40
        }
        peoples_rl.layoutManager =layoutManager
        peoples_rl.addItemDecoration(peoplesItemDecoration)
        peoples_rl.adapter = peoplesAdapter
        side_index_bar.onTouchLetter={
            bar_item_tv.visibility = View.VISIBLE
            bar_item_tv.text = it
            val position = peoplesAdapter.tags[it]
            if (position!=null) {
                (peoples_rl.layoutManager as? LinearLayoutManager)?.scrollToPositionWithOffset(position, 0)
            }
        }
        side_index_bar.onTouchLetterUp = {
            bar_item_tv.visibility = View.GONE
        }

    }
}