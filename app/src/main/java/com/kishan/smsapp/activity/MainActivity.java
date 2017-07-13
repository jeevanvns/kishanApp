package com.kishan.smsapp.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.kishan.smsapp.R;
import com.kishan.smsapp.adapter.ViewPagerAdapter;
import com.kishan.smsapp.fragment.FragmentContact;
import com.kishan.smsapp.fragment.FragmentSmsHistory;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean showToolbar() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initManualToolbar();
        TabLayout tlSms = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager vpSms = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(vpSms);
        tlSms.setupWithViewPager(vpSms);

    }

    private void setupViewPager(ViewPager vpSms) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentContact(), "Contact");
        adapter.addFragment(new FragmentSmsHistory(), "History");
        vpSms.setAdapter(adapter);
    }

    private void initManualToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }


    @Override
    protected void initListener() {

    }

    @Override
    protected void bindDataWithUi() {

    }
}
