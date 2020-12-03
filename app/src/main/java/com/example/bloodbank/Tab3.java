package com.example.bloodbank;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Tab3 extends Fragment {

    Button Btn,BtnUpdate, BtnCancel;
    EditText etEmail, etName2, etGender2, etAddress2, etCity2, etBloodGroup2, etPhone2,etEmail2;
    FirebaseDatabase database;
    DatabaseReference reference;
    int i = 0;
    Member member;


    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab3, container, false);
        Btn = view.findViewById(R.id.EditBtn);
        BtnCancel = view.findViewById(R.id.BtnCancel);
        BtnUpdate = view.findViewById(R.id.BtnUpdate);
        etName2 = view.findViewById(R.id.etName2);
        etGender2 = view.findViewById(R.id.etGender2);
        etAddress2 = view.findViewById(R.id.etAddress2);
        etCity2 = view.findViewById(R.id.etCity2);
        etBloodGroup2 = view.findViewById(R.id.etBloodGroup2);
        etPhone2 = view.findViewById(R.id.etContactNo2);
        etEmail2 = view.findViewById(R.id.etEmail2);
        etEmail = view.findViewById(R.id.etEmailatLogin);

        final String st = getActivity().getIntent().getExtras().getString("Value");

        reference = FirebaseDatabase.getInstance().getReference().child("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    if(ds.child("email").getValue().equals(st)){
                        etName2.setText(ds.child("name").getValue().toString());
                        etGender2.setText(ds.child("gender").getValue().toString());
                        etPhone2.setText(ds.child("phone").getValue().toString());
                        etCity2.setText(ds.child("city").getValue().toString());
                        etAddress2.setText(ds.child("address").getValue().toString());
                        etEmail2.setText(ds.child("email").getValue().toString());
                        etBloodGroup2.setText(ds.child("spinner").getValue().toString());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Btn.setVisibility(View.INVISIBLE);
                Btn.setEnabled(false);
                etName2.setEnabled(true);
                etGender2.setEnabled(true);
                etPhone2.setEnabled(true);
                etEmail2.setEnabled(true);
                etCity2.setEnabled(true);
                etAddress2.setEnabled(true);
                etBloodGroup2.setEnabled(true);
                BtnCancel.setVisibility(View.VISIBLE);
                BtnCancel.setEnabled(true);
                BtnUpdate.setVisibility(View.VISIBLE);
                BtnUpdate.setEnabled(true);



                BtnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String Name = etName2.getText().toString().trim();
                        String Phone = etPhone2.getText().toString().trim();
                        String Address = etAddress2.getText().toString().trim();
                        String City = etCity2.getText().toString().trim();
                        String Gender = etGender2.getText().toString().trim();
                        String Blood = etBloodGroup2.getText().toString().trim();
                        String Email = etEmail2.getText().toString().trim();
                        HashMap hashMap = new HashMap();
                        hashMap.put("name",Name);
                        hashMap.put("address",Address);
                        hashMap.put("phone",Phone);
                        hashMap.put("city",City);
                        hashMap.put("gender",Gender);
                        hashMap.put("spinner",Blood);
                        hashMap.put("email",Email);

                        reference.child("1").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                                Toast.makeText(getContext(), "Updated", Toast.LENGTH_SHORT).show();
                            }
                        });

                        etName2.setEnabled(false);
                        etPhone2.setEnabled(false);
                        etAddress2.setEnabled(false);
                        etCity2.setEnabled(false);
                        etGender2.setEnabled(false);
                        etBloodGroup2.setEnabled(false);
                        etEmail2.setEnabled(false);
                        BtnUpdate.setVisibility(View.INVISIBLE);
                        BtnUpdate.setEnabled(false);
                        BtnCancel.setVisibility(View.INVISIBLE);
                        BtnCancel.setEnabled(false);
                        Btn.setVisibility(View.VISIBLE);
                        Btn.setEnabled(true);
                    }
                });
            }

        });

        BtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds: dataSnapshot.getChildren()){
                            if(ds.child("email").getValue().equals(st)){
                                etName2.setText(ds.child("name").getValue().toString());
                                etGender2.setText(ds.child("gender").getValue().toString());
                                etPhone2.setText(ds.child("phone").getValue().toString());
                                etCity2.setText(ds.child("city").getValue().toString());
                                etAddress2.setText(ds.child("address").getValue().toString());
                                etEmail2.setText(ds.child("email").getValue().toString());
                                etBloodGroup2.setText(ds.child("spinner").getValue().toString());

                                Btn.setVisibility(View.VISIBLE);
                                Btn.setEnabled(true);
                                etName2.setEnabled(false);
                                etGender2.setEnabled(false);
                                etPhone2.setEnabled(false);
                                etEmail2.setEnabled(false);
                                etCity2.setEnabled(false);
                                etAddress2.setEnabled(false);
                                etBloodGroup2.setEnabled(false);
                                BtnCancel.setVisibility(View.INVISIBLE);
                                BtnCancel.setEnabled(false);
                                BtnUpdate.setVisibility(View.INVISIBLE);
                                BtnUpdate.setEnabled(false);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        return view;


    }

}


