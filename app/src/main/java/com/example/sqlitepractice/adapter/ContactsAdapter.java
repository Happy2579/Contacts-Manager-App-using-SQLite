package com.example.sqlitepractice.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitepractice.MainActivity;
import com.example.sqlitepractice.R;
import com.example.sqlitepractice.db.entity.Contact;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {


    //1. variables

    private Context context;
    private ArrayList<Contact> contactslist;
    private MainActivity mainactivity;


    //2. ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.email = itemView.findViewById(R.id.email);
        }
    }

    public ContactsAdapter(Context context,ArrayList<Contact> contacts,MainActivity mainactivity){
        this.context=context;
        this.contactslist=contacts;
        this.mainactivity=mainactivity;
    }

    //3. Methods Implementation

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Contact contact=contactslist.get(position);

        holder.name.setText(contact.getName());
        holder.email.setText(contact.getEmail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainactivity.addandEditContacts(true,contact,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactslist.size();
    }


}
