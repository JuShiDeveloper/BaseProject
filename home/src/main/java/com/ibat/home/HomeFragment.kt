package com.ibat.home

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ibat.home.databinding.FragmentHomeBinding
import com.jushi.library.base.BaseFragment
import com.jushi.library.crowdout.CrowdOutDialogActivity
import com.jushi.library.customView.calendarview.utils.CalendarUtil
import java.util.*

class HomeFragment : BaseFragment() {
    private lateinit var homeBinding: FragmentHomeBinding
    override fun initRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        return homeBinding.root
    }

    override fun initViewWidget() {
        val list: MutableList<String> = ArrayList()
        list.add("2021.4.11")
        list.add("2021.4.21")

        val cDate: IntArray =
            CalendarUtil.getCurrentDate()
        homeBinding.calendar.setStartEndDate("2021.1", "2050.12")
            .setDisableStartEndDate("2021.1.1", "2050.12.12")
            .setInitDate("${cDate[0]}.${cDate[1]}")
            .setSingleDate("${cDate[0]}.${cDate[1]}.${cDate[2]}")
            .setMultiDate(list)
            .init()
        setShowDate(cDate)
    }

    override fun initData() {
    }

    private fun setShowDate(cDate: IntArray) {
        homeBinding.tvYear.text = "${cDate[0]}年"
        homeBinding.tvMonth.text = "${cDate[1]}月"
    }

    override fun setListener() {
        homeBinding.crowdOutBtn.setOnClickListener { v ->
            startActivity(
                Intent(
                    context,
                    CrowdOutDialogActivity::class.java
                )
            )
        }
        homeBinding.calendar.setOnStartStopChooseListener { startDate, endDate ->
            Log.v(
                "yufei",
                "start Date = " + startDate.getDateBean().getSolar().get(0)
                    .toString() + "年" + startDate.getDateBean().getSolar().get(1)
                    .toString() + "月" + startDate.getDateBean().getSolar().get(2)
                    .toString() + "日"
            )
            Log.v(
                "yufei",
                "end Date = " + endDate.getDateBean().getSolar().get(0)
                    .toString() + "年" + endDate.getDateBean().getSolar().get(1)
                    .toString() + "月" + endDate.getDateBean().getSolar().get(2).toString() + "日"
            )
        }
        homeBinding.lastMonth.setOnClickListener { v -> homeBinding.calendar.lastMonth() }
        homeBinding.currentMonth.setOnClickListener { v -> homeBinding.calendar.today() }
        homeBinding.nextMonth.setOnClickListener { v -> homeBinding.calendar.nextMonth() }
        homeBinding.calendar.setOnPagerChangeListener { date ->
            setShowDate(date)
        }
        homeBinding.tvYear.setOnClickListener { v ->
            homeBinding.calendar.toSpecifyDate(
                2022,
                1,
                1
            )
        }
    }
}