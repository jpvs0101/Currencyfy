package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.currencyfy.R;
import com.jpvs0101.currencyfy.Currencyfy;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText tvSamples = findViewById(R.id.etSamples);


        String samples = "";
        samples += "currencyfy (500000.78) ->" + Currencyfy.currencyfy(500000.78) + "\n";
        samples += "currencyfy (500000.78, false) ->" + Currencyfy.currencyfy(500000.78, false) + "\n";
        samples += "currencyfy (500000.78, false, false) ->" + Currencyfy.currencyfy(500000.78, false, false) + "\n";

        samples += "\ncurrencyfy (new Locale(\"en\", \"in\"), 500000.78) \n->" + Currencyfy.currencyfy(new Locale("en", "in"), 500000.78) + "\n";
        tvSamples.setText(samples);

    }
}
