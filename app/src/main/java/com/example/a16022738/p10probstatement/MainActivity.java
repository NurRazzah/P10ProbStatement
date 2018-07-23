package com.example.a16022738.p10probstatement;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;
    Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager=(ViewPager)findViewById(R.id.viewpager1);

        FragmentManager fm = getSupportFragmentManager();

        al=new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag2());
        al.add(new Frag3());
        adapter=new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);
        btnRead=(Button)findViewById(R.id.btnRead);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                


            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
