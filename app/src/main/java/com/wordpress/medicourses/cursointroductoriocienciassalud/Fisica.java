package com.wordpress.medicourses.cursointroductoriocienciassalud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fisica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica);

        Button button = findViewById(R.id.buttonfis);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fisica.this, PDFActivity.class);
                intent.putExtra("param", "fis.pdf");
                startActivity(intent);
            }
        });


        TextView sectionfis = findViewById(R.id.sectionfis);
        sectionfis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView secView = findViewById(R.id.sectionfiscont);
                if(secView.getVisibility() == View.VISIBLE){
                    secView.setVisibility(View.GONE);
                }else{
                    secView.setVisibility(View.VISIBLE);
                }
            }
        });

        TextView contentbio = findViewById(R.id.contentfis);
        contentbio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView contView = findViewById(R.id.contentfiscont);
                if(contView.getVisibility() == View.VISIBLE){
                    contView.setVisibility(View.GONE);
                }else{
                    contView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}