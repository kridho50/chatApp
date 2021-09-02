package com.example.messagetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuthURL extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String url = "urlKey";
    public static final String token = "tokenKey";
    public static final String phone = "phoneKey";

    EditText etUrl, etToken, etPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_url);
        sharedpreferences = getSharedPreferences(mypreference,
                this.MODE_PRIVATE);

        etUrl = findViewById(R.id.url);
        etToken = findViewById(R.id.token);
        etPhone = findViewById(R.id.phone);
        etUrl.setText(sharedpreferences.getString(url,""));
        etToken.setText(sharedpreferences.getString(token,""));
        etPhone.setText(sharedpreferences.getString(phone,""));

        Button save = findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(url,etUrl.getText().toString());
                editor.putString(token, etToken.getText().toString());
                editor.putString(phone, etPhone.getText().toString());
                editor.commit();
                startActivity(new Intent(AuthURL.this, MainActivity.class));
                finish();
            }
        });

    }
}