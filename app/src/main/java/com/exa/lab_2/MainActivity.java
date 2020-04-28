package com.exa.lab_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button2 = findViewById(R.id.button5);
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);
        });

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    public void handleClick(View view) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
    }
   /* public void handleClickOnThird(View view) {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Пользователь вышел из SecondActivity", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_OK) {

                if (data != null) {
                    String text = data.getStringExtra("result");
                    if (text != null) {
                        TextView tv = findViewById(R.id.textView2);
                        tv.setText(text);
                    }
                }
            }
        }
    }
}
