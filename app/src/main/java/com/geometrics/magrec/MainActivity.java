package com.geometrics.magrec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateFileList();
    }

    private void populateFileList() {
        // Construct the data source
        ArrayList<SurveyFile> arrayOfFiles = SurveyFile.getFiles();
        // Create the adapter to convert the array to views
        CustomFilesAdapter adapter = new CustomFilesAdapter(this, arrayOfFiles);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvFileList);
        listView.setAdapter(adapter);
    }
}

