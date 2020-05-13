package com.example.covid19.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.covid19.R;
import com.example.covid19.adapter.chatAdapter;
import com.example.covid19.model.mesg;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class chatapp extends AppCompatActivity {
    RecyclerView lv;
    EditText tc;
    List<mesg> messages1=new ArrayList<mesg>();
    chatAdapter adapter;

    public void send(View view)
    {

        messages1.clear();

        ParseUser user3=ParseUser.getCurrentUser();
        ParseObject parseObject=new ParseObject("Messages");
        parseObject
                .put("messages",tc.getText().toString().trim());
        parseObject.put("user_name",user3.getUsername());
        parseObject.put("designation",user3.get("name"));

        adapter=new chatAdapter(getApplicationContext(),messages1);
        lv.setAdapter(adapter);


        parseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null)
                {
                    Log.i("sent","message sent");




                    ParseQuery<ParseObject> query= ParseQuery.getQuery("Messages");






                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> objects, ParseException e) {
                            if(e==null)
                            {
                                if(objects.size()>0)
                                {
                                    for(ParseObject object:objects)
                                    {

                                        Log.i("messages",object.getString("messages"));
                                        String a=object.getString("messages");
                                        String b =object.getString("user_name");
                                        String c=object.getString("designation");



                                        messages1.add(new mesg(b,c,a));



                                    }




                                }
                            }

                        }
                    });






                }else
                {
                    e.printStackTrace();
                }


            }
        });


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatapp);






        lv=findViewById(R.id.lv);
        lv.setHasFixedSize(true);
        tc=findViewById(R.id.text);
        adapter=new chatAdapter(getApplicationContext(),messages1);
        lv.setAdapter(adapter);

        ParseQuery<ParseObject> query= ParseQuery.getQuery("Messages");






        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null)
                {
                    if(objects.size()>0)
                    {
                        for(ParseObject object:objects)
                        {

                            String a=object.getString("messages");
                            String b =object.getString("user_name");
                            String c=object.getString("designation");



                            Log.i("messages",object.getString("messages"));

                           messages1.add(new mesg(b,c,a));




                        }





                    }
                }

            }
        });















    }

    public void getMessages()
    {







    }


}
