package com.example.bookapp;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    TextView createacc;
    TextInputLayout user, Pass;
    Button login, exit;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createacc = (TextView) findViewById(R.id.tvCreate);
        login = (Button) findViewById(R.id.Login_btn);
        exit = (Button) findViewById(R.id.buttonExit);
        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
                finish();
//                setContentView(R.layout.create_account);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có chắc muốn thoát App không?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();

            }
        });

        try {
            user = (TextInputLayout) findViewById(R.id.login_username);
            Pass = (TextInputLayout) findViewById(R.id.login_password);
            login = (Button) findViewById(R.id.Login_btn);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    username = user.getEditText().getText().toString().trim();
                    password = Pass.getEditText().getText().toString().trim();
                    if (isValid()) {

                    }else if(username.equals("12345") && password.equals("12345")) {

                            Intent intent = new Intent(Login.this, Registration.class);
                            startActivity(intent);
                            finish();


// 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Login.this);
// 2. Chain together various setter methods to set the dialog characteristics
                        builder.setMessage("Đăng Nhập thành công");
// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
                        android.app.AlertDialog dialog = builder.create();
                        dialog.show();
                    }else {
// 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Login.this);
// 2. Chain together various setter methods to set the dialog characteristics
                        builder.setMessage("Đăng Nhập không thành công");
// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
                        android.app.AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                }
            });

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    public boolean isValid() {
        user.setErrorEnabled(false);
        user.setError("");
        Pass.setErrorEnabled(false);
        Pass.setError("");

        boolean isvaliduser = false, isvalidpassword = false, isvalid = false;
        if (TextUtils.isEmpty(username)) {
            user.setErrorEnabled(true);
            user.setError("Username is required");
        }
//        else {
//                user.setErrorEnabled(true);
//                user.setError("Enter a valid Username");
//            }

        if (TextUtils.isEmpty(password)) {
            Pass.setErrorEnabled(true);
            Pass.setError("Password is required");
        }
        else {
            isvalidpassword = true;
        }
        isvalid = (isvaliduser && isvalidpassword) ? true : false;
        return isvalid;
    }


}
