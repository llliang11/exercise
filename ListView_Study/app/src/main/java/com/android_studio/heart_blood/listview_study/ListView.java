package com.android_studio.heart_blood.listview_study;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;


public class ListView extends ListActivity {
    private Cursor audioCursor;
    private int audioCnt;
    private List<String> titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        titles = new ArrayList<String>();
        audioCursor = this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        audioCnt = audioCursor.getCount();
        if (audioCursor.moveToFirst()) {
            do {
                titles.add(audioCursor.getString(audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)));
            }while (audioCursor.moveToNext());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles);
        setListAdapter(adapter);
    }

}
