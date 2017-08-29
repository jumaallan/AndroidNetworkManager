package com.androidstudy.androidnetworkmanager;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.androidstudy.androidnetworkmanager.databinding.ActivityMainBinding;
import com.androidstudy.networkmanager.NetworkManager;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        refreshNetworkStatus();
        binding.buttonRefreshStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.refreshNetworkStatus();
            }
        });
    }

    private void refreshNetworkStatus() {
        if (NetworkManager.isConnected(this)) {
            //There is Internet connection
            String type, speed;

            if (NetworkManager.isConnectedToWifi(this)) {
                type = "Wifi";
                speed = "Fast";
            } else if (NetworkManager.isConnectedToMobile(this)) {
                type = "Mobile";
                if (NetworkManager.isConnectionFast(this))
                    speed = "Fast";
                else
                    speed = "Slow";
            } else {
                type = "Unknown";
                speed = "N/A";
            }

            binding.connectionStatus.setText(String.format(Locale.getDefault(), getString(R.string.connection_status), type));
            binding.connectionFast.setText(String.format(Locale.getDefault(), getString(R.string.connection_speed), speed));
            Toast.makeText(this, "Internet Connected", Toast.LENGTH_SHORT).show();
        } else {
            //There is NO Internet connection
            binding.connectionStatus.setText(String.format(Locale.getDefault(), getString(R.string.connection_status), "None"));
            binding.connectionFast.setText(String.format(Locale.getDefault(), getString(R.string.connection_speed), "N/A"));
            Toast.makeText(this, "Not Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
}
