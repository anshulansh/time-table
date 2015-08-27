package com.example.mayank.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.astuetz.PagerSlidingTabStrip;


public class MainActivity extends FragmentActivity {

    private static final int num_pages = 6;

    private ViewPager viewPager;

    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page);

        viewPager = (ViewPager)findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        //viewPager.setAdapter(new TestAdapter(getSupportFragmentManager()));
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);



        Button button = (Button)findViewById(R.id.button_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });


        Button button_back = (Button)findViewById(R.id.button_previous);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });

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
                    return new BlankFragment("MONDAY");
                case 1:
                    return new BlankFragment("TUESDAY");
                case 2:
                    return new BlankFragment("WEDNESDAY");
                case 3:
                    return new BlankFragment("THURSDAY");
                case 4:
                    return new BlankFragment("FRIDAY");
                case 5:
                    return new BlankFragment("SATURDAY");
                default:
                    return null;
            }
        }

        public int getCount() {
            return num_pages;
        }
    }

}
