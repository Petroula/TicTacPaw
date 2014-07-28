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
	Button[][] buttons=new Button[3][3];
	int x, y;
	Button newGame, reset;
    TextView level, result, score;
    int count=1;
    Chronometer seconds;
    GestureDetector detector;
    int i, j;   
    int[] a = {0, 2};
    int limit;
    String k = "X";
	
    
    /** Checks if the main screen should be displayed after a swipe from the instructions page */
    public static int recognizeScreen =0;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
    	
	    initializeGame();	    
    }
    
	
	@SuppressWarnings("deprecation")
	/** Sets up the game */  
	public void initializeGame() {
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
    	/** Starts a new game */
    	if (v.getId()==R.id.newGame) {
    		newGame();
      } else if (v.getId()==R.id.reset) {
   	  
    	  /** Changes back to the welcome screen */
    	  Intent changeView = new Intent(getApplicationContext(), WelcomeActivity.class);
    	  startActivity(changeView);
      }
    }
    
    
    /** Checks for 2-in-a-row */
    public boolean checkChain() {
    	
    	if( (buttons[0][0].getText()==k && buttons[0][1].getText()==k && buttons[0][2].isEnabled()) 
    	||
    	
    	(buttons[0][0].getText()==k && buttons[0][2].getText()==k && buttons[0][1].isEnabled()) 
    	
    	||
    	(buttons[0][1].getText()==k && buttons[0][2].getText()==k && buttons[0][0].isEnabled())

        ||
        (buttons[0][0].getText()==k && buttons[1][0].getText()==k && buttons[2][0].isEnabled())
    	
        ||
    	(buttons[0][0].getText()==k && buttons[2][0].getText()==k && buttons[1][0].isEnabled()) 
    	
    	||
    	(buttons[1][0].getText()==k && buttons[2][0].getText()==k && buttons[0][0].isEnabled())
    	
    	||
    	(buttons[2][2].getText()==k && buttons[2][1].getText()==k && buttons[2][0].isEnabled())
    	
    	||
        (buttons[2][2].getText()==k && buttons[2][0].getText()==k && buttons[2][1].isEnabled())
    		
        ||
    	(buttons[2][0].getText()==k && buttons[2][1].getText()==k && buttons[2][2].isEnabled())
    	
    	||
    	(buttons[2][2].getText()==k && buttons[1][2].getText()==k && buttons[0][2].isEnabled())
    	
    	||
    	(buttons[2][2].getText()==k && buttons[0][2].getText()==k && buttons[1][2].isEnabled())
    	
    	||
    	(buttons[0][2].getText()==k && buttons[1][2].getText()==k && buttons[2][2].isEnabled()) 
    	
    	||
    	(buttons[0][0].getText()==k && buttons[1][1].getText()==k && buttons[2][2].isEnabled())
    	
    	||
    	(buttons[0][0].getText()==k && buttons[2][2].getText()==k && buttons[1][1].isEnabled())
    	
    	||
    	(buttons[1][1].getText()==k && buttons[2][2].getText()==k && buttons[0][0].isEnabled())
    	
    	||
    	(buttons[2][0].getText()==k && buttons[1][1].getText()==k && buttons[0][2].isEnabled())
    	
    	||
    	(buttons[2][0].getText()==k && buttons[0][2].getText()==k && buttons[1][1].isEnabled())
    
    	||
    	(buttons[1][1].getText()==k && buttons[0][2].getText()==k && buttons[2][0].isEnabled())
    	
    	||
    	(buttons[1][0].getText()==k && buttons[1][1].getText()==k && buttons[1][2].isEnabled())
    	
    	||
    	(buttons[1][0].getText()==k && buttons[1][2].getText()==k && buttons[1][1].isEnabled())
    	
    	||
    	(buttons[1][1].getText()==k && buttons[1][2].getText()==k && buttons[1][0].isEnabled())
    	
    	||
    	(buttons[0][1].getText()==k && buttons[1][1].getText()==k && buttons[2][1].isEnabled())
    	
    	||
    	(buttons[0][1].getText()==k && buttons[2][1].getText()==k && buttons[1][1].isEnabled())
    	
    	||
    	(buttons[1][1].getText()==k && buttons[2][1].getText()==k && buttons[0][1].isEnabled())) {

    		return true;
    	}
		return false; 
    	
    }
   
    /** Strategic move */
    public void AImove() {
    	
    	if(buttons[0][0].getText()==k && buttons[0][1].getText()==k && buttons[0][2].isEnabled()) {
    		buttons[0][2].setText("O");
    		buttons[0][2].setEnabled(false);
    	} else if (buttons[0][0].getText()==k && buttons[0][2].getText()==k && buttons[0][1].isEnabled()) {
    		buttons[0][1].setText("O");
    		buttons[0][1].setEnabled(false);
    	} else if (buttons[0][1].getText()==k && buttons[0][2].getText()==k && buttons[0][0].isEnabled()) {
    		buttons[0][0].setText("O");
    		buttons[0][0].setEnabled(false);
    	} else if (buttons[0][0].getText()==k && buttons[1][0].getText()==k && buttons[2][0].isEnabled()) {
    		buttons[2][0].setText("O");
    		buttons[2][0].setEnabled(false);
    	} else if (buttons[0][0].getText()==k && buttons[2][0].getText()==k && buttons[1][0].isEnabled()) {
    		buttons[1][0].setText("O");
    		buttons[1][0].setEnabled(false);
    	} else if (buttons[1][0].getText()==k && buttons[2][0].getText()==k && buttons[0][0].isEnabled()) {
    		buttons[0][0].setText("O");
    		buttons[0][0].setEnabled(false);
    	} else if (buttons[2][2].getText()==k && buttons[2][1].getText()==k && buttons[2][0].isEnabled()) {
    		buttons[2][0].setText("O");
    		buttons[2][0].setEnabled(false);
    	} else if (buttons[2][2].getText()==k && buttons[2][0].getText()==k && buttons[2][1].isEnabled()) {
    		buttons[2][1].setText("O");
    		buttons[2][1].setEnabled(false);
    	} else if (buttons[2][0].getText()==k && buttons[2][1].getText()==k && buttons[2][2].isEnabled()) {
    		buttons[2][2].setText("O");
    		buttons[2][2].setEnabled(false);
    	} else if (buttons[2][2].getText()==k && buttons[1][2].getText()==k && buttons[0][2].isEnabled()) {
    		buttons[0][2].setText("O");
    		buttons[0][2].setEnabled(false);
    	} else if (buttons[2][2].getText()==k && buttons[0][2].getText()==k && buttons[1][2].isEnabled()) {
    		buttons[1][2].setText("O");
    		buttons[1][2].setEnabled(false);
    	} else if (buttons[0][2].getText()==k && buttons[1][2].getText()==k && buttons[2][2].isEnabled()) {
    		buttons[2][2].setText("O");
    		buttons[2][2].setEnabled(false);
    	} else if (buttons[0][0].getText()==k && buttons[1][1].getText()==k && buttons[2][2].isEnabled()) {
    		buttons[2][2].setText("O");
    		buttons[2][2].setEnabled(false);
    	} else if (buttons[0][0].getText()==k && buttons[2][2].getText()==k && buttons[1][1].isEnabled()) {
    		buttons[1][1].setText("O");
    		buttons[1][1].setEnabled(false);
    	} else if (buttons[1][1].getText()==k && buttons[2][2].getText()==k && buttons[0][0].isEnabled()) {
    		buttons[0][0].setText("O");
    		buttons[0][0].setEnabled(false);
    	} else if (buttons[2][0].getText()==k && buttons[1][1].getText()==k && buttons[0][2].isEnabled()) {
    		buttons[0][2].setText("O");
    		buttons[0][2].setEnabled(false);
    	} else if (buttons[2][0].getText()==k && buttons[0][2].getText()==k && buttons[1][1].isEnabled()) {
    		buttons[1][1].setText("O");
    		buttons[1][1].setEnabled(false);
    	} else if (buttons[1][1].getText()==k && buttons[0][2].getText()==k && buttons[2][0].isEnabled()) {
    		buttons[2][0].setText("O");
    		buttons[2][0].setEnabled(false);
    	} else if (buttons[1][0].getText()==k && buttons[1][1].getText()==k && buttons[1][2].isEnabled()) {
    		buttons[1][2].setText("O");
    		buttons[1][2].setEnabled(false);
    	} else if (buttons[1][0].getText()==k && buttons[1][2].getText()==k && buttons[1][1].isEnabled()) {
    		buttons[1][1].setText("O");
    		buttons[1][1].setEnabled(false);
    	} else if (buttons[1][1].getText()==k && buttons[1][2].getText()==k && buttons[1][0].isEnabled()) {
    		buttons[1][0].setText("O");
    		buttons[1][0].setEnabled(false);
    	} else if (buttons[0][1].getText()==k && buttons[1][1].getText()==k && buttons[2][1].isEnabled()) {
    		buttons[2][1].setText("O");
    		buttons[2][1].setEnabled(false);
    	} else if (buttons[0][1].getText()==k && buttons[2][1].getText()==k && buttons[1][1].isEnabled()) {
    		buttons[1][1].setText("O");
    		buttons[1][1].setEnabled(false);
    	} else if (buttons[1][1].getText()==k && buttons[2][1].getText()==k && buttons[0][1].isEnabled()) {
    		buttons[0][1].setText("O");
    		buttons[0][1].setEnabled(false);
    	} 
    }
    
    
    
    public void randomMove() {
    	
    	i = rand.nextInt(3);
		j = rand.nextInt(3);
		if (buttons[i][j].isEnabled() ) {
			buttons[i][j].setText("O");
			buttons[i][j].setEnabled(false);
		} else {
			vsUser();
		} 
    }
    
    public void randomCorner() {
    	
    	i = a[rand.nextInt(a.length)];
	    j = a[rand.nextInt(a.length)];
	    if (buttons[i][j].isEnabled()) {    
	    	buttons[i][j].setText("O");      
	    	buttons[i][j].setEnabled(false);
	    } else {
	    	vsUser();
	    }  	
    }
    
    
    /** This method handles the computer's strategy */  	
    public void vsUser() {
    		
    	/** Chooses randomly where to assign an O, when at level 1 */   	
    	if (count==1) {
    		randomMove();
    		
    	/** Uses a strategy for assigning O's, when at level 2 */	
    	} else if (count==2) {
    		if (buttons[1][1].isEnabled()) {
    			buttons[1][1].setText("O");
    			buttons[1][1].setEnabled(false);
    		} else if (!buttons[1][1].isEnabled() && checkChain()==false) { 			
    			k="O";
    			if (checkChain() == true) {
    				/** Aims at creating 3 in a row */	
    				AImove();
    				k="X";
    			} else {
    				randomCorner();
    				k="X";
    			}  			
    		} else if (!buttons[1][1].isEnabled() && checkChain()==true) {
    			/** Aims at blocking opponent's 2 in a row */	
    			AImove();	
    		}
    	} 
        checkEnd();
     }
    
  
    /** Checks for win, lose or tie situation */  	 
    public void checkEnd() {
    	
    	long timeMillis;
    	int timeSeconds;
    	
    	score = (TextView) findViewById(R.id.score);
    	result = (TextView) findViewById(R.id.result);
    	
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
        	
        	/** Stores the quickest paw after comparing with the current one */     	
        	if(!score.getText().toString().isEmpty()) {
        		SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
            	if(timeSeconds<shared.getInt("Quickest Paw", timeSeconds)){          		
            		SharedPreferences.Editor sharedEditor = shared.edit();
                    sharedEditor.putInt("Quickest Paw", timeSeconds);
                    sharedEditor.commit();
                    score.setText("The Quickest Paw is approximately: "
                    + Integer.toString(timeSeconds) + " seconds");
                 }   
            	
            /** Stores the quickest paw for the first time  */	
        	} else if (score.getText().toString().isEmpty()) {
        		SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
        		SharedPreferences.Editor sharedEditor = shared.edit();
                sharedEditor.putInt("Quickest Paw", timeSeconds);
                sharedEditor.commit();
                score.setText("The Quickest Paw is approximately: "
                + Integer.toString(timeSeconds) + " seconds");               
        	}
        	
        	/** Wins only if the user's time is under the limit for the current difficulty mode (easy, medium, hard) */
        	if(timeSeconds<limit) {
        		result.setText("You won!");
        		count++;
        	} else {
        		result.setText("You won ... BUT you were too slow! Try again!");
            }
        
        	
            if(count==3) {
        	    result.setText("You won all levels!");
                count=1;          	
            }           
            
        } else if (checkLose()==true) {        
            endGame();
        	seconds.stop();
            result.setText("You lost!");           
        } else if (checkTie()==true) {
            endGame();
            seconds.stop();
            result.setText("It's a tie!");
        }   
    }
    
    
    /** Handles the rules for winning the game */
    public boolean checkWin() {
    	
    	if ((buttons[0][0].getText()=="X" && buttons[0][1].getText()=="X" && buttons[0][2].getText()=="X")
				|| (buttons[1][0].getText()=="X" && buttons[1][1].getText()=="X" && buttons[1][2].getText()=="X") 
			    || (buttons[2][0].getText()=="X" && buttons[2][1].getText()=="X" && buttons[2][2].getText()=="X")
			    
			    || (buttons[0][0].getText()=="X" && buttons[1][0].getText()=="X" && buttons[2][0].getText()=="X")
			    || (buttons[0][1].getText()=="X" && buttons[1][1].getText()=="X" && buttons[2][1].getText()=="X")
			    || (buttons[0][2].getText()=="X" && buttons[1][2].getText()=="X" && buttons[2][2].getText()=="X")
			    
			    || (buttons[0][0].getText()=="X" && buttons[1][1].getText()=="X" && buttons[2][2].getText()=="X")
			    || (buttons[0][2].getText()=="X" && buttons[1][1].getText()=="X" && buttons[2][0].getText()=="X")) {
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
    		return true;
    	}
    	return false;
     }


    public boolean checkTie() {
    	if (checkWin()==false && checkLose()==false && (!buttons[0][0].isEnabled() && !buttons[0][1].isEnabled() &&
    			!buttons[0][2].isEnabled() && !buttons[1][0].isEnabled() && !buttons[1][1].isEnabled() && !buttons[1][2].isEnabled() 
    			&& !buttons[2][0].isEnabled() && !buttons[2][1].isEnabled() && !buttons[2][2].isEnabled())) {
    		return true;
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
    	
    	level = (TextView) findViewById(R.id.level);
    	
    	for (x=0; x<3; x++) {
			for (y=0; y<3; y++) {
				buttons[x][y].setEnabled(true);
				buttons[x][y].setText("");
			}
	    }   	
    	level.setText("Level " + count);
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

	/** Adds swipe gesture */
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

