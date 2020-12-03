package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity{


    EditText etName, etPhone, etAddress, etCity, etEmailLogin, etPasswordLogin;
    RadioGroup radioGroup;
    RadioButton buttonMale, buttonFemale;
    FirebaseAuth fAuth;
    Button registerBtn;
    Spinner spinner;
    FirebaseDatabase database;
    DatabaseReference reference;
    int i = 0;
    Member member;
    String st;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        member = new Member();

        radioGroup = findViewById(R.id.radioGroup);
        etName = findViewById(R.id.etName);
        etPhone    = findViewById(R.id.etPhone);
        etAddress  = findViewById(R.id.etAddress);
        etCity     = findViewById(R.id.etCity);
        buttonMale = findViewById(R.id.radioButton);
        buttonFemale = findViewById(R.id.radioButton2);
        etEmailLogin = findViewById(R.id.etEmailLogin);
        etPasswordLogin = findViewById(R.id.etPasswordLogin);
        spinner = findViewById(R.id.spinner);

        reference = database.getInstance().getReference().child("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    i = (int)dataSnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        List<String> Bloodtype = new ArrayList<>();
        Bloodtype.add(0, "Choose your blood type");
        Bloodtype.add("A-");
        Bloodtype.add("A+");
        Bloodtype.add("B-");
        Bloodtype.add("B+");
        Bloodtype.add("AB-");
        Bloodtype.add("AB+");
        Bloodtype.add("O-");
        Bloodtype.add("O+");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Bloodtype);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // TODO Auto-generated method stub
            }
        });

        fAuth = FirebaseAuth.getInstance();
        registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String Male = buttonMale.getText().toString();
                String Female = buttonFemale.getText().toString();
                String Name = etName.getText().toString().trim();
                String Phone = etPhone.getText().toString().trim();
                String Address = etAddress.getText().toString().trim();
                String City = etCity.getText().toString().trim();
                int Gender = radioGroup.getCheckedRadioButtonId();
                String EmailLogin = etEmailLogin.getText().toString().trim();
                String PasswordLogin = etPasswordLogin.getText().toString().trim();

                st = etName.getText().toString();

                member.setName(etName.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(member);

                member.setPhone(etPhone.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(member);

                member.setAddress(etAddress.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(member);

                member.setCity(etCity.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(member);

                member.setSpinner(spinner.getSelectedItem().toString());
                reference.child(String.valueOf(i + 1)).setValue(member);

                member.setEmail(etEmailLogin.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(member);

                if (buttonMale.isChecked()) {
                    member.setGender(Male);
                    reference.child(String.valueOf(i + 1)).setValue(member);
                } else if (buttonFemale.isChecked()) {
                    member.setGender(Female);
                    reference.child(String.valueOf(i + 1)).setValue(member);
                } else if (TextUtils.isEmpty(Name)) {
                    etName.setError("Name is Required");
                    return;
                } else if (TextUtils.isEmpty(Phone)) {
                    etPhone.setError("Phone is Required");
                    return;
                } else if (TextUtils.isEmpty(Address)) {
                    etAddress.setError("Address is Required");
                    return;
                } else if (TextUtils.isEmpty(City)) {
                    etCity.setError("City is Required");
                    return;
                } else if (Gender <= 0) {
                    Toast.makeText(Register.this, "Gender is required", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(EmailLogin)) {
                    etEmailLogin.setError("Email is required");
                    return;

                } else if (TextUtils.isEmpty(PasswordLogin)) {
                    etPasswordLogin.setError("Password is required");
                    return;

                } else if (PasswordLogin.length() < 6) {
                    etPasswordLogin.setError("Password must not less than 6 chacracter");
                    return;
                }

                    fAuth.createUserWithEmailAndPassword(EmailLogin, PasswordLogin).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), Login.class));
                                getIntent().putExtra("Extras", st);

                            } else {

                                Toast.makeText(Register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
        });

    }
}