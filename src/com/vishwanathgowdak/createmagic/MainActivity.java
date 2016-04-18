package com.vishwanathgowdak.createmagic;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.vishwanathgowda.makeyourmagic.*;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends ActionBarActivity implements OnItemSelectedListener {

	private String langSelected;
	private static boolean isFisrtTime = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
		
		/*
		 * Following lines takes values specified in the string array of strings.xml
		 * and initializes the troll system by invoking Resource class's init method
		 */
		String[] lang = this.getResources().getStringArray(R.array.Language);
		String[] slangs = this.getResources().getStringArray(R.array.Slangs);
		String[] misType = this.getResources().getStringArray(R.array.Mistype);
		String[] imageSrc = this.getResources().getStringArray(R.array.Imagesrc);
		String[] misTypeImageSrc = this.getResources().getStringArray(R.array.MisTypeImagesrc);
		Resource.LanguageMap.init(lang,slangs,misType,imageSrc,misTypeImageSrc);

		/* 
		 * Creates Language selector Spinner
		 */
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setOnItemSelectedListener(this);
		ArrayList<String> langOptions = Resource.LanguageMap.getArrayListofLang();
		langOptions.add(0, "SELECT");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,langOptions );
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		// On selecting a spinner item
		String item = parent.getItemAtPosition(position).toString();
		EditText jiboombaa = (EditText)findViewById(R.id.end_text);
		Button clickMagic = (Button)findViewById(R.id.button1);
		if(!isFisrtTime){
			jiboombaa.setVisibility(View.VISIBLE);
			clickMagic.setVisibility(View.VISIBLE);
		}else{
			jiboombaa.setVisibility(View.GONE);
			clickMagic.setVisibility(View.GONE);
			isFisrtTime = false;
		}
		// Showing selected spinner item
					Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
					langSelected=item;
	}

	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.end_text);
		String message = editText.getText().toString();
		intent.putExtra("LANG", langSelected);
		intent.putExtra("EXTRA_MESSAGE", message);

		startActivity(intent);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {	}
}
