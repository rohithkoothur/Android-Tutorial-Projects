package com.example.simpleasyncapp;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask <Void, Void, String> {

WeakReference<TextView> mTextview;

    @Override
    protected void onPostExecute(String s) {
        mTextview.get().setText(s);
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random r =new Random();
        int n= r.nextInt(11);
        int s = n * 200;

        try{
            Thread.sleep(s);

        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return "Awake at last after sleeping for " + s + "milliseconds";
    }
    SimpleAsyncTask(TextView tv){
        mTextview = new WeakReference<>(tv);
    }
}
