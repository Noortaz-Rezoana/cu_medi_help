package com.example.smart.bug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class city extends AppCompatActivity {

    private Button dhaka, chittagong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        dhaka = (Button) findViewById(R.id.B_D);
        chittagong =  (Button) findViewById(R.id.B_C);

        dhaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(city.this,dhaka.class);
                startActivity(intent);
            }
        });

        chittagong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(city.this,chittagong.class);
                startActivity(intent);
            }
        });
    }
}
