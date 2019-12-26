package com.example.loginv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class phoneSignInActivity extends AppCompatActivity {
    EditText user_phone;

    FirebaseAuth firebaseAuth;

    PhoneAuthProvider phoneAuthProvider;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_sign_in);
        user_phone = (EditText) findViewById(R.id.user_phone_number);
        imageView = (ImageView) findViewById(R.id.imageView);
        user_phone.requestFocus();


        firebaseAuth = FirebaseAuth.getInstance();
        phoneAuthProvider = PhoneAuthProvider.getInstance();
    }
    public void phone_sign_in_button(View view){


        String number = user_phone.getText().toString().trim();

        if(number.isEmpty() || number.length()<12){
            user_phone.setError("Number is required!");
            user_phone.requestFocus();
            return;
        }
        String phoneNumber = "+" + number;
        Intent intent = new Intent(phoneSignInActivity.this,Verify_Phone_Reg.class);
        intent.putExtra("phonenumber",phoneNumber);
        startActivity(intent);
    }



}
