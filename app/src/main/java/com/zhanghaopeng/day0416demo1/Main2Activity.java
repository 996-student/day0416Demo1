package com.zhanghaopeng.day0416demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {
    private TextView edit ;
    private Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edit = findViewById(R.id.editText);
        btn = findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = load();
                edit.setText(str);
            }
        });
    }
    public String load(){
        FileInputStream in = null ;
        BufferedReader reader = null ;
        StringBuilder builder = new StringBuilder();
        try {
            in = openFileInput("key");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = " ";
            while ((line = reader.readLine()) != null){
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.toString();
    }
}
