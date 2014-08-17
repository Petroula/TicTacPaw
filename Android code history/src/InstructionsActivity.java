package com.example.tictacpawfinal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

/**
* @author Petroula
*
*/

public class InstructionsActivity extends Activity implements OnGestureListener {

	GestureDetector detector;
	AnimationDrawable animationDraw2;
	
	
	@SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.instructions_screen);
     	
    	/** Adds instructions in the Instructions Screen in the form of animation */ 
    	ImageView instructionsV = (ImageView) findViewById(R.id.instructionsView);
    	instructionsV.setBackgroundResource(R.drawable.instructions);
    	animationDraw2 = (AnimationDrawable) instructionsV.getBackground();
    	animationDraw2.start();
    		
     	detector = new GestureDetector(this);
     	
     	Toast.makeText(getApplicationContext(), "Swipe to go back", Toast.LENGTH_LONG).show();
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
