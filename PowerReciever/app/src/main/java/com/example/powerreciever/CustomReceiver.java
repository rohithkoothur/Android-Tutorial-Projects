package com.example.powerreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID+".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {


        String intentAction = intent.getAction();

        if(intentAction != null){
            String toastMessage = "Unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage="Power connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Powerr disconnected";
                    break;
                case Intent.ACTION_CUSTOM_BROADCAST:
                    toastMessage = "Custom Broadcast message recieved";
                    break;
            }
            Toast.makeText(context,toastMessage,Toast.LENGTH_SHORT).show();
        }




    }
}