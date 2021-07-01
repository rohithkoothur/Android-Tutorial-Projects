package com.example.notificationscheduler;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class NotificationJobService extends JobService {
    NotificationManager mNotifymanager;
    private static final String PRIMARY_CHANNEL_ID="primary_notification_channel";
    @Override
    public boolean onStartJob(JobParameters params) {
        createNotificationChannel();
        PendingIntent contentPendingIntent = PendingIntent.getActivity(this,0,
                new Intent(this,MainActivity.class),PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,PRIMARY_CHANNEL_ID)
                .setContentTitle("JOB SERVICE")
                .setContentText("Your Job ran to completion")
                .setContentIntent(contentPendingIntent)
                .setSmallIcon(R.drawable.ic_notification)
                .setPriority(NotificationCompat.PRIORITY_HIGH)

                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);
        mNotifymanager.notify(0,builder.build());
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
    public void createNotificationChannel(){
        mNotifymanager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID, "Job Service Notificaiton",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from job Scheduler");

            mNotifymanager.createNotificationChannel(notificationChannel);
        }
        }
    }


