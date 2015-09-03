package com.example.mayank.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.astuetz.PagerSlidingTabStrip;


public class MainActivity extends AppCompatActivity {
    NotificationManager nm;
    Notification notify;

    private static final int num_pages = 6;

    private ViewPager viewPager;

    private PagerAdapter pagerAdapter;
    private Button last;
    private Button first;
    private ActionBar actionBar;
    /*private float x1;
    private float x2;
    private float MIN_DISTANCE = 10;*/

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.indigo)));
            actionBar.setElevation(0);
        }
         nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notify=new Notification(R.drawable.notification_template_icon_bg,"Meeting",System.currentTimeMillis());
        notify.defaults |=Notification.DEFAULT_SOUND;
        notify.defaults |=Notification.FLAG_AUTO_CANCEL;
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),2,i,0);
        notify.setLatestEventInfo(getApplicationContext(),"Description","Meeting at 4pm",pi);

        viewPager = (ViewPager)findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        //viewPager.setAdapter(new TestAdapter(getSupportFragmentManager()));
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);





        last = (Button)findViewById(R.id.button_last);
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(5);
            }
        });


        first = (Button)findViewById(R.id.button_first);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });


        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                if(position==0)
                    first.setVisibility(View.GONE);
                else
                    first.setVisibility(View.VISIBLE);

                if(position==5)
                    last.setVisibility(View.GONE);
                else
                    last.setVisibility(View.VISIBLE);

            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });


    }
    public void showme(View V)

    {
        nm.notify(3,notify);
    }





    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public  CharSequence getPageTitle(int position) {
            final String[]TITLES={"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
            return TITLES[position];

        }

        public Fragment getItem(int position) {
            switch (position)
            {
                case 0 :

                    return new UniversalFragment("MONDAY");

                case 1:
                    return new UniversalFragment("TUESDAY");
                case 2:
                    return new UniversalFragment("WEDNESDAY");
                case 3:
                    return new UniversalFragment("THURSDAY");
                case 4:
                    return new UniversalFragment("FRIDAY");
                case 5:
                    return new UniversalFragment("SATURDAY");
                default:
                    return null;
            }
        }

        public int getCount() {
            return num_pages;
        }
    }
   /* @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                if(!actionBar.isShowing()){
                    actionBar.show();
                }
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;
                if (Math.abs(deltaX) > MIN_DISTANCE)
                {
                    actionBar.hide();
                }
                else
                {
                    // consider as something else - a screen tap for example
                }
                break;
        }
        return super.onTouchEvent(event);
    }*/

}
