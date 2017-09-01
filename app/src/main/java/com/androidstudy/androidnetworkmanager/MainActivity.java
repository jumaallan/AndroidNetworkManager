package com.androidstudy.androidnetworkmanager;

import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidstudy.androidnetworkmanager.databinding.ActivityMainBinding;
import com.androidstudy.networkmanager.Monitor;
import com.androidstudy.networkmanager.Tovuti;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Tovuti tovuti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        tovuti = Tovuti.from(this)
                .monitor(new Monitor.ConnectivityListener() {
                    @Override
                    public void onConnectivityChanged(int connectionType, boolean isConnected, boolean isFast) {

                        String type, speed;
                        if (isConnected) {
                            switch (connectionType) {
                                case -1:
                                    type = "Any";
                                    break;
                                case ConnectivityManager.TYPE_WIFI:
                                    type = "Wifi";
                                    break;
                                case ConnectivityManager.TYPE_MOBILE:
                                    type = "Mobile";
                                    break;
                                default:
                                    type = "Unknown";
                                    break;
                            }

                            if (isFast)
                                speed = "Fast";
                            else if (type.equals("Unknown"))
                                speed = "N/A";
                            else
                                speed = "Slow";
                        } else {
                            type = "None";
                            speed = "N/A";
                        }

                        binding.connectionStatus.setText(String.format(Locale.getDefault(), getString(R.string.connection_status), type));
                        binding.connectionFast.setText(String.format(Locale.getDefault(), getString(R.string.connection_speed), speed));
                    }
                });
    }

    @Override
    protected void onStop() {
        super.onStop();
        tovuti.stop();
    }
}
