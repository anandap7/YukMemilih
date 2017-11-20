package com.project.kuyk.yukmemilih;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.kuyk.yukmemilih.Menu.MenuActivity;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText nik, pw;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference().child("RegisteredUser");

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
            ref.addValueEventListener(new ValueEventListener() {
                boolean login = false;
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot data:dataSnapshot.getChildren()){
                        String nikUser = data.child("NIK").getValue().toString();
                        String pwUser = data.child("Password").getValue().toString();
                        if(nikUser.equals(nik.getText().toString()) && pwUser.equals(pw.getText().toString())){
                            login = true;
                            goToMenu();
                        }
                    }
                    if(!login)
                        Toast.makeText(getApplicationContext(), "NIK/Password salah", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            }
        });
    }

    public void goToMenu(){
        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
