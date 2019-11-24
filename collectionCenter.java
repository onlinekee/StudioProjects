package com.example.hp.ktsmilkapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class collectionCenter extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    private FloatingActionButton floatbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_center);

        tabLayout = (TabLayout)findViewById(R.id.tablayout_id);
        viewPager = (ViewPager)findViewById(R.id.ViewPager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        floatbutton =(FloatingActionButton) findViewById(R.id.floatingActionButton);

        floatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(collectionCenter.this,collection_center_insert.class);
                startActivity(intent);
            }
        });

        //add fragment here
        adapter.AddFragment(new FragmentCollection(),"Collection Center");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.iconcollection);
    }
}
