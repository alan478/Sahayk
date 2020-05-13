package com.example.covid19.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.covid19.R;
import com.example.covid19.adapter.MyAdapter;
import com.example.covid19.model.TitleChild;
import com.example.covid19.model.TitleCreator;
import com.example.covid19.model.TitleParent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class priscriptions extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageButton imageButton;
    RelativeLayout relativeLayout;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priscriptions);



        BottomNavigationView navigationView= findViewById(R.id.bv);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.maps:
                        Intent c = new Intent(priscriptions.this, MapsActivity.class);
                        startActivity(c);

                        break;
                    case R.id.medicines:


                        break;
                    case R.id.twiiter:
                        Intent b = new Intent(priscriptions.this, mainone.class);
                        startActivity(b);
                        break;
                    case R.id.chat:
                        Intent d = new Intent(priscriptions.this, chatapp.class);
                        startActivity(d);
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
    }



    public void openRecycler(View view){
        recyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        int addItemAtListPosition = 2;
        MyAdapter adapter = new MyAdapter(this,initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);
        adapter.notifyItemInserted(addItemAtListPosition);
        recyclerView.setAdapter(adapter);
        addItemAtListPosition=addItemAtListPosition+1;

    }

    private List<ParentObject> initData() {
        TitleCreator titleCreator = TitleCreator.get(this);
        List<TitleParent> titles = titleCreator.getAll();
        List<ParentObject> parentObject = new ArrayList<>();
        for(TitleParent title:titles)
        {
            List<Object> childList = new ArrayList<>();
            childList.add(new TitleChild("Dosage in mg","Frequency"));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }
        return parentObject;

    }
}
