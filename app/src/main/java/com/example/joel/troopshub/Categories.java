package com.example.joel.troopshub;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by AndroidDeveloper01 on 29/6/16.
 */
public class Categories extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.categories,container,false);

        Toolbar toolbar = (Toolbar)v.findViewById(R.id.appbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar( toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        return v;
    }
}
