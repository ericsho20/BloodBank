package com.example.bloodbank;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Tab1 extends Fragment{

    Spinner spinner3;
    DatabaseReference reference;
    ListView listView;
    ArrayList<String> myArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.activity_tab1,container,false);

       spinner3 = view.findViewById(R.id.spinner3);
       listView = view.findViewById(R.id.listView);

       final ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,myArrayList);
        listView.setAdapter(myArrayAdapter);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                switch(position){
                    case 1:
                        reference = FirebaseDatabase.getInstance().getReference().child("Users");
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                    if (ds.child("spinner").getValue().equals("A-")) {
                                        final String name = ds.child("name").getValue().toString();
                                        String city = ds.child("city").getValue().toString();
                                        final String phone = ds.child("phone").getValue().toString();
                                        myArrayAdapter.clear();
                                        myArrayAdapter.add(name);
                                        myArrayAdapter.notifyDataSetChanged();

                                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                Toast.makeText(getContext(), ""+phone, Toast.LENGTH_SHORT).show();


                                            }
                                        });
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });

                        break;
                    case 2:
                        reference = FirebaseDatabase.getInstance().getReference().child("Users");
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                    if (ds.child("spinner").getValue().equals("A+")) {
                                       final String name = ds.child("name").getValue().toString();
                                        final String phone = ds.child("phone").getValue().toString();
                                        myArrayAdapter.clear();
                                        myArrayAdapter.add(name);
                                        myArrayAdapter.notifyDataSetChanged();

                                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                Toast.makeText(getContext(), ""+phone, Toast.LENGTH_SHORT).show();


                                            }
                                        });
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        break;

                    case 3:
                        reference = FirebaseDatabase.getInstance().getReference().child("Users");
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                    if (ds.child("spinner").getValue().equals("B-")) {
                                        final String name = ds.child("name").getValue().toString();
                                        final String phone = ds.child("phone").getValue().toString();
                                        myArrayAdapter.clear();
                                        myArrayAdapter.add(name);
                                        myArrayAdapter.notifyDataSetChanged();

                                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                Toast.makeText(getContext(), ""+phone, Toast.LENGTH_SHORT).show();


                                            }
                                        });
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        break;

                    case 4:
                        reference = FirebaseDatabase.getInstance().getReference().child("Users");
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                    if (ds.child("spinner").getValue().equals("B+")) {
                                        final String name = ds.child("name").getValue().toString();
                                        final String phone = ds.child("phone").getValue().toString();
                                        myArrayAdapter.clear();
                                        myArrayAdapter.add(name);
                                        myArrayAdapter.notifyDataSetChanged();

                                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                Toast.makeText(getContext(), ""+phone, Toast.LENGTH_SHORT).show();


                                            }
                                        });
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        break;

                    case 5:
                        reference = FirebaseDatabase.getInstance().getReference().child("Users");
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                    if (ds.child("spinner").getValue().equals("AB-")) {
                                       final String name = ds.child("name").getValue().toString();
                                        final String phone = ds.child("phone").getValue().toString();
                                        myArrayAdapter.clear();
                                        myArrayAdapter.add(name);
                                        myArrayAdapter.notifyDataSetChanged();

                                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                Toast.makeText(getContext(), ""+phone, Toast.LENGTH_SHORT).show();


                                            }
                                        });
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        break;

                    case 6:
                        reference = FirebaseDatabase.getInstance().getReference().child("Users");
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                    if (ds.child("spinner").getValue().equals("AB+")) {
                                        final String name = ds.child("name").getValue().toString();
                                        final String phone = ds.child("phone").getValue().toString();
                                        myArrayAdapter.clear();
                                        myArrayAdapter.add(name);
                                        myArrayAdapter.notifyDataSetChanged();

                                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                Toast.makeText(getContext(), ""+phone, Toast.LENGTH_SHORT).show();


                                            }
                                        });
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        break;

                    case 7:
                        reference = FirebaseDatabase.getInstance().getReference().child("Users");
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                    if (ds.child("spinner").getValue().equals("O-")) {
                                        final String name = ds.child("name").getValue().toString();
                                        final String phone = ds.child("phone").getValue().toString();
                                        myArrayAdapter.clear();
                                        myArrayAdapter.add(name);
                                        myArrayAdapter.notifyDataSetChanged();

                                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                Toast.makeText(getContext(), ""+phone, Toast.LENGTH_SHORT).show();


                                            }
                                        });
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        break;

                    case 8:
                        reference = FirebaseDatabase.getInstance().getReference().child("Users");
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                    if (ds.child("spinner").getValue().equals("O+")) {
                                        final String name = ds.child("name").getValue().toString();
                                        final String phone = ds.child("phone").getValue().toString();
                                        myArrayAdapter.clear();
                                        myArrayAdapter.add(name);
                                        myArrayAdapter.notifyDataSetChanged();

                                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                Toast.makeText(getContext(), ""+phone, Toast.LENGTH_SHORT).show();


                                            }
                                        });
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        break;

                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        List<String> Bloodtype = new ArrayList<>();
        Bloodtype.add(0, "Select the blood to request");
        Bloodtype.add("A-");
        Bloodtype.add("A+");
        Bloodtype.add("B-");
        Bloodtype.add("B+");
        Bloodtype.add("AB-");
        Bloodtype.add("AB+");
        Bloodtype.add("O-");
        Bloodtype.add("O+");

        final ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, Bloodtype);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter);


       return view;


    }

}


