package com.example.respro2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class rest_menu extends AppCompatActivity {
    reviewAdapter pagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    ArrayList<String> mobileArray = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_menu);
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        Intent intent = getIntent();
        String message = intent.getStringExtra(RestAdapter.EXTRA_MESSAGE).toString();
        String message1 = intent.getStringExtra(RestAdapter.EXTRA_MESSAGE1).toString();
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.restName);
        textView.setText(message);
        TextView textView1 = findViewById(R.id.rating);
        textView1.setText("4");
        setPagerAdapter();
        setTabLayout();
        EditText ed = (EditText) findViewById(R.id.editTextTextPersonName);
        Button b = (Button) findViewById(R.id.button);


    }

    private void setPagerAdapter(){
        pagerAdapter = new reviewAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }
    private void setTabLayout() {
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Restaurant Review");
        tabLayout.getTabAt(1).setText("Food Recipe Review");
    }
    }
