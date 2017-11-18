package com.project.kuyk.yukmemilih.Register;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.kuyk.yukmemilih.Adapter.FragmentAdapterRegister;
import com.project.kuyk.yukmemilih.R;

public class RegisterActivity extends AppCompatActivity {
    ViewPager pager;
    Button check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        pager = (ViewPager) findViewById(R.id.view_page);
        check = (Button) findViewById(R.id.btnCheck);

        pager.setAdapter(new FragmentAdapterRegister(getSupportFragmentManager()));

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new PwInsertFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nidCheck,fragment)
                        .commit();
            }
        });
    }
}
