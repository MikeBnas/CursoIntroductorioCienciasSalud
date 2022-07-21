package com.wordpress.medicourses.cursointroductoriocienciassalud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Matematicas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematicas);

        Button button = findViewById(R.id.buttonmat);
        Button button2 = findViewById(R.id.buttonbes);
        Button button3 = findViewById(R.id.buttonsi);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Matematicas.this, PDFActivity.class);
                intent.putExtra("param", "mpuf.pdf");
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Matematicas.this, PDFActivity.class);
                intent.putExtra("param", "besr.pdf");
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Matematicas.this, PDFActivity.class);
                intent.putExtra("param", "si.pdf");
                startActivity(intent);
            }
        });



        TextView sectionmat = findViewById(R.id.sectionmat);
        sectionmat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView secView = findViewById(R.id.sectionmatcont);
                if(secView.getVisibility() == View.VISIBLE){
                    secView.setVisibility(View.GONE);
                }else{
                    secView.setVisibility(View.VISIBLE);
                }
            }
        });

        TextView contentmat = findViewById(R.id.contentmat);
        contentmat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView contView = findViewById(R.id.contentmatcont);
                if(contView.getVisibility() == View.VISIBLE){
                    contView.setVisibility(View.GONE);
                }else{
                    contView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}