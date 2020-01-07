package com.example.myapplication0107;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean logon = false;
    boolean login = false;
    private EditText username;
    private EditText email;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.un);
        email = findViewById(R.id.em);
        password = findViewById(R.id.pa);
        Switch sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                login = isChecked;
                TextView text = findViewById(R.id.sw);
                text.setText(login ? "登入" : "註冊");
                TextView register = findViewById(R.id.registerQ);
                register.setText(login ? "登入" : "註冊");
            }
            });
    }
    public void enter(View view) {
        if (login == false) {
            Intent username = new Intent(this, Username.class);
            startActivityForResult(username, 1);
        }
    }

    public void hello(View view) {
        Intent result = new Intent(this,ResultActivity.class);
        startActivity(result);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == 1) {
                finish();
            } else {
                username.setVisibility(View.VISIBLE);
                email.setVisibility(View.VISIBLE);
                password.setVisibility(View.VISIBLE);
                TextView register = findViewById(R.id.registerQ);
                Button button = findViewById(R.id.button3);
                button.setVisibility(View.INVISIBLE);
                Button result = findViewById(R.id.button10);
                result.setVisibility(View.VISIBLE);
                register.setText("註冊資料");
                username.setText(getSharedPreferences("test",MODE_PRIVATE).getString("user",""));
                email.setText(getSharedPreferences("test",MODE_PRIVATE).getString("mail",""));
                password.setText(getSharedPreferences("test",MODE_PRIVATE).getString("pass",""));
            }
        }
    }
}



