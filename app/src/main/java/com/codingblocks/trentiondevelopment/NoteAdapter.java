package com.codingblocks.trentiondevelopment;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Note> arrayList;


    public NoteAdapter(ArrayList<Note> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());


        //This means we are inflating an ImageClass
        View view = li.inflate(R.layout.item_row, viewGroup, false);
        return new NoteHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {

        Note note = arrayList.get(position);
       NoteHolder notes = (NoteHolder) viewHolder;


        notes.title.setText(note.getName());
        notes.date.setText(note.getDate());
        notes.time.setText(note.getTime());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        TextView title,date,time,serial;
        CardView cardView;




        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            cardView=itemView.findViewById(R.id.card_view);
            title = itemView.findViewById(R.id.tvname);
            date=itemView.findViewById(R.id.tvdate);
time=itemView.findViewById(R.id.tvtime);

        }
    }


}