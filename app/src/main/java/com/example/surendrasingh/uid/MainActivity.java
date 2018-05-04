package com.example.surendrasingh.uid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText name,classs;
    Button sub;
    DatabaseReference mref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.editname);
        classs=(EditText)findViewById(R.id.cla);
        sub=(Button)findViewById(R.id.submit);
        mref=FirebaseDatabase.getInstance().getReference("data");

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm=name.getText().toString().trim();
                String cl=classs.getText().toString().trim();
                data res=new data(nm,cl);
                if(!TextUtils.isEmpty(nm)&&!TextUtils.isEmpty(cl)){
                    mref.push().setValue(res);
                    Toast.makeText(getApplicationContext(),"data saved",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(MainActivity.this,View_Acctivity.class);
                    intent.putExtra("name",nm);
                    intent.putExtra("class",cl);
                    startActivity(intent);
                }
            }
        });
    }
}
