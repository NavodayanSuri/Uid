package com.example.surendrasingh.uid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class View_Acctivity extends AppCompatActivity {

    TextView saveddata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__acctivity);

        saveddata=(TextView)findViewById(R.id.entered);

        Intent intent=getIntent();

        String name=intent.getStringExtra("name");
        String clas=intent.getStringExtra("class");

        saveddata.setText("Name :- "+name+"\n"+"class :- "+clas);

    }
}
