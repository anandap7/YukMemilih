package com.project.kuyk.yukmemilih.Register;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.kuyk.yukmemilih.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NikCheckFragment extends Fragment {
    Button check;
    EditText nik;


    public NikCheckFragment() {
        // Required empty public constructor
    }

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference().child("userEktp");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Firebase.setAndroidContext(getContext());
        View v = inflater.inflate(R.layout.fragment_nik_check, container, false);
        check = (Button) v.findViewById(R.id.btnCheck);
        nik = (EditText) v.findViewById(R.id.etNik);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ref.addValueEventListener(new ValueEventListener() {
                    boolean found = false;

                    @Override
                    public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                        for (com.google.firebase.database.DataSnapshot data : dataSnapshot.getChildren()) {
                            if (data.child("NIK").getValue().toString().equals(nik.getText().toString())) {
                                found = true;
                                Toast.makeText(getContext(), "NIK ditemukan", Toast.LENGTH_SHORT).show();
                                goToNextFragment();
                            }
                        }
                        if (!found)
                            Toast.makeText(getContext(), "NIK tidak ditemukan", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });
        return v;
    }

    public void goToNextFragment(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        PwInsertFragment fragmentHome = new PwInsertFragment();
        transaction.replace(R.id.frame_content, fragmentHome);
        transaction.commit();
    }
}
