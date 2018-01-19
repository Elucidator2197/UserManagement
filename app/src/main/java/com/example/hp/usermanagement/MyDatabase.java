package com.example.hp.usermanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by hp on 20-07-2017.
 */
public class MyDatabase extends SQLiteOpenHelper {
    Context context;
    public MyDatabase(Context context)
    {
        super(context,"DetailsDb",null,1);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table userinfo(name text,age integer,contactno integer,emailaddress text primary key,password text)";
        db.execSQL(query);
        Toast.makeText(context,"Table created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
