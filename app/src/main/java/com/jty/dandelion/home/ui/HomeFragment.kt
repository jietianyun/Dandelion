package com.jty.dandelion.home.ui


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.jty.dandelion.R
import com.jty.dandelion.home.adapter.HomeAdapter
import com.jty.expand.showStatusBar


class HomeFragment : Fragment() {

    private var homeViewPager : ViewPager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback{
            activity?.finish()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.showStatusBar()
        setupViewPager(homeViewPager)
    }

    var menuItem: MenuItem? = null
    private fun initView(view: View){
        homeViewPager= view.findViewById(R.id.home_view_pager)
        val homeNavView = view.findViewById<BottomNavigationView>(R.id.home_nav_view)
        homeNavView.setOnNavigationItemSelectedListener {
           return@setOnNavigationItemSelectedListener when(it.itemId){
                R.id.item_news ->
                {homeViewPager?.setCurrentItem(0, false); true}
                R.id.item_peoples ->
                {homeViewPager?.setCurrentItem(1, false); true}
                R.id.item_data ->
                {homeViewPager?.setCurrentItem(2, false); true}
                R.id.item_mine ->
                {homeViewPager?.setCurrentItem(3, false); true}
                else -> false
           }
        }
        homeViewPager?.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                if (menuItem == null){
                    menuItem = homeNavView.menu[0]
                }else{
                    menuItem?.isChecked = false
                }
                menuItem = homeNavView.menu[position]
                menuItem?.isChecked = true
            }
        })
    }

    private fun setupViewPager(homeViewPager: ViewPager?) {
        val supportFragmentManager= activity?.supportFragmentManager ?: return
        Log.d("homeFragment", "$activity+$supportFragmentManager+$homeViewPager")
        homeViewPager?.adapter = HomeAdapter(supportFragmentManager)
    }
}
