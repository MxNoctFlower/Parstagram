package com.example.nvjscholar.parstagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignUpActivity extends AppCompatActivity{

    private EditText signuser;
    private EditText signpass;
    private EditText signemail;
    private Button bttncreate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signuser = findViewById(R.id.etSignUser);
        signpass = findViewById(R.id.etSignPass);
        signemail = findViewById(R.id.etSignEmail);
        bttncreate = findViewById(R.id.bttncreate);


        bttncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = signuser.getText().toString();
                final String password = signpass.getText().toString();
                final String email = signemail.getText().toString();
                CreateUser(username, password, email);
            }
        });


    }


    private void CreateUser(String username, String password, String email){
        // Create the ParseUser
        ParseUser user = new ParseUser();
// Set core properties
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
// Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("SignUpActivity", "Sign up Successful");
                    final Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Log.e("SignUpActivity", "Sign up Failure");
                    e.printStackTrace();
                }
            }
        });

    }
}
