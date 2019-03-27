package com.dudu.tabexperiment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar:android.support.v7.widget.Toolbar
    private lateinit var tabLayout:TabLayout
    private lateinit var viewPager:ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()

        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                //To change body of created functions use File | Settings | File Templates.
                if (tab != null) {
                    viewPager.currentItem = tab.position
                }
            }
        })
    }

    private fun initComponent(){
        toolbar = findViewById(R.id.toolbar)
        // Create an instance of the tab layout from the view.
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.pager)

        setSupportActionBar(toolbar)

        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3))
        // Set the tabs to fill the entire layout.
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        // Use PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        val adapter = PagerAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter



    }
}
