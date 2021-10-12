package com.example.sit_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar_loan, seekBar_interest, seekBar_tenure;
    EditText loan_amount, interest_rate, loan_tenure;
    Button cal;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar_interest = findViewById(R.id.seekBar_interest);
        seekBar_loan = findViewById(R.id.seekBar_loan);
        seekBar_tenure = findViewById(R.id.seekBar_tenure);
        loan_amount = findViewById(R.id.loan_amount);
        interest_rate = findViewById(R.id.interest_rate);
        loan_tenure = findViewById(R.id.loan_tenure);
        cal = findViewById(R.id.cal);
        res = findViewById(R.id.res);

        seekBar_loan.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                loan_amount.setText(String.valueOf(i)+"00000");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBar_interest.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                interest_rate.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBar_tenure.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                loan_tenure.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        cal.setOnClickListener(view -> {
            double principal_amount = Double.parseDouble(loan_amount.getText().toString());
            double rate_of_interest = Double.parseDouble(interest_rate.getText().toString());
            double tenure = Double.parseDouble(loan_tenure.getText().toString());

            rate_of_interest = rate_of_interest / 1200;
            tenure = tenure * 12;

            int emi= (int) ((principal_amount*rate_of_interest*Math.pow(1+rate_of_interest,tenure))/(Math.pow(1+rate_of_interest,tenure)-1));
            res.setText("EMI: " + String.valueOf(emi));
        });

    }
}