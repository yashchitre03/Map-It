package com.example.project1_yash_chitre;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // take input in editAddress
        final EditText editAddress = findViewById(R.id.address_input);
        editAddress.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            // When soft-key enter is pressed, execute the following:
            public boolean onEditorAction(TextView view, int i, KeyEvent event) {
                String string_address = editAddress.getText().toString();

                Intent returnIntent = new Intent();

                if (string_address.matches("")){
                    setResult(MainActivity.RESULT_CANCELED, returnIntent);
                    finish();
                }
                else {
                    returnIntent.putExtra("address", string_address);
                    setResult(MainActivity.RESULT_OK, returnIntent);
                    finish();
                }
            return false;
            }
        });
    }
}
