/**
 * Created by Pineapple on 4/21/18.
 */

package com.example.pineapple.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

class CustomAdapter extends ArrayAdapter<String> {

    ArrayList<String> assignments = new ArrayList<>();


    //changed from String array[] to ArrayList
    CustomAdapter(Context context, ArrayList<String> assignments) {
        super(context, R.layout.custom_row, assignments);
        this.assignments = assignments;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //get ready for rendering



            LayoutInflater inflater = LayoutInflater.from(getContext());
            View customView = inflater.inflate(R.layout.custom_row, parent, false);

            if (position != 0) {
                position = position + 2;
            }

        if(position+2<assignments.size()) {

            String subjectToString = getItem(position);
            String dueDateToString = getItem(position + 1);
            String detailsToString = getItem(position + 2);
            TextView subject = (TextView) customView.findViewById(R.id.Subject);
            TextView dueDate = (TextView) customView.findViewById(R.id.DueDate);
            TextView details = (TextView) customView.findViewById(R.id.Details);
            ImageView image = (ImageView) customView.findViewById(R.id.ImageView);


            subject.setText(subjectToString);
            dueDate.setText(dueDateToString);
            details.setText(detailsToString);
            image.setImageResource(R.mipmap.computer_icon);
        }


            return customView;


    }

}
