package com.example.bloodbank;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Tab2 extends Fragment{

    Spinner spinner2;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    Button BtnRequestBlood;
    DatabaseReference reference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab2, container, false);

        spinner2 = view.findViewById(R.id.spinner2);
        BtnRequestBlood = view.findViewById(R.id.BtnRequestBlood);
        tv1 = view.findViewById(R.id.tvName11);
        tv2 = view.findViewById(R.id.tvName12);
        tv3 = view.findViewById(R.id.tvName13);
        tv4 = view.findViewById(R.id.tvName14);
        tv5 = view.findViewById(R.id.tvName15);
        tv6 = view.findViewById(R.id.tvName16);
        tv7 = view.findViewById(R.id.tvName17);
        tv8 = view.findViewById(R.id.tvName18);


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

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, Bloodtype);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // TODO Auto-generated method stub
            }
        });


        reference = FirebaseDatabase.getInstance().getReference().child("Users");
        reference.orderByChild("spinner").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    if(ds.child("spinner").getValue().equals("A-")) {
                        tv1.setText("0" + 1);
                    }else if(ds.child("spinner").getValue().equals("A+")){
                        tv2.setText("0" + 1);
                    }else if(ds.child("spinner").getValue().equals("B-")){
                        tv3.setText("0" + 1);
                    }else if(ds.child("spinner").getValue().equals("B+")){
                        tv4.setText("0" + 1);
                    }else if(ds.child("spinner").getValue().equals("AB-")){
                        tv5.setText("0" + 1);
                    }else if(ds.child("spinner").getValue().equals("AB+")) {
                        tv6.setText("0" + 1);
                    }else if(ds.child("spinner").getValue().equals("O-")){
                        tv7.setText("0" + 1);
                    }else if(ds.child("spinner").getValue().equals("O+")){
                        tv8.setText("0" + 1);
                    }

                    }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        BtnRequestBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Blood Requested", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}