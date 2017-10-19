package com.geometrics.magrec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ArrayList<String> files = new ArrayList<String>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Populate the file list
        for (int i = 0; i < 20; i++) {
            files.add("file" + Integer.toString(i));
        }

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, files);

        ListView listView = (ListView) findViewById(R.id.lvFileList);
        listView.setAdapter(itemsAdapter);
    }
}
