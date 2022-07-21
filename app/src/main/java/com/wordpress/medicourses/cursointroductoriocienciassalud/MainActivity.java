package com.wordpress.medicourses.cursointroductoriocienciassalud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = this.getSharedPreferences("com.wordpress.medicourses.cursointroductoriocienciassalud", Context.MODE_PRIVATE);
        String value = prefs.getString("appstatus",null);
        if(value == null){
            SharedPreferences.Editor editor = prefs.edit();

            String idValidation = generateRandomString(32);
            String preCode = idValidation.substring(5, 9);
            String postCode = idValidation.substring(25, 29);
            String validCode = postCode + preCode;
            editor.clear();
            editor.putString("appcode", idValidation);
            editor.putString("validcode", validCode.toUpperCase());
            editor.putString("appstatus", "unvalid");
            editor.apply();
        };

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }

        adapter = new CustomeAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    public void viewSection(View v) {
        SharedPreferences prefes = this.getSharedPreferences("com.wordpress.medicourses.cursointroductoriocienciassalud", Context.MODE_PRIVATE);
        String valuePr = prefes.getString("appstatus", "");
        String alerText = "Compra la app para acceder a esta seccion";
        switch (v.getId()) {
            case 1:
                Intent intent1 = new Intent(MainActivity.this, Biologia.class);
                startActivity(intent1);
                break;
            case 2:
                if(valuePr.equals("unvalid")){
                    createSimpleDialog(alerText);
                } else {
                    Intent intent2 = new Intent(MainActivity.this, Fisica.class);
                    startActivity(intent2);
                }
                break;
            case 3:
                if(valuePr.equals("unvalid")){
                    createSimpleDialog(alerText);
                } else {
                    Intent intent3 = new Intent(MainActivity.this, Lenguaje.class);
                    startActivity(intent3);
                }
                break;
            case 4:
                if(valuePr.equals("unvalid")){
                    createSimpleDialog(alerText);
                } else {
                    Intent intent4 = new Intent(MainActivity.this, Matematicas.class);
                    startActivity(intent4);
                }
                break;
            case 5:
                if(valuePr.equals("unvalid")){
                    createSimpleDialog(alerText);
                } else {
                    Intent intent5 = new Intent(MainActivity.this, Publica.class);
                    startActivity(intent5);
                }
                break;
            case 6:
                if(valuePr.equals("unvalid")){
                    createSimpleDialog(alerText);
                } else {
                    Intent intent6 = new Intent(MainActivity.this, Quimica.class);
                    startActivity(intent6);
                }
                break;
            case 7:
                if(valuePr.equals("unvalid")){
                    createSimpleDialog(alerText);
                } else {
                    Intent intent7 = new Intent(MainActivity.this, Anatomia.class);
                    startActivity(intent7);
                }
                break;
            case 8:
                    Intent intent8 = new Intent(MainActivity.this, MediCourses.class);
                    startActivity(intent8);
                break;
        }
    }

    static String generateRandomString(int length) {
        String CHAR_LOWER = "bcdfghjklmnpqrstvwxyz";
        String CHAR_VOCALS = "aeiou";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";

        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_VOCALS + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);
        }

        String idApp = sb.toString();
        return idApp;
    }

    public void createSimpleDialog(String string) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String text = string;
        builder.setTitle("Alerta");
        builder.setMessage(string);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                acceptButton();
            }
        });
        builder.setNegativeButton("Cancelar", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void acceptButton(){
        Intent intent = new Intent(MainActivity.this, ValidateActivity.class);
        startActivity(intent);
    }

}