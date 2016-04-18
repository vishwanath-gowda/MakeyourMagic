package com.vishwanathgowdak.makeyourmagic;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

import com.vishwanathgowda.makeyourmagic.*;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class EndPage extends ActionBarActivity implements OnItemSelectedListener {
	InterstitialAd mInterstitialAd;

    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_actvity);
        AdView mAdView = (AdView) findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8591460773245129/4371594094");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                            }
        });

        requestNewInterstitial();
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
        
        AnimationDrawable ad = (AnimationDrawable) getResources().getDrawable(R.drawable.lastpage);
    	View iv1 = (View) findViewById(R.id.endView);
    	iv1.setBackgroundDrawable(ad);
		ad.start();

		TextView tvlast = (TextView)findViewById(R.id.endTextView);
		tvlast.setText(getString(R.string.fool_message));
		
        
    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }
    
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       // On selecting a spinner item
       // Showing selected spinner item
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
    
    public void sendMessage(View view) {
    	Intent intent = new Intent(this, MainActivity.class);
    	  
    	  startActivity(intent);
    	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		
		
	}

}
