package com.example.garbageiot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LandingPage extends AppCompatActivity {

    ArrayList<dustbin_info> dustbin_infoArrayList=new ArrayList<>();
    custom_dustbin_arrayAdaptor custom_dustbin_arrayAdaptor;
    ListView lv;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        lv=findViewById(R.id.listViewOfDustbins);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onClickOfDustbin(position);
            }
        });
        progressBar=findViewById(R.id.progressBarListDustbin);
        progressBar.setVisibility(View.INVISIBLE);
        fillTheList();

    }
    void fillTheList()
    {
        progressBar.setVisibility(View.VISIBLE);
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("block1");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dustbin_infoArrayList.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    dustbin_info d= dataSnapshot.getValue(dustbin_info.class);

                    dustbin_infoArrayList.add(d);
                    fillTheListView();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    void fillTheListView()
    {
        try {
            custom_dustbin_arrayAdaptor=new custom_dustbin_arrayAdaptor(this,dustbin_infoArrayList);
            lv.setAdapter(custom_dustbin_arrayAdaptor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        progressBar.setVisibility(View.INVISIBLE);
    }
    void onClickOfDustbin(int index)
    {
        Intent intent=new Intent(this,DustbinLocation.class);
        intent.putExtra("lat",dustbin_infoArrayList.get(index).getLat());
        intent.putExtra("lng",dustbin_infoArrayList.get(index).getLng());
        intent.putExtra("name",dustbin_infoArrayList.get(index).getDustbinname());
        startActivity(intent);
    }




}