package com.example.bookdescription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    TextView text1,text2,text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);
        text3 = (TextView)findViewById(R.id.textView3);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if(b!=null){
            String name = b.getString("name");
            String author = b.getString("author");
            String description = b.getString("description");
            text1.setText(name);
            text2.setText(author);
            text3.setText(description);

        }

    }
}

