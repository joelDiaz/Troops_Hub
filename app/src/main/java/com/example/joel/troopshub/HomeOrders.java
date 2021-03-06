package com.example.joel.troopshub;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeOrders extends AppCompatActivity {

    DrawerLayout drawerLayout;
    FloatingActionButton floatbutton;
    NavigationView navView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeorders);
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.navview);
        floatbutton = (FloatingActionButton)findViewById(R.id.fab);


        floatbutton.setOnClickListener(new View.OnClickListener() {

            boolean fragmentTransaction = false;
            Fragment fragment = null;

            @Override
            public void onClick(View v) {
                fragment = new Categories();
                fragmentTransaction = true;
            }
        });


        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.Home:
                        fragment = new HomeFragment();
                        fragmentTransaction = true;
                        break;

                    case R.id.Profile:
                        fragment = new Profile();
                        fragmentTransaction = true;
                        break;
                    case R.id.Support:
                        fragment = new Support();
                        fragmentTransaction = true;
                        break;
                    case R.id.AboutUs:
                        fragment = new AboutUs();
                        fragmentTransaction = true;
                        break;



                }


                if (fragmentTransaction) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, fragment)
                            .commit();

                    item.setChecked(true);
                    getSupportActionBar().setTitle(item.getTitle());


                }

                drawerLayout.closeDrawers();

                return false;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            //...
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_navview, menu);
        return true;
    }


}
