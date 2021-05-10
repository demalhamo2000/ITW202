package edu.gcit.lab15i;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.fragment1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.fragment2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.fragment3));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //to link the view pager
        ViewPager viewPager = findViewById(R.id.viewpager);
        PagerAdaptor adaptor = new PagerAdaptor(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adaptor);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}