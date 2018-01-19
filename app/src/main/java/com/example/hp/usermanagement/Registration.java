package com.example.hp.usermanagement;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText et[] = new EditText[5];
    int ids[] = {R.id.et_name, R.id.et_age, R.id.et_contact, R.id.et_emailaddress, R.id.et_passwd};
    String values[] = new String[et.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        for (int i = 0; i < et.length; i++)
        {
            et[i] = (EditText) findViewById(ids[i]);
        }
    }
    public void submit(View v)
    {
        int j;
        for(j=0;j<et.length;j++)
        {
            if(et[j].getText().toString().trim().isEmpty())
            {
                et[j].requestFocus();
                et[j].setError("Empty");
                break;
            }
        }
        if(j==et.length)
        {
            for(j=0;j<et.length;j++)
            {
             values[j]=et[j].getText().toString().trim();
            }
            int age=Integer.parseInt(values[1]);
            long contactn=Long.parseLong(values[2]);
            MyDatabase myDatabase=new MyDatabase(this);
            SQLiteDatabase db=myDatabase.getWritableDatabase();
            String query="insert into userinfo values('"+values[0]+"',"+age+","+contactn+",'"+values[3]+"','"+values[4]+"')";
            db.execSQL(query);
            Toast.makeText(Registration.this, "Resgistration sucessfull", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}