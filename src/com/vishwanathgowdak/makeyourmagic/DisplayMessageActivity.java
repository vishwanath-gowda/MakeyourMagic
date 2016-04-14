package com.vishwanathgowdak.makeyourmagic;

import com.example.example.R;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class DisplayMessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
       Intent intent = getIntent();
       TextView tv = (TextView)findViewById(R.id.textView1);
       String message  = intent.getExtras().getString("EXTRA_MESSAGE");
       String language  = intent.getExtras().getString("LANG");
       if(message.equalsIgnoreCase("ji boom baa")){
    	   String slang = Resource.LanguageMap.getSlang(language);
    	   if(slang!=null){
    		   tv.setText(slang);
    	   }
    	   
       }else{
    	   String misTypeText = Resource.LanguageMap.getMisType(language);
    	   if(misTypeText!=null){
    		   tv.setText(misTypeText);
    	   }
       }
       
    
    }
    
}