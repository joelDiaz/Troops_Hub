package com.example.joel.troopshub;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by AndroidDeveloper01 on 29/6/16.
 */
public class Support extends Fragment {
    public Support(){}


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.support,container,false);
        return  v;
    }
}
