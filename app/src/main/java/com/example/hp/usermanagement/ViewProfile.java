package com.example.hp.usermanagement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ViewProfile extends AppCompatActivity {

    TextView tvname,tvcontactno,tvemailaddress,tvage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        tvname=(TextView)findViewById(R.id.tvname);
        tvage=(TextView)findViewById(R.id.tvage);
        tvcontactno=(TextView)findViewById(R.id.tvcontactno);
        tvemailaddress=(TextView)findViewById(R.id.tvemailaddress);
        Intent I=getIntent();
        Bundle b=I.getExtras();
        String userid=b.getString("userid");
        MyDatabase myDatabase =new MyDatabase(this);
        SQLiteDatabase db=myDatabase.getWritableDatabase();
        String query="select name,age,contactno,emailaddress from userinfo where emailaddress='"+userid+"'";
        Cursor c=db.rawQuery(query,null);
        Boolean res=c.moveToFirst();
        if(res)
        {
            tvname.setText("Nmae : "+c.getString(0));
            tvage.setText("Age : "+c.getInt(1));
            tvcontactno.setText("Contactno : "+c.getLong(2));
            tvemailaddress.setText("Email address : "+c.getString(3));
        }
        else
        {
            Toast.makeText(ViewProfile.this, "recorde not found", Toast.LENGTH_SHORT).show();
        }
    }
    public void back(View v)
    {
        finish();
    }
}
