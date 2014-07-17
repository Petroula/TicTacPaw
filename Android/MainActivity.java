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
    int computer;
    Button button01, button02, button03, button04, button05, button06, button07, button08, button09, button10,
    button11, button12, button13, button14;
    TextView textView1, textView2, textView3;
    int count=1;
    Chronometer seconds;
    GestureDetector detector;
    
    /** Checks if the main screen should be displayed after a swipe from the instructions page */
    public static int recognizeScreen =0;
    
    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
    	
    	button01 = (Button)findViewById(R.id.button1);
	button02 = (Button)findViewById(R.id.button2);
    	button03 = (Button)findViewById(R.id.button3);
     	button04 = (Button)findViewById(R.id.button4);
    	button05 = (Button)findViewById(R.id.button5);
    	button06 = (Button)findViewById(R.id.button6);
    	button07 = (Button)findViewById(R.id.button7);
	button08 = (Button)findViewById(R.id.button8);
	button09 = (Button)findViewById(R.id.button9);
	button10 = (Button)findViewById(R.id.button10);
        button11 = (Button)findViewById(R.id.button11);
	button12 = (Button)findViewById(R.id.button12);
	button13 = (Button)findViewById(R.id.button13);
	button14 = (Button)findViewById(R.id.button14);

        button01.setOnClickListener(this);
	button02.setOnClickListener(this);
        button03.setOnClickListener(this);
        button04.setOnClickListener(this);
        button05.setOnClickListener(this);
        button06.setOnClickListener(this);
        button07.setOnClickListener(this);
        button08.setOnClickListener(this);
        button09.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
        
        button11.setVisibility(View.INVISIBLE);
        button12.setVisibility(View.INVISIBLE);
        button13.setVisibility(View.INVISIBLE); 
        
        seconds = (Chronometer) findViewById(R.id.chronometer);
    	seconds.start(); 
    
    	detector = new GestureDetector(this);
    }
    
   
    @Override
    public void onClick(View v) {
	
    	
    	/** Checks which button was pressed and assigns an X to it */  	
    	
    	if(v.getId()==R.id.button1 && button01.isEnabled()) {
    		button01.setText("X");
            button01.setEnabled(false);
            checkEnd();
            if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
            		|| button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
                    || button09.isEnabled() || button11.isEnabled() || button12.isEnabled() || button13.isEnabled()) {
            	vsUser();
            }
         } else if (v.getId()==R.id.button2 && button02.isEnabled()) {
        	 button02.setText("X");
             button02.setEnabled(false);
             checkEnd();
             if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
                    || button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
                    || button09.isEnabled() || button11.isEnabled() || button12.isEnabled() || button13.isEnabled()) {
                vsUser();
            }
         } else if (v.getId()==R.id.button3 && button03.isEnabled()) {
        	 button03.setText("X");
             button03.setEnabled(false);
             checkEnd();
             if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
                    || button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
                    || button09.isEnabled() || button11.isEnabled() || button12.isEnabled() || button13.isEnabled()) {
                vsUser();
            }
         } else if (v.getId()==R.id.button4 && button04.isEnabled()) {
        	 button04.setText("X");
             button04.setEnabled(false);
             checkEnd();
             if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
                    || button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
                    || button09.isEnabled() || button11.isEnabled() || button12.isEnabled() || button13.isEnabled()) {
                vsUser();
            }
         } else if (v.getId()==R.id.button5 && button05.isEnabled()) {
        	 button05.setText("X");
             button05.setEnabled(false);
             checkEnd();
             if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
            		 || button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
                     || button09.isEnabled() || button11.isEnabled() || button12.isEnabled() || button13.isEnabled()) {
                vsUser();
            }
         } else if (v.getId()==R.id.button6 && button06.isEnabled()) {
        	 button06.setText("X");
             button06.setEnabled(false);
             checkEnd();
             if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
              		 || button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
                     || button09.isEnabled() || button11.isEnabled() || button12.isEnabled() || button13.isEnabled()) {
             	 vsUser();
            }
         } else if (v.getId()==R.id.button7 && button07.isEnabled()) {
        	 button07.setText("X");
             button07.setEnabled(false);
             checkEnd();
             if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
            		 || button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
                     || button09.isEnabled() || button11.isEnabled() || button12.isEnabled() || button13.isEnabled()) {
              	 vsUser();
            }
         } else if (v.getId()==R.id.button8 && button08.isEnabled()) {
        	 button08.setText("X");
             button08.setEnabled(false);
             checkEnd();
             if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
            		 || button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
                     || button09.isEnabled() || button11.isEnabled() || button12.isEnabled() || button13.isEnabled()) {
              	 vsUser();
            }
         } else if (v.getId()==R.id.button9 && button09.isEnabled()) {
        	 button09.setText("X");
             button09.setEnabled(false);
             checkEnd();
             if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
            		 || button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
                     || button09.isEnabled() || button11.isEnabled() || button12.isEnabled() || button13.isEnabled()) {
                 vsUser();
            }
         } else if (v.getId()==R.id.button11 && button11.isEnabled()) {
        	 button11.setText("X");
             button11.setEnabled(false);
             checkEnd();
             if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
            		 || button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
                     || button09.isEnabled() || button11.isEnabled() || button12.isEnabled() || button13.isEnabled()) {
                 vsUser();
            }   
         } else if (v.getId()==R.id.button12 && button12.isEnabled()) {
        	 button12.setText("X");
             button12.setEnabled(false);
             checkEnd();
             if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
            		 || button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
                     || button09.isEnabled() || button11.isEnabled() || button12.isEnabled() || button13.isEnabled()) {
                 vsUser();
            } 
         } else if (v.getId()==R.id.button13 && button13.isEnabled()) {
        	 button13.setText("X");
             button13.setEnabled(false);
             checkEnd();
             if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
            		 || button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
                     || button09.isEnabled() || button11.isEnabled() || button12.isEnabled() || button13.isEnabled()) {
                 vsUser();
            }       
         } else if (v.getId()==R.id.button10) {
        	 newGame();
         } else if (v.getId()==R.id.button14) {
        	 
        	 /** Changes back to the welcome screen */  	
        	 Intent changeView = new Intent(getApplicationContext(), WelcomeActivity.class);
			 startActivity(changeView);
         }
    }
   
    
    
    /** This method handles the computer's turn by randomly 
     * choosing between the available options */  	
    public void vsUser() {
  
    	
    	/** Random numbers according to which level the user currently is*/  	
    	if (count==1) {
    		computer =rand.nextInt(9);
    	} else if (count==2) {
    		computer =rand.nextInt(11);
    	}
    	
    	
    	/** Checks the randomly chosen number and the availability of the button and assigns an O to it */  	
    	
    	if (computer==0 && button01.isEnabled()){
        	button01.setText("O");
            button01.setEnabled(false);
        } else if (computer==1 && button02.isEnabled()) {
        	button02.setText("O");
            button02.setEnabled(false);
        } else if (computer==2 && button03.isEnabled()) {
        	button03.setText("O");
            button03.setEnabled(false);
        } else if (computer==3 && button04.isEnabled()) {
        	button04.setText("O");
            button04.setEnabled(false);
        } else if (computer==4 && button05.isEnabled()) {
        	button05.setText("O");
            button05.setEnabled(false);
        } else if (computer==5 && button06.isEnabled()) {
        	button06.setText("O");
            button06.setEnabled(false);
        } else if (computer==6 && button07.isEnabled()) {
        	button07.setText("O");
            button07.setEnabled(false);
        } else if (computer==7 && button08.isEnabled()) {
        	button08.setText("O");
            button08.setEnabled(false);
        } else if (computer==8 && button09.isEnabled()) {
        	button09.setText("O");
            button09.setEnabled(false);
        } else if (computer==9 && button11.isEnabled()) {
        	button11.setText("O");
        	button11.setEnabled(false);
        } else if (computer==10 && button12.isEnabled()) {
        	button12.setText("O");
        	button12.setEnabled(false);
        } else if (computer==11 && button13.isEnabled()) {
        	button13.setText("O");
        	button13.setEnabled(false);	         
        } else {
            vsUser();
        }
        checkEnd();
     }
    
    
    /** Checks for win, lose or tie situation */  	 
    public void checkEnd() {
    	
    	
    	long timeMillis;
    	int timeSeconds;
    	
    	textView2 = (TextView) findViewById(R.id.textView2);
    	textView3 = (TextView) findViewById(R.id.textView3);
    	
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
        	
        	/** Continues to the next level only if time is less than 10 seconds */
        	if(timeSeconds<10) {
               textView2.setText("You won!");
               count++;               
        	} else {
        		textView2.setText("Too slow, try again!");
        	}
            if (count==3) {
            	textView2.setText("You won all levels!");
            	count=1;          	
            }           
            
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
    	
    	if ((button01.getText().equals("X") && button02.getText().equals("X") && button03.getText().equals("X"))
    			|| (button04.getText().equals("X") && button05.getText().equals("X") && button06.getText().equals("X"))
                || (button07.getText().equals("X") && button08.getText().equals("X") && button09.getText().equals("X"))
                
                || (button01.getText().equals("X") && button04.getText().equals("X") && button07.getText().equals("X"))
                || (button02.getText().equals("X") && button05.getText().equals("X") && button08.getText().equals("X"))
                || (button03.getText().equals("X") && button06.getText().equals("X") && button09.getText().equals("X"))
                
                || (button01.getText().equals("X") && button05.getText().equals("X") && button09.getText().equals("X"))
                || (button03.getText().equals("X") && button05.getText().equals("X") && button07.getText().equals("X"))
                
                
    			/** Level 2 - extra checks */  	
                || (button02.getText().equals("X") && button03.getText().equals("X") && button11.getText().equals("X"))
                || (button05.getText().equals("X") && button06.getText().equals("X") && button12.getText().equals("X"))
                || (button08.getText().equals("X") && button09.getText().equals("X") && button13.getText().equals("X"))
                
                || (button11.getText().equals("X") && button12.getText().equals("X") && button13.getText().equals("X"))
                
                || (button02.getText().equals("X") && button06.getText().equals("X") && button13.getText().equals("X"))
                || (button11.getText().equals("X") && button06.getText().equals("X") && button08.getText().equals("X"))) {
    		return true;
    	}
    	return false;
     }
    
    
    public boolean checkLose() {
    	
    	if ((button01.getText()=="O" && button02.getText()=="O" && button03.getText()=="O")
    			|| (button04.getText().equals("O") && button05.getText().equals("O") && button06.getText().equals("O"))
                || (button07.getText().equals("O") && button08.getText().equals("O") && button09.getText().equals("O"))

                || (button01.getText().equals("O") && button04.getText().equals("O") && button07.getText().equals("O"))
                || (button02.getText().equals("O") && button05.getText().equals("O") && button08.getText().equals("O"))
                || (button03.getText().equals("O") && button06.getText().equals("O") && button09.getText().equals("O"))

                || (button01.getText().equals("O") && button05.getText().equals("O") && button09.getText().equals("O"))
                || (button03.getText().equals("O") && button05.getText().equals("O") && button07.getText().equals("O"))
                
    			
    			//level 2 extra checks
                || (button02.getText().equals("O") && button03.getText().equals("O") && button11.getText().equals("O"))
                || (button05.getText().equals("O") && button06.getText().equals("O") && button12.getText().equals("O"))
                || (button08.getText().equals("O") && button09.getText().equals("O") && button13.getText().equals("O"))
                
                || (button11.getText().equals("O") && button12.getText().equals("O") && button13.getText().equals("O"))
                
                || (button02.getText().equals("O") && button06.getText().equals("O") && button13.getText().equals("O"))
                || (button11.getText().equals("O") && button06.getText().equals("O") && button08.getText().equals("O"))) {
    		return true;
    	}	
    	return false;
    }



    public boolean checkTie() {

    	if (count==1) {
    		if (checkWin()==false && checkLose()==false && (!button01.isEnabled() && !button02.isEnabled() &&
    				!button03.isEnabled() && !button04.isEnabled() && !button05.isEnabled() && !button06.isEnabled() 
    				&& !button07.isEnabled() && !button08.isEnabled() && !button09.isEnabled())) {
    			return true;
    		 }
    	} else if (count==2) {
    		if (checkWin()==false && checkLose()==false && (!button01.isEnabled() && !button02.isEnabled() &&
    				!button03.isEnabled() && !button04.isEnabled() && !button05.isEnabled() && !button06.isEnabled() 
    				&& !button07.isEnabled() && !button08.isEnabled() && !button09.isEnabled() && !button11.isEnabled()
    				&& !button12.isEnabled() && !button13.isEnabled())) {
    			return true;
    		}
    	}
		return false;		
    }



    public void endGame() {
    	
    	button01.setEnabled(false);
    	button02.setEnabled(false);
    	button03.setEnabled(false);
    	button04.setEnabled(false);
    	button05.setEnabled(false);
    	button06.setEnabled(false);
    	button07.setEnabled(false);
    	button08.setEnabled(false);
    	button09.setEnabled(false);
        button11.setEnabled(false);
        button12.setEnabled(false);
        button13.setEnabled(false);
    }   
    


    public void newGame() {
    	
    	/** Resets the timer */  	
    	seconds.setBase(SystemClock.elapsedRealtime());
    	seconds.start();
    	
    	textView1 = (TextView) findViewById(R.id.textView1);
    	textView2 = (TextView) findViewById(R.id.textView2);
    	
    	button01.setEnabled(true);
    	button02.setEnabled(true);
    	button03.setEnabled(true);
    	button04.setEnabled(true);
    	button05.setEnabled(true);
    	button06.setEnabled(true);
    	button07.setEnabled(true);
    	button08.setEnabled(true);
    	button09.setEnabled(true);
    	button11.setVisibility(View.INVISIBLE);
    	button12.setVisibility(View.INVISIBLE);
    	button13.setVisibility(View.INVISIBLE);	
    	
    	button01.setText("");
    	button02.setText("");
    	button03.setText("");
    	button04.setText("");
    	button05.setText("");
    	button06.setText("");
    	button07.setText("");
    	button08.setText("");
    	button09.setText("");
    	button11.setText("");
    	button12.setText("");
    	button13.setText("");
    	textView1.setText("Level " + count);
    	textView2.setText("");
    	
    	/** Makes the extra buttons available if the user is in level 2 */  	
    	if (count==2) {
        	button11.setVisibility(View.VISIBLE);
        	button12.setVisibility(View.VISIBLE);
        	button13.setVisibility(View.VISIBLE);
        	button11.setEnabled(true);
        	button12.setEnabled(true);
        	button13.setEnabled(true);

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

