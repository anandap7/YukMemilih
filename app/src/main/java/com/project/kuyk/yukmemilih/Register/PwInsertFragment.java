package com.project.kuyk.yukmemilih.Register;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.kuyk.yukmemilih.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PwInsertFragment extends Fragment {
    EditText pw1, pw2;
    Button create;

    public PwInsertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pw_insert, container, false);
        create = (Button) v.findViewById(R.id.btnCreate);
        pw1 = (EditText) v.findViewById(R.id.etPassword);
        pw2 = (EditText) v.findViewById(R.id.etPassword2);
        return v;
    }

}
