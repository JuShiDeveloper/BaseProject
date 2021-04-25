package com.ibat.bridge;

import com.ibat.home.HomeFragment;
import com.jushi.library.base.BaseFragmentActivity;
import com.jushi.library.customView.bottomNavgationView.BottomNavigationView;
import com.jushi.library.viewinject.FindViewById;

public class Ac extends BaseFragmentActivity {
    @FindViewById(R.id.bottomNavigationView)
    private BottomNavigationView bottomNavigationView;

    private Class list[] = {HomeFragment.class,};

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }
}
