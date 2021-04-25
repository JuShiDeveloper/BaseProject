package com.ibat.bridge

import android.content.Intent
import android.support.v4.app.Fragment
import com.ibat.home.HomeFragment
import com.ibat.bridge.mine.MineFragment
import com.ibat.bridge.reportforms.ReportFormsFragment
import com.ibat.bridge.workbench.WorkbenchFragment
import com.jushi.library.base.BaseFragmentActivity
import com.jushi.library.router.FragmentRouter
import com.jushi.library.router.RouterList
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * 项目主页面，该页面承载首页、工作台、报表、我的四个模块
 * create by wangYuFei on 2021/4/21
 */
class MainActivity : BaseFragmentActivity() {

    private val fragmentArray = ArrayList<Fragment>()

    override fun getLayoutResId(): Int {
        setSystemBarStatus(true, true, false)
        return R.layout.activity_main
    }

    override fun initView() {
//        fragmentArray.add(HomeFragment())
        fragmentArray.add(FragmentRouter.getFragment(RouterList.HOME_FRAGMENT)!!)
        fragmentArray.add(WorkbenchFragment())
        fragmentArray.add(ReportFormsFragment())
        fragmentArray.add(MineFragment())
        bottomNavigationView.setFragmentLayoutId(R.id.fragment_content)
        bottomNavigationView.setFragmentsArray(supportFragmentManager, fragmentArray)
    }

    override fun getIntentData(intent: Intent?) {

    }

    override fun initData() {
    }

    override fun setListener() {
        bottomNavigationView.setOnTabSelectListener { index ->

        }
    }


}
