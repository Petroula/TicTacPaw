package com.example.tictacpawfinal;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.*;
import android.widget.*;

/**
* @author Petroula
*
*/

public class WelcomeActivity extends Activity implements OnClickListener, OnGestureListener {

	Button button15, button16;
	TextView textView0;
	GestureDetector detector;
	
	 @SuppressWarnings("deprecation")
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.welcome_screen);
	    	
	    	button15 = (Button)findViewById(R.id.button15);	 
	    	button16 = (Button)findViewById(R.id.button16);
	    	
	    	button15.setOnClickListener(this);
	    	button16.setOnClickListener(this);
		    
	    	detector = new GestureDetector(this);
	    	
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
		 } else if(v.getId()==R.id.button16) {
			 Intent changeView = new Intent(getApplicationContext(), InstructionsActivity.class);
			 startActivity(changeView);	     
		   
		 }
		 
		 
		 
 	}

	@Override
	public boolean onDown(MotionEvent e) {
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		if(e1.getX()>e2.getX()) {		
			MainActivity.recognizeScreen=2;
			/** Changes to Instructions screen */  	
       	    Intent changeToInstructions = new Intent(getApplicationContext(), InstructionsActivity.class);
         	changeToInstructions.putExtra("recognizeScreen", 2);
			startActivity(changeToInstructions);
			return true;
		}
		return false;
	}
	
	public boolean onTouchEvent(MotionEvent ev) {
		return detector.onTouchEvent(ev);	
	}   	
	    	
}
