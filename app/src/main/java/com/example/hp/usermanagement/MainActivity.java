package com.example.hp.usermanagement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_userid,et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_userid=(EditText)findViewById(R.id.et_userid);
        et_password=(EditText)findViewById(R.id.et_password);
    }
    public void regis(View v)
    {
        Intent I=new Intent(this,Registration.class);
        startActivity(I);
    }
    public void login(View v)
    {
        if(et_userid.getText().toString().isEmpty())
        {
            et_userid.requestFocus();
            et_userid.setError("empty");
        }
        else
        {
            if(et_password.getText().toString().isEmpty())
            {
                et_password.requestFocus();
                et_password.setError("empty");
            }
            else
            {
                String userid=et_userid.getText().toString().trim();
                String password=et_password.getText().toString().trim();
                MyDatabase myDatabase=new MyDatabase(this);
                SQLiteDatabase db=myDatabase.getWritableDatabase();
                String query="select * from userinfo where emailaddress='"+userid+"'and password='"+password+"'";
                Cursor c=db.rawQuery(query,null);
                Boolean res=c.moveToFirst();
                if(res)
                {
                   // Toast.makeText(MainActivity.this, "Valid user", Toast.LENGTH_SHORT).show();
                    Intent I=new Intent(this,WelcomeActivity.class);
                    I.putExtra("userid",userid);
                    startActivity(I);

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid user", Toast.LENGTH_SHORT).show();
                }

            }
        }

    }
}
