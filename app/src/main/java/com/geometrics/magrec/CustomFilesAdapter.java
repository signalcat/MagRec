package com.geometrics.magrec;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by hezhang on 10/19/17.
 */

public class CustomFilesAdapter extends ArrayAdapter<SurveyFile>
{
    public CustomFilesAdapter(Context context, ArrayList<SurveyFile> files) {
        super(context, 0, files);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        // Get the data item for this position
        SurveyFile surveyFile = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_file, parent, false);
        }
        // Lookup view for data population
        TextView tvFileName = (TextView) convertView.findViewById(R.id.tvFileName);
        // Populate the data into the template view using the data object
        tvFileName.setText(surveyFile.fileName);
        // Return the completed view to render on screen
        return convertView;
    }
}
