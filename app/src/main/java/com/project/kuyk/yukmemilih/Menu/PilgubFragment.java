package com.project.kuyk.yukmemilih.Menu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.project.kuyk.yukmemilih.MainActivity;
import com.project.kuyk.yukmemilih.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PilgubFragment extends Fragment {
    Button vote1, vote2;
    TextView calon1, calon2;

    public PilgubFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pilgub, container, false);
        vote1 = (Button) v.findViewById(R.id.btn_vote1pg);
        calon1 = (TextView) v.findViewById(R.id.calon1pg);
        vote2 = (Button) v.findViewById(R.id.btn_vote2pg);
        calon2 = (TextView) v.findViewById(R.id.calon2pg);

        vote1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Anda telah memilih " + calon1.getText(), Toast.LENGTH_SHORT).show();
                exit();
            }
        });

        vote2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Anda telah memilih " + calon2.getText(), Toast.LENGTH_SHORT).show();
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
}
