package com.tictacpaw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

/**
* @author Petroula
*
*/

public class InstructionsActivity extends Activity implements OnGestureListener {

	GestureDetector detector;
	
	@SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.instructions_screen);
    	
    	detector = new GestureDetector(this);
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
				
		if(e1.getX()<e2.getX()) {			
			/** Changes back to the welcome screen */  	
       	    Intent changeView = new Intent(getApplicationContext(), WelcomeActivity.class);
			startActivity(changeView);
			return true;
		}
		return false;
	}
	
	public boolean onTouchEvent(MotionEvent ev) {
		return detector.onTouchEvent(ev);	
	}
}
