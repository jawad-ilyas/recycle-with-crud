package com.example.finalrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdaptor  extends RecyclerView.Adapter<PersonAdaptor.ViewHolder> {


    ArrayList<Person> personArrayList;
    Context context;

    public  interface  OnContactClicked{

        public void onClick(int index);

    }
    OnContactClicked myActivity;
    PersonAdaptor(Context context , ArrayList<Person> personArrayList){
        this.personArrayList = personArrayList;
        this.context = context;
        myActivity = (OnContactClicked)context;
    }





    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvCnumber ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCnumber = itemView.findViewById(R.id.tvCnumber);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index =personArrayList.indexOf((Person) itemView.getTag());
                    myActivity.onClick(index);
                }
            });
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvCnumber.setText(personArrayList.get(position).Number);
        holder.itemView.setTag(personArrayList.get(position));


    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }
}
