package com.example.project1_yash_chitre;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String result;
    int flag = 0;   // Set flag to disable map button if address string is empty

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // "Address" button to launch new activity
    public void clickAddress(View view)
    {
        Intent i = new Intent(this, Activity_2.class);
        startActivityForResult(i, 13);
    }

    // Get address string from second activity and store it in a variable
    // Also, check the request code and result code
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 13) {
            if(resultCode == Activity_2.RESULT_OK){
                result = data.getStringExtra("address");
                flag = 1;
            }
            else if (resultCode == Activity_2.RESULT_CANCELED) {
                flag = 0;
            }
        }
        else {
            Toast.makeText(this, "System error! Did not receive request code", Toast.LENGTH_LONG).show();
            flag = 0;
        }
    }

    // "Map" button to launch Google Maps
    public void clickMap(View view)
    {
        if (flag == 1) {
        Uri map = Uri.parse("geo:0,0?q=" + result);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, map);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
    else {
            Toast.makeText(getApplicationContext(),"Please enter an address first!", Toast.LENGTH_SHORT).show();
        }
    }
}
