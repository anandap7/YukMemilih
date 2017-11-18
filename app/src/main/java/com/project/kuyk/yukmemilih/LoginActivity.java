package com.project.kuyk.yukmemilih;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.kuyk.yukmemilih.Menu.MenuActivity;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText nik, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.btnLogin);
        nik = (EditText) findViewById(R.id.etNikLogin);
        pw = (EditText) findViewById(R.id.etPasswordLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
