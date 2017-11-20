package com.project.kuyk.yukmemilih.Menu;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.kuyk.yukmemilih.MainActivity;
import com.project.kuyk.yukmemilih.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PilpresFragment extends Fragment implements ValueEventListener{
    Button vote1, vote2;
    TextView calon1, calon2;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference().child("CalonPresiden");
    DataSnapshot dataSnapshot;

    public PilpresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pilpres, container, false);
        vote1 = (Button) v.findViewById(R.id.btn_vote1pp);
        calon1 = (TextView) v.findViewById(R.id.calon1pp);
        vote2 = (Button) v.findViewById(R.id.btn_vote2pp);
        calon2 = (TextView) v.findViewById(R.id.calon2pp);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                calon1.setText(dataSnapshot.child("Calon1").child("Nama").getValue().toString());
                calon2.setText(dataSnapshot.child("Calon2").child("Nama").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        vote1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Anda telah memilih " + calon1.getText(), Toast.LENGTH_SHORT).show();
                ref.addValueEventListener(new ValueEventListener() {
                    boolean vote = false;
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(!vote) {
                            vote = true;
                            int value = Integer.parseInt(dataSnapshot.child("Calon1").child("Suara").getValue().toString()) + 1;
                            ref.child("Calon1").child("Suara").setValue(value);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                exit();
            }
        });

        vote2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Anda telah memilih " + calon2.getText(), Toast.LENGTH_SHORT).show();
                ref.addValueEventListener(new ValueEventListener() {
                    boolean vote = false;
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(!vote) {
                            vote = true;
                            int value = Integer.parseInt(dataSnapshot.child("Calon2").child("Suara").getValue().toString()) + 1;
                            ref.child("Calon2").child("Suara").setValue(value);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                exit();
            }
        });
        return v;
    }

    public void exit(){
        Intent i = new Intent(getActivity(), MainActivity.class);
        startActivity(i);
        getActivity().finish();
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
