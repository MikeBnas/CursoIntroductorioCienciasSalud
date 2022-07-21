package com.wordpress.medicourses.cursointroductoriocienciassalud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Publica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publica);

        Button button = findViewById(R.id.buttonsp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Publica.this, PDFActivity.class);
                intent.putExtra("param", "aps.pdf");
                startActivity(intent);
            }
        });


        TextView sectionsp = findViewById(R.id.sectionsp);
        sectionsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView secView = findViewById(R.id.sectionspcont);
                if(secView.getVisibility() == View.VISIBLE){
                    secView.setVisibility(View.GONE);
                }else{
                    secView.setVisibility(View.VISIBLE);
                }
            }
        });

        TextView contentsp = findViewById(R.id.contentsp);
        contentsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView contView = findViewById(R.id.contentspcont);
                if(contView.getVisibility() == View.VISIBLE){
                    contView.setVisibility(View.GONE);
                }else{
                    contView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}