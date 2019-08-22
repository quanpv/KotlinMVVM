package com.quanpv.kotlinmvvm.view.activity

import android.os.Bundle
import com.quanpv.kotlinmvvm.R
import com.quanpv.kotlinmvvm.view.base.BaseActivity
import com.quanpv.kotlinmvvm.view.fragment.CoinListFragment

class MainActivity : BaseActivity() {

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       replaceFragment(R.id.fragContainer, CoinListFragment.newInstance())
    }

}
