package com.vishwanathgowdak.makeyourmagic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.example.example.R;


public class MainActivity extends ActionBarActivity implements OnItemSelectedListener {
	
	private String langSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        String[] lang = this.getResources().getStringArray(R.array.Language);
        String[] slangs = this.getResources().getStringArray(R.array.Slangs);
        String[] misType = this.getResources().getStringArray(R.array.Mistype);
        Resource.LanguageMap.init(lang,slangs,misType);
        
     // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        
     // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Resource.LanguageMap.getArrayListofLang());
        
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }
    
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       // On selecting a spinner item
       String item = parent.getItemAtPosition(position).toString();
       
       // Showing selected spinner item
       Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
       langSelected=item;
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
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	  EditText editText = (EditText) findViewById(R.id.end_text);
    	  String message = editText.getText().toString();
    	  intent.putExtra("LANG", langSelected);
    	  intent.putExtra("EXTRA_MESSAGE", message);
    	  
    	  startActivity(intent);
    	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}
