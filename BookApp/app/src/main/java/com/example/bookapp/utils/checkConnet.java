package com.example.bookapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class checkConnet {
    public static boolean haveNetworkConnection(Context context){
        boolean haveConnectedWifi = false;
        boolean haveConnectMobile = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo){
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.isConnected())
                if (ni.isConnected())
                    haveConnectMobile = true;
        }

        return haveConnectedWifi || haveConnectMobile;
    }

    public static void showToast_Short(Context context, String thongbao){
        Toast.makeText(context, "thongbao", Toast.LENGTH_SHORT).show();
    }
}
