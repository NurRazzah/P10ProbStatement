package com.example.a16022738.p10probstatement;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;
    Button btnRead;

    int req = 12345;
    int notiID=888;
    Menu next;

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
                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.SECOND, 5);

                    Intent intent = new Intent(MainActivity.this,
                            Notification.class);

                    PendingIntent pendingIntent = PendingIntent.getBroadcast(
                            MainActivity.this, req,
                            intent, PendingIntent.FLAG_CANCEL_CURRENT);

                    AlarmManager am = (AlarmManager)
                            getSystemService(Activity.ALARM_SERVICE);
                    am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                            pendingIntent);

            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_previous:
                if (vPager.getCurrentItem() > 0) {
                    int previousPage = vPager.getCurrentItem() - 1;
                    vPager.setCurrentItem(previousPage, true);
                }
                return true;
            case R.id.action_Random:
                int randInt = new Random().nextInt(vPager.getChildCount());
                vPager.setCurrentItem(randInt, true);
                return true;
            case R.id.action_Next:
                int max = vPager.getChildCount();
                if (vPager.getCurrentItem() < max - 1) {
                    int nextPage = vPager.getCurrentItem() + 1;
                    vPager.setCurrentItem(nextPage, true);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
