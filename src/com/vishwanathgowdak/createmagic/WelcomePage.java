package com.vishwanathgowdak.createmagic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.vishwanathgowdak.gen.*;

public class WelcomePage extends Activity implements OnItemSelectedListener {
	

    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.startpage);
        AnimationDrawable ad = (AnimationDrawable) getResources().getDrawable(R.drawable.myframebyframeanimation);
    	View iv1 = (View) findViewById(R.id.welcomeView);
    	iv1.setBackgroundDrawable(ad);
		ad.start();
		
		int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
                public void run() {
                        startActivity(new Intent(WelcomePage.this, MainActivity.class));
                        finish();
                }
        }, secondsDelayed * 5000);
        
    }
    
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       // On selecting a spinner item
       // Showing selected spinner item
    }


    public void sendMessage(View view) {
    	Intent intent = new Intent(this, MainActivity.class);
    	  
    	  startActivity(intent);
    	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

		
	}

}
