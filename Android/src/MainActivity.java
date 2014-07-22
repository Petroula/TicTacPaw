package com.example.tictacpawfinal;

import java.util.Random;

import android.app.Activity;
import android.content.*;
import android.os.*;
import android.preference.PreferenceManager;
import android.view.*;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.*;
import android.widget.*;

/**
* @author Petroula
*
*/

public class MainActivity extends Activity implements OnClickListener, OnGestureListener {
	
	Random rand = new Random();
//	int computer;
	Button[][] buttons=new Button[3][3];
	int x, y;
	Button newGame, reset;
    TextView textView1, textView2, textView3;
    int count=1;
    Chronometer seconds;
    GestureDetector detector;
    int i, j;
    int limit;
	
    
    /** Checks if the main screen should be displayed after a swipe from the instructions page */
    public static int recognizeScreen =0;
    
	@SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
    	
	    for (x=0; x<3; x++) {
			for (y=0; y<3; y++) {
				buttons[x][y] = new Button(this);
				buttons[x][y].setOnClickListener(this);
			}
	    }
        
	    buttons[0][0] = (Button)findViewById(R.id.button1);
    	buttons[0][1] = (Button)findViewById(R.id.button2);
    	buttons[0][2] = (Button)findViewById(R.id.button3);
    	buttons[1][0] = (Button)findViewById(R.id.button4);
    	buttons[1][1] = (Button)findViewById(R.id.button5);
    	buttons[1][2] = (Button)findViewById(R.id.button6);
    	buttons[2][0] = (Button)findViewById(R.id.button7);
    	buttons[2][1] = (Button)findViewById(R.id.button8);
    	buttons[2][2] = (Button)findViewById(R.id.button9);
    	
    	newGame = (Button)findViewById(R.id.newGame);
    	newGame.setOnClickListener(this);
	    reset = (Button)findViewById(R.id.reset);
	    reset.setOnClickListener(this);
    	
        
        seconds = (Chronometer) findViewById(R.id.chronometer);
    	seconds.start(); 
    
    	detector = new GestureDetector(this);
	    
    }
    
	
    @Override
    public void onClick(View v) {
	
    	
    	for (x=0; x<3; x++) {
			for (y=0; y<3; y++) {
				if (buttons[x][y].isPressed() && buttons[x][y].isEnabled()) {
					
					/** Assigns an X to the button pressed */  	 	
    		        buttons[x][y].setText("X");
    		        buttons[x][y].setEnabled(false);
                    checkEnd();
                    if(checkWin()==false && checkLose()==false && checkTie()==false) {
                    	vsUser();
                    }
                 }
    	     }
         }
    	
    	if (v.getId()==R.id.newGame) {
    		newGame();
      } else if (v.getId()==R.id.reset) {
   	  
    	  /** Changes back to the welcome screen */
    	  Intent changeView = new Intent(getApplicationContext(), WelcomeActivity.class);
    	  startActivity(changeView);
      }
    }
    
    
    /** This method handles the computer's turn by randomly 
     * choosing between the available options */  	
    public void vsUser() {
    	
    	
    	/** Checks the availability of the randomly chosen button and assigns an O to it */
    	
    	if (count==1) {
    	//	computer =rand.nextInt(9);
    		i = rand.nextInt(3);
    		j = rand.nextInt(3);
    		if (buttons[i][j].isEnabled() ) {
    			buttons[i][j].setText("O");
    			buttons[i][j].setEnabled(false);
    		} else {
    			vsUser();
    		}   		    		
    	} else if (count==2) {
    	//	computer =rand.nextInt(11);
    		i = rand.nextInt(3);
    		j = rand.nextInt(4);
    		if (buttons[i][j].isEnabled()) {
    			buttons[i][j].setText("O");
    			buttons[i][j].setEnabled(false);
    		} else {
    			vsUser();
    		}   		
    	}
        checkEnd();
     }
    
    
    /** Checks for win, lose or tie situation */  	 
    public void checkEnd() {
    	
    	long timeMillis;
    	int timeSeconds;
    	
    	textView2 = (TextView) findViewById(R.id.textView2);
    	textView3 = (TextView) findViewById(R.id.textView3);
    	
    	
    	/** Checks which box was selected and adjusts the limit */
    	Intent changeView = getIntent();        	
    	if(changeView.getStringExtra("mode").contains("easy")) {
    		limit = 10;
    	} else if (changeView.getStringExtra("mode").contains("medium")) {
    		limit = 7;
    	} else if (changeView.getStringExtra("mode").contains("hard")) {
    		limit = 5;
    	}
    	
    	
        if (checkWin()==true) {
        	endGame();
        	seconds.stop();
         	     	         	
        	timeMillis = SystemClock.elapsedRealtime() - seconds.getBase();
        	
        	/** Counts the seconds it took to win the game */ 
        	timeSeconds = (int) (timeMillis / 1000);    	
        	
        	/** Stores the quickest time so far*/     	
        	if(!textView3.getText().toString().isEmpty()) {
        		SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
            	if(timeSeconds<shared.getInt("Quickest Paw", timeSeconds)){          		
            		SharedPreferences.Editor sharedEditor = shared.edit();
                    sharedEditor.putInt("Quickest Paw", timeSeconds);
                    sharedEditor.commit();
                    textView3.setText("Quickest Paw is approximately: " + Integer.toString(timeSeconds) + " seconds");
            	}
        	} else if (textView3.getText().toString().isEmpty()) {
        		SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
        		SharedPreferences.Editor sharedEditor = shared.edit();
                sharedEditor.putInt("Quickest Paw", timeSeconds);
                sharedEditor.commit();
                textView3.setText("Quickest Paw is approximately: " + Integer.toString(timeSeconds) + " seconds");
        	}
        	

            
        	
        	if(timeSeconds<limit) {
               textView2.setText("You won!");
             //  count++;               
        	} else {
        		textView2.setText("Too slow, try again!");
        	}
     //       if (count==3) {
     //       	textView2.setText("You won all levels!");
     //       	count=1;          	
     //       }           
            
        } else if (checkLose()==true) {
        	endGame();
        	seconds.stop();
            textView2.setText("You lost!");
            count=1;           
        } else if (checkTie()==true) {
            endGame();
            seconds.stop();
            textView2.setText("It's a tie!");
        }
    }
    
    
    public boolean checkWin() {
    	
    	if ((buttons[0][0].getText()=="X" && buttons[0][1].getText()=="X" && buttons[0][2].getText()=="X")
				|| (buttons[1][0].getText()=="X" && buttons[1][1].getText()=="X" && buttons[1][2].getText()=="X") 
			    || (buttons[2][0].getText()=="X" && buttons[2][1].getText()=="X" && buttons[2][2].getText()=="X")
			    
			    || (buttons[0][0].getText()=="X" && buttons[1][0].getText()=="X" && buttons[2][0].getText()=="X")
			    || (buttons[0][1].getText()=="X" && buttons[1][1].getText()=="X" && buttons[2][1].getText()=="X")
			    || (buttons[0][2].getText()=="X" && buttons[1][2].getText()=="X" && buttons[2][2].getText()=="X")
			    
			    || (buttons[0][0].getText()=="X" && buttons[1][1].getText()=="X" && buttons[2][2].getText()=="X")
			    || (buttons[0][2].getText()=="X" && buttons[1][1].getText()=="X" && buttons[2][0].getText()=="X")) {
			
			    
	//			/** Level 2 - extra checks */  	
   //             || (buttons[0][1].getText().equals("X") && buttons[0][2].getText().equals("X") && buttons[0][3].getText().equals("X"))
  //              || (buttons[1][1].getText().equals("X") && buttons[1][2].getText().equals("X") && buttons[1][3].getText().equals("X"))
  //              || (buttons[2][1].getText().equals("X") && buttons[2][2].getText().equals("X") && buttons[2][3].getText().equals("X"))
               
  //              || (buttons[0][3].getText().equals("X") && buttons[1][3].getText().equals("X") && buttons[2][3].getText().equals("X"))
                
 //               || (buttons[0][1].getText().equals("X") && buttons[1][2].getText().equals("X") && buttons[2][3].getText().equals("X"))
 //               || (buttons[0][3].getText().equals("X") && buttons[1][2].getText().equals("X") && buttons[2][1].getText().equals("X"))) {
    		return true;
    	}
    	return false;
     }
    
    
    public boolean checkLose() {
    	
    	if ((buttons[0][0].getText()=="O" && buttons[0][1].getText()=="O" && buttons[0][2].getText()=="O")
				|| (buttons[1][0].getText()=="O" && buttons[1][1].getText()=="O" && buttons[1][2].getText()=="O") 
			    || (buttons[2][0].getText()=="O" && buttons[2][1].getText()=="O" && buttons[2][2].getText()=="O")
			    
			    || (buttons[0][0].getText()=="O" && buttons[1][0].getText()=="O" && buttons[2][0].getText()=="O")
			    || (buttons[0][1].getText()=="O" && buttons[1][1].getText()=="O" && buttons[2][1].getText()=="O")
			    || (buttons[0][2].getText()=="O" && buttons[1][2].getText()=="O" && buttons[2][2].getText()=="O")
			    
			    || (buttons[0][0].getText()=="O" && buttons[1][1].getText()=="O" && buttons[2][2].getText()=="O")
			    || (buttons[0][2].getText()=="O" && buttons[1][1].getText()=="O" && buttons[2][0].getText()=="O")) {
			
//				/** Level 2 - extra checks */  	
//                || (buttons[0][1].getText().equals("O") && buttons[0][2].getText().equals("O") && buttons[0][3].getText().equals("O"))
//                || (buttons[1][1].getText().equals("O") && buttons[1][2].getText().equals("O") && buttons[1][3].getText().equals("O"))
//                || (buttons[2][1].getText().equals("O") && buttons[2][2].getText().equals("O") && buttons[2][3].getText().equals("O"))
                
//                || (buttons[0][3].getText().equals("O") && buttons[1][3].getText().equals("O") && buttons[2][3].getText().equals("O"))
                
//                || (buttons[0][1].getText().equals("O") && buttons[1][2].getText().equals("O") && buttons[2][3].getText().equals("O"))
//                || (buttons[0][3].getText().equals("O") && buttons[1][2].getText().equals("O") && buttons[2][1].getText().equals("O"))) {
    		return true;
    	}
    	return false;
    }



    public boolean checkTie() {

    	if (count==1) {
    		if (checkWin()==false && checkLose()==false && (!buttons[0][0].isEnabled() && !buttons[0][1].isEnabled() &&
    				!buttons[0][2].isEnabled() && !buttons[1][0].isEnabled() && !buttons[1][1].isEnabled() && !buttons[1][2].isEnabled() 
    				&& !buttons[2][0].isEnabled() && !buttons[2][1].isEnabled() && !buttons[2][2].isEnabled())) {
    			return true;
    		 }
    	}
		return false;		
    }



    public void endGame() {
    	
    	for (x=0; x<3; x++) {
			for (y=0; y<3; y++) {
				buttons[x][y].setEnabled(false);
			}
	    }
    }   
    


    public void newGame() {
    	
    	/** Resets the timer */  	
    	seconds.setBase(SystemClock.elapsedRealtime());
    	seconds.start();
    	
    	textView1 = (TextView) findViewById(R.id.textView1);
    	textView2 = (TextView) findViewById(R.id.textView2);
    	
    	for (x=0; x<3; x++) {
			for (y=0; y<3; y++) {
				buttons[x][y].setEnabled(true);
				buttons[x][y].setText("");
			}
	    }
    	
    	textView1.setText("Level " + count);
    	textView2.setText(""); 
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
			recognizeScreen=1;
			
       	    Intent changeToInstructions = new Intent(getApplicationContext(), InstructionsActivity.class);    
       	    /** Passes the new value to the other activity */ 
       	    changeToInstructions.putExtra("recognizeScreen", 1);
			startActivity(changeToInstructions);		
			return true;
		}
		return false;
	}

	public boolean onTouchEvent(MotionEvent ev) {
		return detector.onTouchEvent(ev);	
	}
	

}

