package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private EditText editTextFullName;
    private EditText editTextGroup;
    private EditText editTextAge;
    private EditText editTextGrade;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Инициализация элементов
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextGroup = findViewById(R.id.editTextGroup);
        editTextAge = findViewById(R.id.editTextAge);
        editTextGrade = findViewById(R.id.editTextGrade);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Обработка нажатия на кнопку отправки
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = editTextFullName.getText().toString();
                String group = editTextGroup.getText().toString();
                String age = editTextAge.getText().toString();
                String grade = editTextGrade.getText().toString();

                String message = "ФИО: " + fullName + "\n" +
                        "Группа: " + group + "\n" +
                        "Возраст: " + age + "\n" +
                        "Оценка: " + grade;

                Toast.makeText(SecondActivity.this,
                        "Данные получены:\n" + message, Toast.LENGTH_LONG).show();
            }
        });
    }
}