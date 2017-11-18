package com.project.kuyk.yukmemilih.Menu;

import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;

import com.project.kuyk.yukmemilih.R;

public class MenuActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager pager;
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        pager = (ViewPager) findViewById(R.id.pager);
        tab = (TabLayout) findViewById(R.id.tab_layout);

        setSupportActionBar(toolbar);
        pager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        tab.setTabTextColors(getResources().getColor(android.R.color.black),
                getResources().getColor(android.R.color.white));
        tab.setupWithViewPager(pager);
        tab.setTabGravity(TabLayout.GRAVITY_FILL);
    }
}
