package com.exa.lab_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView textView = findViewById(R.id.textView7);
        //String ex = "Богдан Хмельницкий";
        //EditText editText = findViewById(R.id.editText);
        //String text = editText.getText().toString();

        Button button = findViewById(R.id.button4);
        Button button1 = findViewById(R.id.button6);

        button.setOnClickListener(v -> {
            String yes = "Совершенно верно";
            textView.setText(yes);
        });
        button1.setOnClickListener(v -> {
            String no = "Не верно";
            textView.setText(no);
        });
            /*if(text.equals(ex))
            {
               // String yes = "Совершенно верно";
                String no = "если честно, без понятия";
                textView.setText(no);
            }
            else {
                //String no = "Нет";
                String yes = "если честно, без понятия";
                textView.setText(yes);
            }
        });*/
    }


}
