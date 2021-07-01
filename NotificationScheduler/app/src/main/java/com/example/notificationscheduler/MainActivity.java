package com.example.notificationscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private JobScheduler mScheduler;
    private static final int JOB_ID = 0;
    private Switch mDeviceIdleSwitch;
    private Switch getmDeviceChargingSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDeviceIdleSwitch = findViewById(R.id.idleSwitch);
        getmDeviceChargingSwitch= findViewById(R.id.chargingSwitch);
    }

    public void scheduleJob(View view) {
        mScheduler = (JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
        RadioGroup networkOptions = findViewById(R.id.networkOptions);
        int selectedNetworkID = networkOptions.getCheckedRadioButtonId();
        int selectedNetworkOption = JobInfo.NETWORK_TYPE_NONE;
        switch (selectedNetworkID){
            case R.id.noNetwork:
                selectedNetworkOption = JobInfo.NETWORK_TYPE_NONE;
                break;
            case R.id.anyNetwork:
                selectedNetworkOption = JobInfo.NETWORK_TYPE_ANY;
                break;
            case R.id.wifiNetwork:
                selectedNetworkOption = JobInfo.NETWORK_TYPE_UNMETERED;
                break;
        }
        ComponentName serviceName = new ComponentName(getPackageName(),
                NotificationJobService.class.getName());
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID,serviceName)
                .setRequiredNetworkType(selectedNetworkOption)
                .setRequiresDeviceIdle(mDeviceIdleSwitch.isChecked())
                .setRequiresCharging(getmDeviceChargingSwitch.isChecked());


        boolean constarintSet = selectedNetworkOption != JobInfo.NETWORK_TYPE_NONE || getmDeviceChargingSwitch.isChecked() || mDeviceIdleSwitch.isChecked();
        if(constarintSet){
            JobInfo myJobInfo  = builder.build();
            mScheduler.schedule(myJobInfo);
            Toast.makeText(this, "Jobs scheduled", Toast.LENGTH_SHORT).show();

        }else {


            Toast.makeText(this, "Set one constraint", Toast.LENGTH_SHORT).show();
        }

    }

    public void cancelJobs(View view) {
        if(mScheduler!=null){
            mScheduler.cancelAll();
            mScheduler=null;
            Toast.makeText(this,"Jobs are cancelled",Toast.LENGTH_SHORT).show();
        }

    }
}