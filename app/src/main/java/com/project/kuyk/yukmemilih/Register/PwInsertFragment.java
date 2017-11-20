package com.project.kuyk.yukmemilih.Register;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.kuyk.yukmemilih.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PwInsertFragment extends Fragment {
    TextView data;
    EditText pw1, pw2;
    Button create;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/fireblog");

    public PwInsertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pw_insert, container, false);
        data = (TextView) v.findViewById(R.id.dataPenduduk);
        create = (Button) v.findViewById(R.id.btnCreate);
        pw1 = (EditText) v.findViewById(R.id.etPassword);
        pw2 = (EditText) v.findViewById(R.id.etPassword2);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NikCheckFragment nikCheckFragment = new NikCheckFragment();
                String nikStr = nikCheckFragment.nik.getText().toString();
                String pwStr = pw1.getText().toString();
                ref.push().child("RegisteredUser").setValue(new Register(nikStr, pwStr, "0"));
            }
        });
        return v;
    }

    public static class Register{
        String nik, pass, vote;

        public Register(String nik, String pass, String vote) {
            this.nik = nik;
            this.pass = pass;
            this.vote = vote;
        }
    }
}
