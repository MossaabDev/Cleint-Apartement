package com.example.lasthope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPagerAdapter adapter;
    Homefragment homefragment;
    ViewPager viewPager;
    BottomNavigationView bott;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        this.setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Realistate");
        List fragments = new ArrayList<>();
        bott = findViewById(R.id.bottom_nav);
        fragments.add(new ProfileFragment());
        fragments.add(new Homefragment());
        fragments.add(new FeedBackFragment());

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viwePager);
        adapter.setPages(fragments);
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        viewPager.setCurrentItem(1);
        bott.setSelectedItemId(R.id.navhome);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bott.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bott.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_profile:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.navhome:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.navfeedback:
                        viewPager.setCurrentItem(2);
                        break;
                    default:
                        break;
                }

                return true;
            }
        });


    }
}