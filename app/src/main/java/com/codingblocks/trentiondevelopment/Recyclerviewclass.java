package com.codingblocks.trentiondevelopment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
        import android.content.Context;
        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.support.design.widget.FloatingActionButton;
        import android.widget.Button;
        import android.widget.EditText;

        import com.google.firebase.database.ChildEventListener;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

        import java.util.ArrayList;
        public class Recyclerviewclass extends AppCompatActivity{
    RecyclerView recyclerView;
    NoteAdapter noteAdapter;
    EditText editText;
    ArrayList<Note> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        editText=findViewById(R.id.edittext);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList.clear();
        noteAdapter=new NoteAdapter(arrayList);
        recyclerView.setAdapter(noteAdapter);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(MainActivity.this,EditNote.class);
//                startActivity(i);
//                finish();
//
//            }
//        });


        final DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();

        databaseReference.child("Notes").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Note note1=dataSnapshot.getValue(Note.class);
                arrayList.add(note1);
                noteAdapter.notifyDataSetChanged();


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


    }
}


