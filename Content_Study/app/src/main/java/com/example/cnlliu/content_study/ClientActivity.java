package com.example.cnlliu.content_study;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ClientActivity extends Activity {

    private Button insert = null;
    private Button query = null;
    private String PersonString = "content://com.example.cnlliu.content_study.provider/person";
    private Uri uri = Uri.parse(PersonString);;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        insert = (Button) findViewById(R.id.insert_id);
        query = (Button) findViewById(R.id.query_id);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("name", "lisi");
                values.put("age", 25);
                ClientActivity.this.getContentResolver().insert(uri, values);
                Toast.makeText(ClientActivity.this, "添加完成", Toast.LENGTH_SHORT).show();
            }
        });

        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor;
                cursor =  ClientActivity.this.getContentResolver().query(uri, null, null, null, null);
                System.out.println("cursor cnt is " + cursor.getCount());
                if (cursor.moveToFirst()) {
                    do {
                        System.out.println("string name is  " + cursor.getString(cursor.getColumnIndex("name")));
                    }while (cursor.moveToNext());
                }
            }
        });
    }
}
