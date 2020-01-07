package com.example.myapplication0107;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Email extends AppCompatActivity {

    private EditText edEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
    }
    public void password() {
        Intent intent = new Intent(this, Password.class);
        SharedPreferences setting = getSharedPreferences("test", MODE_PRIVATE);
        setting.edit()
                .putString("mail", edEmail.getText().toString())
                .commit();
        startActivityForResult(intent, 10);
    }

    public void next2(View view) {
        edEmail = findViewById(R.id.ed_mail);
        String mail = edEmail.getText().toString();
        if (!TextUtils.isEmpty(edEmail.getText().toString())) {
            SharedPreferences setting = getSharedPreferences("test", MODE_PRIVATE);
//            setting.edit()
//                    .putString("user",edUername.getText().toString())
//                    .commit();
            Log.d("RESULT_EMAIL", mail);
            setResult(RESULT_OK);
            finish();
            password();
        }
    }
}
