package com.codingblocks.trentiondevelopment;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button save;
    EditText editText;
    NotificationManager notificationManager;
    String channel_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=findViewById(R.id.send);
        editText=findViewById(R.id.edittext);
        channel_id="CHANNEL";
        notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        final DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();

        NotificationChannel notificationChannel= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(channel_id, "defult", NotificationManager.IMPORTANCE_DEFAULT);

            notificationManager.createNotificationChannel(notificationChannel);
        }
        Log.e("TAGGGGGG",editText.getText().toString());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=editText.getText().toString();
                Calendar c = Calendar.getInstance();

                int seconds = c.get(Calendar.SECOND);
                int minutes = c.get(Calendar.MINUTE);
                int hour = c.get(Calendar.HOUR);
                String time = hour + ":" + minutes+":"+seconds;


                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);
                String date = day + "/" + month + "/" + year;

// Assuming that you need date and time in a separate
// textview named txt_date and txt_time.

                final Note note=new Note(str,time,date);
                databaseReference.child("Notes").push().setValue(note);
                Intent intent=new Intent(getBaseContext(),Recyclerviewclass.class);

                PendingIntent pendingIntent=PendingIntent.getActivity(getBaseContext(),111,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                Notification simplenotifiction =new NotificationCompat.Builder(MainActivity.this,channel_id).
                        setSmallIcon(R.mipmap.ic_launcher).setContentTitle("notification").setContentText(editText.getText().toString())

                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent).build();

                notificationManager.notify(123,simplenotifiction);

            }
        });





    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_notification:
                Intent intent=new Intent(MainActivity.this,Recyclerviewclass.class);
                startActivity(intent);
                finish();
                break;

        }
        return false;
    }
}
