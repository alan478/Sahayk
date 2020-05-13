package com.example.covid19.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.covid19.R;
import com.example.covid19.adapter.eventlistadapter;
import com.example.covid19.model.tweets;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class mainone extends AppCompatActivity {

    List<tweets> alan;



    RecyclerView recyclerview;
    eventlistadapter ea;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainone);
        recyclerview=findViewById(R.id.recycler);
        recyclerview.setHasFixedSize(true);
        alan=new ArrayList<tweets>();
        ea= new eventlistadapter(getApplicationContext(),alan);
        recyclerview.setAdapter(ea);



        BottomNavigationView navigationView= findViewById(R.id.bv);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.chat:
                        Intent d = new Intent(mainone.this, chatapp.class);
                        startActivity(d);
                        break;
                    case R.id.maps:
                        Intent c = new Intent(mainone.this, MapsActivity.class);
                        startActivity(c);

                        break;
                    case R.id.medicines:
                        Intent b = new Intent(mainone.this, priscriptions.class);
                        startActivity(b);
                        break;
                    case R.id.twiiter:


                        break;
                    case R.id.chat2:
                        Intent e =new Intent(Intent.ACTION_VIEW);
                        String a="https://vigilant-feynman-b3087f.netlify.com/";
                        e.setData(Uri.parse(a));
                        startActivity(e);
                        break;

                }

                return false;
            }
        });





        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("twitter");


        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                tweets tweetsa=dataSnapshot.getValue(tweets.class);
                alan.add(new tweets(tweetsa.getUsername(),tweetsa.getText(),tweetsa.getDate(),tweetsa.getLink()));
                ea.notifyDataSetChanged();









            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for(DataSnapshot ds : dataSnapshot)
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        })




















    }





}
