package com.example.tictacpawfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
* @author Petroula
*
*/


public class InstructionsActivity extends Activity implements OnClickListener, OnGestureListener {

	Button button17;
	TextView textView000;
	GestureDetector detector;
	
	
	@SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.instructions_screen);
	    
    	button17 = (Button)findViewById(R.id.button17);	
     	button17.setOnClickListener(this);
     	
     	detector = new GestureDetector(this);
	}


	@Override
	public void onClick(View v) {
		Intent changeView = new Intent(getApplicationContext(), WelcomeActivity.class);
		startActivity(changeView);	 
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
		
		 Intent changeToInstructions = getIntent();
		
		if(e1.getX()<e2.getX() && changeToInstructions.getIntExtra("recognizeScreen", 0)==2) {			
			/** Changes back to the welcome screen */  	
       	    Intent changeView = new Intent(getApplicationContext(), WelcomeActivity.class);
			startActivity(changeView);
			return true;
		} else if(e1.getX()<e2.getX() && changeToInstructions.getIntExtra("recognizeScreen", 0)==1) {
			/** Changes back to the main screen */  	
       	    Intent changeView = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(changeView);
			return true;
		}
		return false;
	}
	
	public boolean onTouchEvent(MotionEvent ev) {
		return detector.onTouchEvent(ev);	
	}
}
