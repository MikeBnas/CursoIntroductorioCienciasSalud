package com.wordpress.medicourses.cursointroductoriocienciassalud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MediCourses extends AppCompatActivity {
    private Button btnmed;
    private Button btnshared;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medi_courses);
        btnmed = findViewById(R.id.buttonmed);
        url = "https://medicoursesorg.wordpress.com/";
        btnmed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnshared= findViewById(R.id.buttonshared);
        btnshared.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                url = "https://medicoursesorg.wordpress.com/catalogo/";
                String mensaje = "Descarga la app MediCourses Introductorio desde MediCourses ";
                Intent compartir = new Intent(android.content.Intent.ACTION_SEND);
                compartir.setType("text/plain");
                compartir.putExtra(android.content.Intent.EXTRA_TEXT, mensaje + url);
                startActivity(Intent.createChooser(compartir, "Compartir vía"));

            }
        });

    }

    public void gamee(View view) {
        url = "https://www.gamee.com/get/wjqre9n1";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}