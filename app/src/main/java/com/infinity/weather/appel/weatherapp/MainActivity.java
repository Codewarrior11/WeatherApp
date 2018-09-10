package com.infinity.weather.appel.weatherapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViewPager();
    }

    private void setupViewPager() {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new CurrentWeatherFragment());
        adapter.addFragment(new ForecastWeatherFragment());

        ViewPager vp=findViewById(R.id.viewPager);
        vp.setAdapter(adapter);

        TabLayout tabLayout=findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(vp);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        tabLayout.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.black));

        tabLayout.getTabAt(0).setText("Current weather");
        tabLayout.getTabAt(1).setText("5 Days Forecast");


    }

    class SectionPageAdapter extends FragmentPagerAdapter {
        private final java.util.List<Fragment> fragmentList = new ArrayList<>();

        public SectionPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            fragmentList.add(fragment);
        }
    }

}
