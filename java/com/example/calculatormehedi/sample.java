package com.example.calculatormehedi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sample extends AppCompatActivity {

    private Button sin_bt, cos_bt, tan_bt, sqrt_bt, log_bt;
    private TextView result1_tv;
    private EditText num11_et;

    double result1;
    int num11;

    DatabaseReference ref;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        sin_bt = findViewById(R.id.sin_bt);
        cos_bt = findViewById(R.id.cos_bt);
        tan_bt = findViewById(R.id.tan_bt);
        sqrt_bt = findViewById(R.id.sqrt_bt);
        log_bt = findViewById(R.id.log_bt);

        result1_tv = findViewById(R.id.result1_tv);
        num11_et = findViewById(R.id.num11_et);

        ref = FirebaseDatabase.getInstance().getReference().child("Member");
        member = new Member();


        sin_bt.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String snum1;
                snum1 = num11_et.getText().toString();


                if (snum1.isEmpty()) {
                    Toast.makeText(sample.this, "Please,Enter the number", Toast.LENGTH_SHORT).show();
                    return;
                }

                num11 = Integer.parseInt(snum1);

                result1 = Math.sin(Math.toRadians(num11));
                result1_tv.setText(String.valueOf(result1));
                member.setValue("sin(" + num11 + ")=" + result1);
                ref.push().setValue(member);

            }
        });

        cos_bt.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String snum1;
                snum1 = num11_et.getText().toString();


                if (snum1.isEmpty()) {
                    Toast.makeText(sample.this, "Please,Enter the number", Toast.LENGTH_SHORT).show();
                    return;
                }

                num11 = Integer.parseInt(snum1);

                result1 = Math.cos(Math.toRadians(num11));
                result1_tv.setText(String.valueOf(result1));
                member.setValue("cos(" + num11 + ")=" + result1);
                ref.push().setValue(member);

            }
        });

        tan_bt.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String snum1;
                snum1 = num11_et.getText().toString();


                if (snum1.isEmpty()) {
                    Toast.makeText(sample.this, "Please,Enter the number", Toast.LENGTH_SHORT).show();
                    return;
                }

                num11 = Integer.parseInt(snum1);

                result1 = Math.tan(Math.toRadians(num11));
                result1_tv.setText(String.valueOf(result1));
                member.setValue("tan(" + num11 + ")=" + result1);
                ref.push().setValue(member);

            }
        });

        sqrt_bt.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String snum1;
                snum1 = num11_et.getText().toString();


                if (snum1.isEmpty()) {
                    Toast.makeText(sample.this, "Please,Enter the number", Toast.LENGTH_SHORT).show();
                    return;
                }

                num11 = Integer.parseInt(snum1);

                result1 = Math.sqrt(num11);
                result1_tv.setText(String.valueOf(result1));
                member.setValue("sqrt(" + num11 + ")=" + result1);
                ref.push().setValue(member);

            }
        });

        log_bt.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String snum1;
                snum1 = num11_et.getText().toString();


                if (snum1.isEmpty()) {
                    Toast.makeText(sample.this, "Please,Enter the number", Toast.LENGTH_SHORT).show();
                    return;
                }

                num11 = Integer.parseInt(snum1);

                result1 = Math.log(num11);
                result1_tv.setText(String.valueOf(result1));
                member.setValue("log(" + num11 + ")=" + result1);
                ref.push().setValue(member);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.n_cal:
                open_activity();
                return true;
            case R.id.s_cal:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void open_activity() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
