package com.example.myapplication0107;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Password extends AppCompatActivity {
    private EditText edPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
    }
    public void next3(View view) {
        edPassword = findViewById(R.id.ed_password);
        String password = edPassword.getText().toString();
        if (!TextUtils.isEmpty(edPassword.getText().toString())) {
            SharedPreferences setting = getSharedPreferences("test", MODE_PRIVATE);
            setting.edit()
                    .putString("pass", edPassword.getText().toString())
                    .commit();
            Log.d("RESULT_USERNAME",password);
            setResult(RESULT_OK);
            finish();
        }
    }
}
