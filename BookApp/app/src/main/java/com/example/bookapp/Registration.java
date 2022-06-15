package com.example.bookapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    String URL = "http://192.168.1.239/loginandroid/register.php";
    TextView alreadyhaveacc;
    TextInputLayout Fname,Username, Pass, Mobileno, Address, Gender;
    EditText Birth;
    RequestQueue requestQueue;
    int year,month,day;
    Button register;
    String fname,username,pass,mobileno,gender,birth;
    String useridd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        alreadyhaveacc = (TextView)findViewById(R.id.AlreadyHavesignin);
        Birth = (EditText)findViewById(R.id.birthdate);
        Fname = (TextInputLayout) findViewById(R.id.Fullname);
        Username = (TextInputLayout) findViewById(R.id.Username);
        Pass = (TextInputLayout) findViewById(R.id.signup_password);
        Gender = (TextInputLayout) findViewById(R.id.gender);
        Address = (TextInputLayout) findViewById(R.id.signup_address);
        Mobileno = (TextInputLayout) findViewById(R.id.signup_mobile);
        requestQueue = Volley.newRequestQueue(this);
        register = (Button) findViewById(R.id.signup_button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Registration.this);
// 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage("Đăng ký thành công");
// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
                android.app.AlertDialog dialog = builder.create();
                dialog.show();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Registration.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registration.this, error+"", Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        String username = Username.toString();
                        String fullName = Fname.toString();
                        String pass = Pass.toString();
                        String gender = Gender.toString();
                        String mobile = Mobileno.toString();
                        String address = Address.toString();
                        String birth = Birth.toString();
                        params.put("username", username);
                        params.put("password", pass);
                        params.put("Fullname", fullName);
                        params.put("Address", address);
                        params.put("phoneNumber", mobile);
                        params.put("Birthday", birth);
                        return params;
                    }
                };
            requestQueue.add(stringRequest);

            }
        });

        Birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(Registration.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Birth.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });

        alreadyhaveacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

//    }
//
//    public boolean isValid() {
//        Fname.setErrorEnabled(false);
//        Fname.setError("");
//        Username.setErrorEnabled(false);
//        Username.setError("");
//        Pass.setErrorEnabled(false);
//        Pass.setError("");
//        Mobileno.setErrorEnabled(false);
//        Mobileno.setError("");
//        Gender.setErrorEnabled(false);
//        Gender.setError("");
////        Birth.setErrorEnabled(false);
////        Birth.setError("");
//
//        boolean isValidname = false,isvalidpassword = false, isvalid = false, isvalidmobileno = false, isvalidgender = false , isvalidusername=false;
//        if (TextUtils.isEmpty(fname)) {
//            Fname.setErrorEnabled(true);
//            Fname.setError("Fullname is required");
//        } else {
//            isValidname = true;
//        }
//        if (TextUtils.isEmpty(pass)) {
//            Pass.setErrorEnabled(true);
//            Pass.setError("Password is required");
//        } else {
//            if (pass.length() < 6) {
//                Pass.setErrorEnabled(true);
//                Pass.setError("password is too weak");
//            } else {
//                isvalidpassword = true;
//            }
//        }
//        if (TextUtils.isEmpty(mobileno)) {
//            Mobileno.setErrorEnabled(true);
//            Mobileno.setError("Mobile number is required");
//        } else {
//            if (mobileno.length() < 10) {
//                Mobileno.setErrorEnabled(true);
//                Mobileno.setError("Invalid mobile number");
//            } else {
//                isvalidmobileno = true;
//            }
//        }
//        if (TextUtils.isEmpty(gender)) {
//            Gender.setErrorEnabled(true);
//            Gender.setError("Field cannot be empty");
//        } else {
//            isvalidgender = true;
//        }if (TextUtils.isEmpty(username)) {
//            Username.setErrorEnabled(true);
//            Username.setError("Field cannot be empty");
//        } else {
//            isvalidusername = true;
//        }
//
//        isvalid = (isValidname && isvalidpassword && isvalidmobileno &&  isvalidgender && isvalidusername) ? true : false;
//        return isvalid;
//    }
    }
}