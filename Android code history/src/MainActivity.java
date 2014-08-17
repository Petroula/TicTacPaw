package com.example.tictacpawfinal;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.*;
import android.preference.PreferenceManager;
import android.view.*;
import android.view.View.*;
import android.widget.*;

/**
* @author Petroula
*
*/

public class MainActivity extends Activity implements OnClickListener {
	
    TicTacToeOpenHelper helper;
    SQLiteDatabase db;
    Random rand = new Random();
    Button[][] buttons=new Button[3][3];
    int x, y;
    Button newGame, reset, displayScores, deleteScores;
    TextView level, score, display;
    int count=1;
    Chronometer seconds;
    GestureDetector detector;
    int i, j;   
    int[] a = {0, 2};
    int limit;
    String k = "O";
    long timeMillis;
    int timeSeconds;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
    	
	    initializeGame();	
	    helper = new TicTacToeOpenHelper(this);
    }
	
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
	    displayScores = (Button)findViewById(R.id.displayScores);
	    displayScores.setOnClickListener(this);
	    deleteScores = (Button)findViewById(R.id.deleteScores);
	    deleteScores.setOnClickListener(this);
        
        seconds = (Chronometer) findViewById(R.id.chronometer);
    	seconds.start();    	
    	
	}
	
	
    @SuppressWarnings("deprecation")
	@Override
    public void onClick(View v) {	 
    	
    	for (x=0; x<3; x++) {
			for (y=0; y<3; y++) {
				if (buttons[x][y].isPressed() && buttons[x][y].isEnabled()) {
					
					/** Assigns an X to the button pressed */  	 	
    		        buttons[x][y].setText("X");
					buttons[x][y].setBackgroundResource(R.drawable.button_pic);
    		        buttons[x][y].setEnabled(false);               
                    if(checkWin()==false && checkLose()==false && checkTie()==false) {
                    	vsUser();
                    } else {
                    	 checkEnd();
                    }   
                 }
    	     }
         }
    	
    	/** Starts a new game */
    	if (v.getId()==R.id.newGame) {
    		newGame();
    		
      } else if (v.getId()==R.id.reset) {
   	  
    	  final AlertDialog alert = new AlertDialog.Builder(this).create();
  		  alert.setTitle("Please confirm...");
  		  alert.setMessage("Are you sure you want to reset? This will restart the application and"
  		  		+ " any data will be lost. Continue?");
  		  alert.setIcon(R.drawable.reset_pic);
  		  alert.setButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
 
              /** Cancels choice */
              alert.dismiss();
            }
           });
  		  alert.setButton2("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
 
            	
              /** Changes back to the welcome screen */
          	  Intent changeView = new Intent(getApplicationContext(), WelcomeActivity.class);
          	  startActivity(changeView);
            }
          });
  	      
  		  alert.setCanceledOnTouchOutside(false);
  		  alert.show();
  		  
      } else if (v.getId()==R.id.displayScores) {
    	  //DISPLAY
    	  display = (TextView) findViewById(R.id.display);  		  
    	  helper.readAllScores();
    	  display.setText(helper.s);
         
      } else if (v.getId()==R.id.deleteScores) {
    	  helper.deleteAllScores();
    	  display.setText("");
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
    		buttons[0][2].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[0][2].setEnabled(false);
    	} else if (buttons[0][0].getText()==k && buttons[0][2].getText()==k && buttons[0][1].isEnabled()) {
    		buttons[0][1].setText("O");
    		buttons[0][1].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[0][1].setEnabled(false);
    	} else if (buttons[0][1].getText()==k && buttons[0][2].getText()==k && buttons[0][0].isEnabled()) {
    		buttons[0][0].setText("O");
    		buttons[0][0].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[0][0].setEnabled(false);
    	} else if (buttons[0][0].getText()==k && buttons[1][0].getText()==k && buttons[2][0].isEnabled()) {
    		buttons[2][0].setText("O");
    		buttons[2][0].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[2][0].setEnabled(false);
    	} else if (buttons[0][0].getText()==k && buttons[2][0].getText()==k && buttons[1][0].isEnabled()) {
    		buttons[1][0].setText("O");
    		buttons[1][0].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[1][0].setEnabled(false);
    	} else if (buttons[1][0].getText()==k && buttons[2][0].getText()==k && buttons[0][0].isEnabled()) {
    		buttons[0][0].setText("O");
    		buttons[0][0].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[0][0].setEnabled(false);
    	} else if (buttons[2][2].getText()==k && buttons[2][1].getText()==k && buttons[2][0].isEnabled()) {
    		buttons[2][0].setText("O");
    		buttons[2][0].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[2][0].setEnabled(false);
    	} else if (buttons[2][2].getText()==k && buttons[2][0].getText()==k && buttons[2][1].isEnabled()) {
    		buttons[2][1].setText("O");
    		buttons[2][1].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[2][1].setEnabled(false);
    	} else if (buttons[2][0].getText()==k && buttons[2][1].getText()==k && buttons[2][2].isEnabled()) {
    		buttons[2][2].setText("O");
    		buttons[2][2].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[2][2].setEnabled(false);
    	} else if (buttons[2][2].getText()==k && buttons[1][2].getText()==k && buttons[0][2].isEnabled()) {
    		buttons[0][2].setText("O");
    		buttons[0][2].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[0][2].setEnabled(false);
    	} else if (buttons[2][2].getText()==k && buttons[0][2].getText()==k && buttons[1][2].isEnabled()) {
    		buttons[1][2].setText("O");
    		buttons[1][2].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[1][2].setEnabled(false);
    	} else if (buttons[0][2].getText()==k && buttons[1][2].getText()==k && buttons[2][2].isEnabled()) {
    		buttons[2][2].setText("O");
    		buttons[2][2].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[2][2].setEnabled(false);
    	} else if (buttons[0][0].getText()==k && buttons[1][1].getText()==k && buttons[2][2].isEnabled()) {
    		buttons[2][2].setText("O");
    		buttons[2][2].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[2][2].setEnabled(false);
    	} else if (buttons[0][0].getText()==k && buttons[2][2].getText()==k && buttons[1][1].isEnabled()) {
    		buttons[1][1].setText("O");
    		buttons[1][1].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[1][1].setEnabled(false);
    	} else if (buttons[1][1].getText()==k && buttons[2][2].getText()==k && buttons[0][0].isEnabled()) {
    		buttons[0][0].setText("O");
    		buttons[0][0].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[0][0].setEnabled(false);
    	} else if (buttons[2][0].getText()==k && buttons[1][1].getText()==k && buttons[0][2].isEnabled()) {
    		buttons[0][2].setText("O");
    		buttons[0][2].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[0][2].setEnabled(false);
    	} else if (buttons[2][0].getText()==k && buttons[0][2].getText()==k && buttons[1][1].isEnabled()) {
    		buttons[1][1].setText("O");
    		buttons[1][1].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[1][1].setEnabled(false);
    	} else if (buttons[1][1].getText()==k && buttons[0][2].getText()==k && buttons[2][0].isEnabled()) {
    		buttons[2][0].setText("O");
    		buttons[2][0].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[2][0].setEnabled(false);
    	} else if (buttons[1][0].getText()==k && buttons[1][1].getText()==k && buttons[1][2].isEnabled()) {
    		buttons[1][2].setText("O");
    		buttons[1][2].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[1][2].setEnabled(false);
    	} else if (buttons[1][0].getText()==k && buttons[1][2].getText()==k && buttons[1][1].isEnabled()) {
    		buttons[1][1].setText("O");
    		buttons[1][1].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[1][1].setEnabled(false);
    	} else if (buttons[1][1].getText()==k && buttons[1][2].getText()==k && buttons[1][0].isEnabled()) {
    		buttons[1][0].setText("O");
    		buttons[1][0].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[1][0].setEnabled(false);
    	} else if (buttons[0][1].getText()==k && buttons[1][1].getText()==k && buttons[2][1].isEnabled()) {
    		buttons[2][1].setText("O");
    		buttons[2][1].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[2][1].setEnabled(false);
    	} else if (buttons[0][1].getText()==k && buttons[2][1].getText()==k && buttons[1][1].isEnabled()) {
    		buttons[1][1].setText("O");
    		buttons[1][1].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[1][1].setEnabled(false);
    	} else if (buttons[1][1].getText()==k && buttons[2][1].getText()==k && buttons[0][1].isEnabled()) {
    		buttons[0][1].setText("O");
    		buttons[0][1].setBackgroundResource(R.drawable.button_pic_white);
    		buttons[0][1].setEnabled(false);
    	} 
    }
    
    
    
    public void randomMove() {
    	
    	i = rand.nextInt(3);
		j = rand.nextInt(3);
		if (buttons[i][j].isEnabled() ) {
			buttons[i][j].setText("O");
			buttons[i][j].setBackgroundResource(R.drawable.button_pic_white);
			buttons[i][j].setEnabled(false);
		} else {
			randomMove();
		} 
    }
    
    public void randomCorner() {
    	
    	i = a[rand.nextInt(a.length)];
	    j = a[rand.nextInt(a.length)];
	    if (buttons[i][j].isEnabled()) {    
	    	buttons[i][j].setText("O");    
	    	buttons[i][j].setBackgroundResource(R.drawable.button_pic_white);
	    	buttons[i][j].setEnabled(false);
	    } else {
	    	randomCorner();
	    }  	
    }
    
    public boolean checkCorner() {
    	if (buttons[0][0].isEnabled() || buttons[0][2].isEnabled() ||
    			buttons[2][0].isEnabled() || buttons[2][2].isEnabled()) {
    		return true;
    	}
    	return false;
    }
    
    
    /** This method handles the computer's strategy */  	
    public void vsUser() {
    		
    	/** Chooses randomly where to assign an O, when at level 1 */   	
    	if (count==1) {
    		randomMove();
    		
    	/** Uses a strategy for assigning O's, when at level 2 and 3 */	
    	} else if (count==2 || count==3) {
    		if (buttons[1][1].isEnabled()) {
    			buttons[1][1].setText("O");
    			buttons[1][1].setBackgroundResource(R.drawable.button_pic_white);
    			buttons[1][1].setEnabled(false);
    		} else if (!buttons[1][1].isEnabled() && checkChain()==false) { 			
    			k="X";
    			if (checkChain() == true) {
    				/** Aims at blocking opponent's 2 in a row */
    				AImove();   				
    				k="O";
    			} else if (checkChain() == false && checkCorner() == true){
    				randomCorner();
    				k="O";
    				
    			} else if (checkChain() == false && checkCorner() == false){
    				randomMove();
    			}
    		} else if (!buttons[1][1].isEnabled() && checkChain()==true) {
    			/** Aims at creating 3 in a row */	
    			AImove();	
    		}   		
    	}
        checkEnd();
     }
    
  
    /** Checks for win, lose or tie situation */  	 
    @SuppressWarnings("deprecation")
	public void checkEnd() {
    	
    	score = (TextView) findViewById(R.id.score);
    	
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
        	
        	
        	/** Adds the score to the database */ 
            helper.addScore(count, timeSeconds);
        	
        	
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
        		//win
        		final AlertDialog alert = new AlertDialog.Builder(this).create();
        		alert.setTitle("You won!"); 
        		alert.setMessage("Clicking on the 'New Game' will lead you to next level!");
        		alert.setIcon(R.drawable.button_pic); 
        		alert.setButton("Ok", new DialogInterface.OnClickListener() {
        			public void onClick(DialogInterface dialog, int which) {
        				alert.dismiss();
        			}
        			});
        		alert.setCanceledOnTouchOutside(false);
        		alert.show();
        	    count++;
        	} else {
        		//win too slow
        		final AlertDialog alert = new AlertDialog.Builder(this).create();
        		alert.setTitle("Too slow!");
        		alert.setMessage("You won..but you were too slow! You have to try again!");
        		alert.setIcon(R.drawable.button_pic);       		
        		alert.setButton("Ok", new DialogInterface.OnClickListener() {
        			public void onClick(DialogInterface dialog, int which) {
        				alert.dismiss();
        			}
        			});
        		alert.setCanceledOnTouchOutside(false);
        		alert.show();
            }
        
        	
            if(count==4 && timeSeconds<limit) {
            	//win all levels
            	final AlertDialog alert = new AlertDialog.Builder(this).create();
            	alert.setTitle("You won!");
        		alert.setMessage("Well done, you won all levels!");
        		alert.setIcon(R.drawable.button_pic);        		
        		alert.setButton("Ok", new DialogInterface.OnClickListener() {
        			public void onClick(DialogInterface dialog, int which) {
        				alert.dismiss();
        			}
        			});
        		alert.setCanceledOnTouchOutside(false);
        		alert.show();
                count=1;          	
            }           
            
        } else if (checkLose()==true) {        
            endGame();
        	seconds.stop();
        	//lost
        	final AlertDialog alert = new AlertDialog.Builder(this).create();
        	alert.setTitle("You lost!");
    		alert.setMessage("Unfortunately, you lost! Please try again!");
    		alert.setIcon(R.drawable.button_pic);    		
    		alert.setButton("Ok", new DialogInterface.OnClickListener() {
    			public void onClick(DialogInterface dialog, int which) {
    				alert.dismiss();
    			}
    			});
    		alert.setCanceledOnTouchOutside(false);
    		alert.show();
        } else if (checkTie()==true) {
            endGame();
            seconds.stop();
            //tie
            final AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setTitle("It's a tie!");
    		alert.setMessage("The game ended in a tie! Next time you may win!");
    		alert.setIcon(R.drawable.button_pic);    		
    		alert.setButton("Ok", new DialogInterface.OnClickListener() {
    			public void onClick(DialogInterface dialog, int which) {
    				alert.dismiss();
    			}
    			});
    		alert.setCanceledOnTouchOutside(false);
    		alert.show();
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
				buttons[x][y].setBackgroundResource(R.drawable.button_pic0);
			}
	    }   	
    	level.setText("Level " + count);
    	
    	if (count==3) {
    		vsUser();
    	}
    }
}

