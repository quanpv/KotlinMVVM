package com.quanpv.kotlinmvvm.view.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.quanpv.kotlinmvvm.R
import com.quanpv.kotlinmvvm.service.Status
import com.quanpv.kotlinmvvm.view.adapter.ListCoinAdapter
import com.quanpv.kotlinmvvm.view.base.BaseFragment
import com.quanpv.kotlinmvvm.viewmodel.CoinListViewModel
import kotlinx.android.synthetic.main.fragment_list_coin.*

class CoinListFragment : BaseFragment<CoinListViewModel>() {
    override fun getViewModel(): Class<CoinListViewModel> {
        return CoinListViewModel::class.java
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_list_coin
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadingStatus.observe(this, Observer {
            if (it != null && it.data) {
                println("quanpv-------->Loading")
            } else if (it != null && !it.data) {
                println("quanpv-------->Done Loading")
            }
        })
        viewModel.response.observe(this,
            Observer {
                if (it != null && it.status == Status.SUCCESS) {
                    recyclerView.adapter = ListCoinAdapter(it.data)
                    println("quanpv: ${it.data[1].name}")

                } else if (it != null && it.status == Status.ERROR){
                    println("quanpv-------->${it.message}")
                }

            })
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    companion object {

        fun newInstance(): CoinListFragment {
            val args = Bundle()
            val fragment = CoinListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
