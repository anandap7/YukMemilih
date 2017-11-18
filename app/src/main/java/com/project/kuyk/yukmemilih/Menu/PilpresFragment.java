package com.project.kuyk.yukmemilih.Menu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.project.kuyk.yukmemilih.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PilpresFragment extends Fragment {
    Button vote1, vote2;
    TextView calon1, calon2;

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

        vote1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Anda telah memilih " + calon1.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        vote2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Anda telah memilih " + calon2.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

}
