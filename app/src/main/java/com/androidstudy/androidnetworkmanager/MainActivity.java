package com.androidstudy.androidnetworkmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.androidstudy.networkmanager.NetworkManager;

public class MainActivity extends AppCompatActivity {
    private static TextView internetStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        internetStatus = (TextView) findViewById(R.id.internet_status);

        if (NetworkManager.getInstance(getApplicationContext()).isOnline()) {
            //There is Internet connection
            Toast.makeText(this, "Internet Connected", Toast.LENGTH_SHORT).show();
        }else {
            //There is NO Internet connection
            Toast.makeText(this, "Not Internet Connection", Toast.LENGTH_SHORT).show();
        }

    }

}
