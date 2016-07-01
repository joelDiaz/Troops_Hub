package com.example.joel.troopshub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by AndriodDeveloper02 on 30/6/16.
 */
public class singup1 extends Fragment {


//    public static singup1 newInstance(int page, String title) {
//        singup1 fragmentFirst = new singup1();
//        Bundle args = new Bundle();
//        args.putInt("someInt", page);
//        args.putString("someTitle", title);
//        fragmentFirst.setArguments(args);
//        return fragmentFirst;
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_singup1, container, false);

        // Inflate the layout for this fragment
        // String latitude =  getArguments().getString("hola");

//        String someTitle = getArguments().getString("hola", "");
//        pru = (TextView)dd.findViewById(R.id.prueba12);
//        pru.setText(someTitle);

        return view;


    }

}
