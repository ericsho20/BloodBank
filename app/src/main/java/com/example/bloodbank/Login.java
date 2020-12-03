package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText etEmailLogin , etPasswordLogin;
    Button register, login;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = findViewById(R.id.button3);
        login = findViewById(R.id.button);
        etEmailLogin = findViewById(R.id.etEmailatLogin);
        etPasswordLogin = findViewById(R.id.etPasswordatLogin);
        fAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String EmailLogin = etEmailLogin.getText().toString().trim();
                String PasswordLogin = etPasswordLogin.getText().toString().trim();

                if (TextUtils.isEmpty(EmailLogin)) {
                    etEmailLogin.setError("Email is required");
                    return;

                }else if (TextUtils.isEmpty(PasswordLogin)){
                    etPasswordLogin.setError("Password is required");

                }else if (PasswordLogin.length() < 6) {
                    etPasswordLogin.setError("Password must not less than 6 chacracter");
                    return;
                }

                //autheticate the user
                fAuth.signInWithEmailAndPassword(EmailLogin,PasswordLogin).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, Tabbed.class);
                            String st = etEmailLogin.getText().toString();
                            intent.putExtra("Value",st);
                            startActivity(intent);

                        }else{
                            Toast.makeText(Login.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
    }
}
