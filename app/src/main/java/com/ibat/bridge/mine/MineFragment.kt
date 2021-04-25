package com.ibat.bridge.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ibat.bridge.R
import com.jushi.library.base.BaseFragment

class MineFragment :BaseFragment() {
    override fun initRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_mine,container,false)

    override fun initViewWidget() {

    }

    override fun initData() {
    }

    override fun setListener() {
    }
}