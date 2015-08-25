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

        public Fragment getItem(int position) {
            switch (position)
            {
                case 0 :
                    return new BlankFragment("Monday");
                case 1:
                    return new BlankFragment("Tuesday");
                case 2:
                    return new BlankFragment("Wednesday");
                case 3:
                    return new BlankFragment("Thursday");
                case 4:
                    return new BlankFragment("Friday");
                case 5:
                    return new BlankFragment("Saturday");
                default:
                    return null;
            }
        }

        public int getCount() {
            return num_pages;
        }
    }

}
