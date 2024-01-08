package com.example.lasthope;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Homefragment extends Fragment {
    int i = 0;
    int j = 0;
    Context context;
    public Homefragment() {
    }
    ProgressBar consBar;
    TextView consPerc;
    ProgressBar payBar;
    TextView payPerc;
    Handler handler = new Handler();
    User user;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        DBHelper helper = new DBHelper(context);
        user = helper.getUser();
        user.setProgress(60);
        user.setRest(30);
        user.setPaied(70);
        View view = inflater.inflate(R.layout.home_page_fragment,container,false);
        consBar = view.findViewById(R.id.constructionProgressbar);
        consPerc = view.findViewById(R.id.constructionPercentage);
        payBar = view.findViewById(R.id.paymentProgressbar);
        payPerc = view.findViewById(R.id.paymentPercentage);




        TextView detailsPayment = view.findViewById(R.id.moreDetailsPayment);
        detailsPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PaymentTracking.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context =context;
    }

    @Override
    public void onResume() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                i = 0;
                while(i <= user.getpayPerc()){
                    handler.post(() -> payBar.setProgress(i));
                    handler.post(() -> payPerc.setText(String.valueOf(i)));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                j = 0;
                while(j <= user.getProgress()){
                    handler.post(() -> consBar.setProgress(j));
                    handler.post(() -> consPerc.setText(String.valueOf(j)));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    j++;
                }

            }
        }).start();


        super.onResume();
    }
}
