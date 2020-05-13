package com.example.covid19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.R;
import com.example.covid19.model.mesg;

import java.util.List;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.chatviewholder> {

    private Context mct;
    private List<mesg> list;

    public chatAdapter(Context mct,List<mesg> list) {
        this.mct = mct;
        this.list = list;
    }

    @Override
    public chatviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mct);
        View view = inflater.inflate(R.layout.chat_messages,null);
        return new chatviewholder(view);
    }

    @Override
    public void onBindViewHolder(chatviewholder holder,  int position) {
        mesg d= list.get(position);
        holder.user.setText(d.getUser());
        holder.disg.setText(d.getDisg());
        holder.msg.setText(d.getMsg());








    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class chatviewholder extends RecyclerView.ViewHolder{


        TextView user,disg,msg;
        




        public chatviewholder(View itemView) {
            super(itemView);

            user=itemView.findViewById(R.id.user);
            disg=itemView.findViewById(R.id.disg);
            msg=itemView.findViewById(R.id.msg);









        }



    }


}

