package com.vishwanathgowdak.createmagic;

import com.vishwanathgowda.makeyourmagic.*;
import com.vishwanathgowdak.createmagic.util.MagicUtil;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class DisplayMessageActivity extends ActionBarActivity {

	Handler delay ;
	Runnable delayTask;
	private int secondsDelayed = 5;
	RelativeLayout layout;
	//@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);
		layout=(RelativeLayout)findViewById(R.id.displayActivityID);
			
		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
		Intent intent = getIntent();
		TextView tv = (TextView)findViewById(R.id.textView1);
		String message  = intent.getExtras().getString("EXTRA_MESSAGE");
		String language  = intent.getExtras().getString("LANG");
		if(message.equalsIgnoreCase("ji boom baa")){
			String slang = Resource.LanguageMap.getSlang(language);
			int id = MagicUtil.getDrawableResourceID(Resource.LanguageMap.imageSrc(language));
			if(id!=-1){
				layout.setBackgroundResource(id);
			}
			if(slang!=null){
				tv.setText(slang);
				delay=new Handler();
				delayTask = new Delay();
				delay.postDelayed(delayTask, secondsDelayed * 1000);

			}
		}
		else{
			String misTypeText = Resource.LanguageMap.getMisType(language);
			int id = MagicUtil.getDrawableResourceID(Resource.LanguageMap.MisTypeimageSrc(language));
			if(id!=-1){
				layout.setBackgroundResource(id);
			}
			if(misTypeText!=null){
				tv.setText(misTypeText);
			}else{
				tv.setText("Select prefered language");
			}
		}
	}

	@Override
	public void onDestroy(){
		super.onDestroy();
		if(delay!=null && delayTask!=null)
			delay.removeCallbacks(delayTask);
	}

	class Delay implements Runnable{

		@Override
		public void run() {
			startActivity(new Intent(DisplayMessageActivity.this, EndPage.class));
			finish();
		}
	}

}