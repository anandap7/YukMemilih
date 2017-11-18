package com.project.kuyk.yukmemilih.Menu;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.project.kuyk.yukmemilih.R;

public class MenuActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager pager;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        pager = (ViewPager) findViewById(R.id.view_page);
        tabs = (TabLayout) findViewById(R.id.tabs_menu);
        pager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        tabs.setTabTextColors(getResources().getColor(android.R.color.black)
                ,getResources().getColor(android.R.color.white));
        tabs.setupWithViewPager(pager);
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
    }
}
