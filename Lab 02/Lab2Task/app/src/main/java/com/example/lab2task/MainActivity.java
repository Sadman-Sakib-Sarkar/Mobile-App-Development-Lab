package com.example.lab2task;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;

import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public class Phones{
        List<String>getInfo(String group){
            List<String>info= new ArrayList<>();
            if (group.equals("Samsung")) {
                info.add("\nSamsung Galaxy S21");
                info.add("\nSamsung Galaxy S21 Plus");
                info.add("\nSamsung Galaxy S21 Ultra");
                info.add("\nSamsung Galaxy S24");
                info.add("\nSamsung Galaxy S24 Plus");
                info.add("\nSamsung Galaxy S24 Ultra");
            }

            if (group.equals("Apple")) {
                info.add("\nIphone 14");
                info.add("\nIphone 14 Pro");
                info.add("\nIphone 14 Pro Max");
                info.add("\nIphone 15");
                info.add("\nIphone 15 Pro");
                info.add("\nIphone 15 Pro Max");
            }

            if (group.equals("Xiaomi")) {
                info.add("\nRedmi 13");
                info.add("\nRedmi Note 13 Pro");
                info.add("\nRedmi Note 13 pro 5g");
                info.add("\nRedmi Note 13 pro plus 5g");
            }

            return info;
        }
    }
    private Phones expert= new Phones();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClickFindInfo(View view){
        TextView info =(TextView)  findViewById(R.id.text);
        TextView info2 =(TextView)  findViewById(R.id.infoss);
        Spinner dis = (Spinner) findViewById(R.id.spinner);
        String type=String.valueOf(dis.getSelectedItem());
        List<String>infoList =expert.getInfo(type);
        StringBuilder infoFormatted = new StringBuilder();
        for(String inf : infoList)
        {
            infoFormatted.append(inf).append('\n');
        }
        info2.setText("Available Models");
        info.setText(infoFormatted);
    }
}