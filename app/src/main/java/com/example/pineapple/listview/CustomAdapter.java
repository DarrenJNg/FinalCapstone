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

class CustomAdapter extends ArrayAdapter<String> {

    CustomAdapter(Context context, String[] assignments) {
        super(context, R.layout.custom_row, assignments);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //get ready for rendering
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        String singleAssignment = getItem(position);
        TextView text = (TextView) customView.findViewById(R.id.TextView);
        ImageView image = (ImageView) customView.findViewById(R.id.ImageView);

        text.setText(singleAssignment);
        image.setImageResource(R.mipmap.computer_icon);
        return customView;
    }

}
