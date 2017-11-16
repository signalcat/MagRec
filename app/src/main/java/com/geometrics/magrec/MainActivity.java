package com.geometrics.magrec;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.File;
import java.sql.Array;
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

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the toolbar to act as the ActionBar
        setSupportActionBar(toolbar);

    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        // Build project list
        ArrayList projectNameList = new ArrayList<>();
        projectNameList.add("Project1");
        projectNameList.add("Project2");
        projectNameList.add("Project3");

        MenuItem item = menu.findItem(R.id.miProjects);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        // Construct array adapter
        ArrayAdapter<String> projectNameAdapter = new ArrayAdapter<String>(
                getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, projectNameList);

        // Specify the layout to use the list
        projectNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(projectNameAdapter);

        populateFileList();

        return true;
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

