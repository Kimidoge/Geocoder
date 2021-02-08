package com.example.geocoder;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Geocoder geocoder;
    TextView textView;
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button= findViewById(R.id.button);
        editText = findViewById(R.id.locationName);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result=null;
                geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                try {
                    List<Address> addresses = geocoder.getFromLocationName(editText.getText().toString(), 1);
                    result = addresses.get(0).getAddressLine(0);
                    textView.setText(result);

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}