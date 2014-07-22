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

	Button start;
	TextView textView0;
	GestureDetector detector;
	String mode;
	String selected = "";
	
	
	@SuppressWarnings("deprecation")
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.welcome_screen);
	    	
	    	start = (Button)findViewById(R.id.start);
	    	start.setOnClickListener(this);
		    
	    	detector = new GestureDetector(this);
	    	
		    if (savedInstanceState == null) {
	        	getFragmentManager().beginTransaction()
	        	.add(R.id.container, new PlaceholderFragment()).commit();
	        }
		}   
	
	public void onCheckboxClicked(View v) {
	  
	    CheckBox easy = (CheckBox) findViewById(R.id.easy);
	    CheckBox medium = (CheckBox) findViewById(R.id.medium);
	    CheckBox hard = (CheckBox) findViewById(R.id.hard);    
	    
	    if(v.getId()==R.id.easy) {
	    	mode = "easy";
	        selected = mode;
	        easy.setChecked(true);
	        medium.setChecked(false);
	        hard.setChecked(false);
	      }
	    if(v.getId()==R.id.medium) {
	    	mode = "medium";
	        selected = mode;
	        medium.setChecked(true);
	        easy.setChecked(false);
	        hard.setChecked(false);
	      }
	    if(v.getId()==R.id.hard) {
	    	mode = "hard";
	        selected = mode;
	        hard.setChecked(true);
	        easy.setChecked(false);
	        medium.setChecked(false);
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
		 
		 if(v.getId()==R.id.start) {
			 Intent changeView = new Intent(getApplicationContext(), MainActivity.class);
			 CheckBox medium = (CheckBox) findViewById(R.id.medium);
			 
			 /** Checks if the user started the game without checking any box, thus with the default(medium) mode*/  
			 if(medium.isChecked()) {
				 selected = "medium";
			 }
			 /** Passes the string to the MainActivity */  
			 changeView.putExtra("mode", selected);
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
