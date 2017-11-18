package com.project.kuyk.yukmemilih.Register;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.project.kuyk.yukmemilih.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NidCheckFragment extends Fragment {
    Button check;
    EditText nik;

    public NidCheckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_nid_check, container, false);
        check = (Button) v.findViewById(R.id.btnCheck);
        nik = (EditText) v.findViewById(R.id.etNik);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                PwInsertFragment fragmentHome = new PwInsertFragment();
                transaction.replace(R.id.frame_content, fragmentHome);
                transaction.commit();
            }
        });

        return v;
    }
}
