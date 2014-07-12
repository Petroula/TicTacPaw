package com.example.tictacpawfinal;

import android.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends Activity implements OnClickListener {

	Button button15, button16;
	TextView textView0;
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.welcome_screen);
	    	
	    	button15 = (Button)findViewById(R.id.button15);
	    	button16 = (Button)findViewById(R.id.button16);
	    	
	    	button15.setOnClickListener(this);
		    button16.setOnClickListener(this);
		    
		    if (savedInstanceState == null) {
	        	getFragmentManager().beginTransaction()
	        	.add(R.id.container, new PlaceholderFragment()).commit();
	        }
		}   	
	 
	 @Override
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
	    }


	    /**
	     * A placeholder fragment containing a simple view.
	     */
	    public static class PlaceholderFragment extends Fragment {  	
	    	public PlaceholderFragment() {
	    }


	    	@Override
	    	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	    			Bundle savedInstanceState) {
	                View rootView = inflater.inflate(R.layout.fragment_main, container,false);
	                return rootView;
	        }
	     }
	 
	    	
	 @Override
 	public void onClick(View v) {
		 
		 if(v.getId()==R.id.button15) {
			 Intent changeView = new Intent(getApplicationContext(), MainActivity.class);
			 startActivity(changeView);
		 }
 	}
	
 	   	
	    	
}
