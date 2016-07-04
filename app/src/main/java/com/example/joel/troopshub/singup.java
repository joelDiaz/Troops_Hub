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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;


public class singup extends AppCompatActivity {
    TextView next,back;
    ImageView cir1,cir2,cir3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        getSupportFragmentManager().beginTransaction().replace(R.id.relativefra, new singup1()).commitAllowingStateLoss();
        final int[] cont = {1};
        cir1 = (ImageView)findViewById(R.id.cir1);
        cir2 = (ImageView)findViewById(R.id.cir2);
        cir3 = (ImageView)findViewById(R.id.cir3);
        next = (TextView)findViewById(R.id.next);
        back = (TextView)findViewById(R.id.back);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cont[0] == 1){
                getSupportFragmentManager().beginTransaction().replace(R.id.relativefra, new singup2()).commitAllowingStateLoss();
                    cir1.setImageDrawable(getResources().getDrawable(R.drawable.circlevacio));
                    cir2.setImageDrawable(getResources().getDrawable(R.drawable.circelfull));
                    cont[0] = cont[0] + 1;
                }else if (cont[0] == 2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.relativefra, new singup3()).commitAllowingStateLoss();
                    next.setText(getResources().getString(R.string.submit));
                    cir1.setImageDrawable(getResources().getDrawable(R.drawable.circlevacio));
                    cir2.setImageDrawable(getResources().getDrawable(R.drawable.circlevacio));
                    cir3.setImageDrawable(getResources().getDrawable(R.drawable.circelfull));
                }else{

                    //codigo para enviar alsu
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cont[0] == 2) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.relativefra, new singup2()).commitAllowingStateLoss();
                    next.setText(getResources().getString(R.string.next));
                    cir1.setImageDrawable(getResources().getDrawable(R.drawable.circlevacio));
                    cir2.setImageDrawable(getResources().getDrawable(R.drawable.circelfull));
                    cir3.setImageDrawable(getResources().getDrawable(R.drawable.circlevacio));
                    cont[0] = cont[0] - 1;
                    Log.e("conta", Arrays.toString(cont));
                }else if (cont[0] == 1){
                    cir1.setImageDrawable(getResources().getDrawable(R.drawable.circelfull));
                    cir2.setImageDrawable(getResources().getDrawable(R.drawable.circlevacio));
                    cir3.setImageDrawable(getResources().getDrawable(R.drawable.circlevacio));
                    getSupportFragmentManager().beginTransaction().replace(R.id.relativefra, new singup1()).commitAllowingStateLoss();
                }
            }
        });
    }
}
