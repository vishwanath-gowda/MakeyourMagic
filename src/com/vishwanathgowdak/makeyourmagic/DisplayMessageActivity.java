package com.vishwanathgowdak.makeyourmagic;

import com.example.example.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class DisplayMessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
       Intent intent = getIntent();
       TextView tv = (TextView)findViewById(R.id.textView1);
       String incoming  = intent.getExtras().getString("EXTRA_MESSAGE");
       if( incoming.equalsIgnoreCase("ji boom baa")){
    	   tv.setText("Le ninouna, app nal enthad le magic");
       }else{
       tv.setText(intent.getExtras().getString("EXTRA_MESSAGE"));
       
       }
    
    }
    
}