package com.exa.lab_2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        EditText et = findViewById(R.id.editText2);

        Button button = findViewById(R.id.button3);
        button.setOnClickListener(v -> {
            // Считываем значение поля
            String text = et.getText().toString();

            // Формируем "пустое" намерение
            Intent intent = new Intent();
            // Добавляем в намерение данные
            intent.putExtra("result",text);

            // Устанавливаем результат
            setResult(RESULT_OK,intent);

            // Закрываем Activity
            finish();
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        setResult(RESULT_CANCELED);
    }

    public void handleClickSecond(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);

        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "Важное сообщение");
        i.putExtra(Intent.EXTRA_TEXT, "Привет, ты арестован за нарушения карантина!");

        startActivity(i);

        // Получаем Package Manager
        PackageManager manager = this.getPackageManager();
        // Получаем список обработчиков намерения
        List<ResolveInfo> list = manager.queryIntentActivities(i, 0);

        if (list.size() > 0) {
            startActivity(i);
        } else {
            Toast.makeText(this, "Невозможно обработать намерение!", Toast.LENGTH_LONG).show();
        }
    }
}
