package com.example.a16022738.p10probstatement;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {
    Button buttonChange;

    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View vv = inflater.inflate(R.layout.fragment_2, container, false);



        buttonChange= (Button) vv.findViewById(R.id.btnChange);
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();

                vv.setBackgroundColor(Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256)));

            }
        });
        return  vv;
    }

}
