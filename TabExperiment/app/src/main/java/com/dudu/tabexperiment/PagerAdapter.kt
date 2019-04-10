package com.dudu.tabexperiment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class PagerAdapter(private var fm:FragmentManager, private var mNumOfTabs:Int): FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        //To change body of created functions use File | Settings | File Templates.
        return when(position) {
            0 -> TabFragment1()
            1 -> TabFragment2()
            2 -> TabFragment3()
            else -> null
        }
    }

    override fun getCount(): Int {
        //To change body of created functions use File | Settings | File Templates.
        return mNumOfTabs
    }
}