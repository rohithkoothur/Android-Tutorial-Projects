package com.example.droidcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);



    }


    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

    }
    public void onRadioClcked(View view) {
        boolean checked =((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.samedy:
                if(checked)
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if(checked)
                    displayToast(getString(R.string.next_day_service));
                break;
            case R.id.pickup:
                if (checked)
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                break;






        }





    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_order :
                displayToast(getString(R.string.order));
                return true;
            case R.id.action_status :
                displayToast(getString(R.string.status));
                return true;
            case R.id.action_fav :
                displayToast(getString(R.string.favorite));
                return true;



            return super.onOptionsItemSelected(item);

        }
}