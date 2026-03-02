package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    private EditText editTextFullName;
    private EditText editTextGroup;
    private EditText editTextAge;
    private EditText editTextGrade;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Проверяем, существует ли layout файл
        try {
            setContentView(R.layout.activity_imput);
        } catch (Exception e) {
            // Если файла activity_input.xml нет, используем activity_main.xml
            setContentView(R.layout.activity_main);
            Toast.makeText(this, "Файл activity_input.xml не найден, используется activity_main.xml", Toast.LENGTH_LONG).show();
        }

        // Инициализация элементов с проверкой на null
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextGroup = findViewById(R.id.editTextGroup);
        editTextAge = findViewById(R.id.editTextAge);
        editTextGrade = findViewById(R.id.editTextGrade);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Проверяем, что все view элементы найдены
        if (editTextFullName == null || editTextGroup == null ||
                editTextAge == null || editTextGrade == null || buttonSubmit == null) {
            Toast.makeText(this, "Ошибка инициализации view элементов", Toast.LENGTH_LONG).show();
            return;
        }

        // Обработка нажатия на кнопку "Отправить"
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем введенные данные
                String fullName = editTextFullName.getText().toString().trim();
                String group = editTextGroup.getText().toString().trim();
                String age = editTextAge.getText().toString().trim();
                String grade = editTextGrade.getText().toString().trim();

                // Исправленная проверка заполнения полей
                if (fullName.isEmpty() || group.isEmpty() || age.isEmpty() || grade.isEmpty()) {
                    Toast.makeText(InputActivity.this,
                            "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Формируем сообщение с данными
                String message = "ФИО: " + fullName + "\n" +
                        "Группа: " + group + "\n" +
                        "Возраст: " + age + "\n" +
                        "Желаемая оценка: " + grade;

                // Показываем все данные в Toast
                Toast.makeText(InputActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}