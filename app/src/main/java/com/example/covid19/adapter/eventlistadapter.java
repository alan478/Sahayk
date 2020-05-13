package com.example.covid19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.R;
import com.example.covid19.model.tweets;

import java.util.List;

public class eventlistadapter extends RecyclerView.Adapter<eventlistadapter.eventlistviewholder> {

    private Context mct;
    private List<tweets> list;

    public eventlistadapter(Context mct,List<tweets> list) {
        this.mct = mct;
        this.list = list;
    }

    @Override
    public eventlistviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mct);
        View view = inflater.inflate(R.layout.twitterfeed,null);
        return new eventlistviewholder(view);
    }

    @Override
    public void onBindViewHolder(eventlistviewholder holder,  int position) {
        tweets d= list.get(position);
        holder.username2.setText(d.getUsername());
        holder.discription.setText(d.getText());
        holder.date.setText(d.getDate());
        holder.link.setText(d.getLink());







    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class eventlistviewholder extends RecyclerView.ViewHolder{


        TextView username2,discription,date,link;
        ImageView img;




        public eventlistviewholder(View itemView) {
            super(itemView);

            username2=itemView.findViewById(R.id.username2);
            discription=itemView.findViewById(R.id.discription);
            date=itemView.findViewById(R.id.date);
            link= itemView.findViewById(R.id.link);
            img=itemView.findViewById(R.id.birdy);









        }



    }


}
