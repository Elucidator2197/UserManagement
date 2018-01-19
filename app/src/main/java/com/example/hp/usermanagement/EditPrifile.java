package com.example.hp.usermanagement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditPrifile extends AppCompatActivity {

    String userid;
    EditText etname,etage,etcontactno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_prifile);
        etname=(EditText)findViewById(R.id.etname);
        etage=(EditText)findViewById(R.id.etage);
        etcontactno=(EditText)findViewById(R.id.etcontactno);
        Intent I=getIntent();
        Bundle b=I.getExtras();
        userid=b.getString("userid");
        MyDatabase myDatabase=new MyDatabase(this);
        SQLiteDatabase db=myDatabase.getWritableDatabase();
        String query="select name,age,contactno from userinfo where emailaddress='"+userid+"'";
        Cursor c=db.rawQuery(query,null);
        Boolean res=c.moveToFirst();
        if(res)
        {
            etname.setText(c.getString(0));
            etage.setText(c.getInt(1)+"");
            etcontactno.setText(c.getLong(2)+"");
        }

    }
    public void edit(View v)
    {
        String name=etname.getText().toString().trim();
        int age=Integer.parseInt(etage.getText().toString().trim());
        long contactno=Long.parseLong(etcontactno.getText().toString().trim());
        MyDatabase myDatabase=new MyDatabase(this);
        SQLiteDatabase db=myDatabase.getWritableDatabase();
        String query="update userinfo set name='"+name+"',age="+age+",contactno="+contactno+" where emailaddress='"+userid+"'";
        db.execSQL(query);
        Toast.makeText(EditPrifile.this, "Updated", Toast.LENGTH_SHORT).show();
        finish();

    }
}
