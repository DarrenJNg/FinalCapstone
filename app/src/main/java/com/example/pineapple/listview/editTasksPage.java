package com.example.pineapple.listview;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Pineapple on 4/23/18.
 */

public class editTasksPage extends AppCompatActivity{

    public EditText purpose;

    private SharedPreferences shared;
    private SharedPreferences.Editor editor;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_tasks_edit);
    }
    public void mathCLicked(View view){
        TextView textView = (TextView) findViewById(R.id.SubjectSelectedView);
        textView.setText("Math Selected");
    }
    public void englishClicked(View view){
        TextView textView = (TextView) findViewById(R.id.SubjectSelectedView);
        textView.setText("English Selected");
    }
    public void scienceClicked(View view){
        TextView textView = (TextView) findViewById(R.id.SubjectSelectedView);
        textView.setText("Science Selected");
    }
    public void historyClicked(View view){
        TextView textView = (TextView) findViewById(R.id.SubjectSelectedView);
        textView.setText("History Selected");
    }
    public void enterCustomClass(View view){
        EditText editText = (EditText) findViewById(R.id.CustomClassInput);
        String customClassInput = editText.getText().toString();
        TextView textView = (TextView) findViewById(R.id.SubjectSelectedView);
        textView.setText(customClassInput + " Selected");
    }
    public void submitTask(View view){
        TextView subject = (TextView) findViewById(R.id.SubjectSelectedView);

        EditText dueDate = (EditText) findViewById(R.id.DueDateInput);
        String dueDateToString = dueDate.getText().toString();

        EditText assignmentDetails = (EditText) findViewById(R.id.AssignmentDetailsInput);
        String assignmentDetailsToString = assignmentDetails.getText().toString();

        if(subject.getText().toString().equals(null)||dueDateToString.equals(null)
                ||assignmentDetailsToString.equals(null)){
            Toast.makeText(editTasksPage.this, "Ensure that all fields are filled", Toast.LENGTH_LONG).show();
        }else {
            String allElements = subject.getText().toString() + ";" +
                    dueDateToString + ";" + assignmentDetailsToString;

            editor.putString(purpose.getText().toString(), allElements);
            editor.commit();


            String retreived = shared.getString(purpose.getText().toString(), "default");

            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
