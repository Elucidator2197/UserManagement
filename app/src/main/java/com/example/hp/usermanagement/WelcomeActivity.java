package com.example.hp.usermanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent I=getIntent();
        Bundle b=I.getExtras();
        userid=b.getString("userid");
    }
    public void viewprofile(View v)
    {
        Intent I=new Intent(this,ViewProfile.class);
        I.putExtra("userid",userid);
        startActivity(I);
    }
    public void editprofile(View v)
    {
        Intent I=new Intent(this,EditPrifile.class);
        I.putExtra("userid",userid);
        startActivity(I);
    }
}
