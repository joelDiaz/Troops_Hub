package com.example.joel.troopshub;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by AndroidDeveloper01 on 30/6/16.
 */
public class DishesDetail extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dishesdetail, container, false);
        return v;
    }
}
