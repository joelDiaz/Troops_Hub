package com.example.joel.troopshub;

import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class singup extends AppCompatActivity {
    TextView next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
       int a = getSupportFragmentManager().beginTransaction().replace(R.id.relativefra, new singup1()).commitAllowingStateLoss();
        Log.e("tuu", String.valueOf(a));

        next = (TextView)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int b =getSupportFragmentManager().beginTransaction().replace(R.id.relativefra, new singup3()).commitAllowingStateLoss();
                Log.e("tuu2", String.valueOf(b));
            }
        });
    }
}
