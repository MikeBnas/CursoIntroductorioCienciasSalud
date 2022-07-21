package com.wordpress.medicourses.cursointroductoriocienciassalud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quimica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quimica);

        Button button = findViewById(R.id.buttonquim);
        Button buttontab = findViewById(R.id.buttontab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quimica.this, PDFActivity.class);
                intent.putExtra("param", "qpu.pdf");
                startActivity(intent);
            }
        });


        buttontab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quimica.this, PDFActivity.class);
                intent.putExtra("param", "teq.pdf");
                startActivity(intent);
            }
        });


        TextView sectionquim = findViewById(R.id.sectionquim);
        sectionquim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView secView = findViewById(R.id.sectionquimcont);
                if(secView.getVisibility() == View.VISIBLE){
                    secView.setVisibility(View.GONE);
                }else{
                    secView.setVisibility(View.VISIBLE);
                }
            }
        });

        TextView contentquim = findViewById(R.id.contentquim);
        contentquim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView contView = findViewById(R.id.contentquimcont);
                if(contView.getVisibility() == View.VISIBLE){
                    contView.setVisibility(View.GONE);
                }else{
                    contView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}