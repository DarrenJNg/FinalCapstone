package com.example.pineapple.listview;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Map;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences shared;
    private SharedPreferences.Editor editor;

    private String subject;
    private String dueDate;
    private String details;

    private  ArrayList<String> editTasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // String[] tasks = {"Homework", "Homework2","No", "Yes", "Why isn't this working?"};

        /*
        Intent intent = getIntent();
        String message = intent.getStringExtra(editTasksPage.EXTRA_MESSAGE);
        */

        //editTasks.add(message);

        shared = PreferenceManager.getDefaultSharedPreferences(this);
        editor = shared.edit();


        Map<String, ?> allElements = shared.getAll();
        for(Map.Entry entry : allElements.entrySet()) {

            String[] element = entry.getValue().toString().split(";");



            if (element.length <3) {
                continue;
            }
            subject = element[0];
            dueDate = element[1];
            details = element[2];
        }

        editTasks.add(subject);
        editTasks.add(dueDate);
        editTasks.add(details);
       // String[] tasks = new String[editTasks.size()];

        /*
        for(int x=0; x<editTasks.size(); x++){
            tasks[x] = editTasks.get(x);
        }
*/


        //needs an adapter to transfer String[] to ListView
        ListAdapter adapter = new CustomAdapter(this, editTasks);
        //initializes the ListView
        ListView ListyViewy = (ListView) findViewById(R.id.ListyViewy);
        //sets the adapter
        ListyViewy.setAdapter(adapter);

        //allows user to click on each element in ListView
        ListyViewy.setOnItemClickListener(
                //listen for user click
                new AdapterView.OnItemClickListener(){
                    @Override
                    //when any element is clicked
                    public void onItemClick(AdapterView<?>parent, View view, int position, long id){
                        //name of element clicked will be stored in 'assignment'
                        String assignment = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, assignment, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void editTasksList(View view) {
        Intent intent = new Intent(this, editTasksPage.class);
        startActivity(intent);
    }
}
