package com.project.kuyk.yukmemilih.Register;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.kuyk.yukmemilih.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NidCheckFragment extends Fragment {
    Button check;


    public NidCheckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_nid_check, container, false);
        return v;
    }
}
