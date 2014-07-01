package com.example.tictacpawfinal;

import java.util.Random;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Petroula
 *
 */

public class MainActivity extends Activity implements OnClickListener {

	
	boolean checkTurn = true;
	Random rand = new Random();
	int computer;
	Button button01, button02, button03, button04, button05, button06, button07, button08, button09;
    TextView textView0, textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9;
	
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
		
		button01.setOnClickListener(this);
		button02.setOnClickListener(this);
        button03.setOnClickListener(this);
        button04.setOnClickListener(this);
        button05.setOnClickListener(this);
        button06.setOnClickListener(this);
        button07.setOnClickListener(this);
        button08.setOnClickListener(this);
        button09.setOnClickListener(this);
	 
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
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

		@Override
		public void onClick(View v) {
			
			textView1 = (TextView) findViewById(R.id.button1);
		    textView2 = (TextView) findViewById(R.id.button2);
		    textView3 = (TextView) findViewById(R.id.button3);
		    textView4 = (TextView) findViewById(R.id.button4);
		    textView5 = (TextView) findViewById(R.id.button5);
		    textView6 = (TextView) findViewById(R.id.button6);
		    textView7 = (TextView) findViewById(R.id.button7);
		    textView8 = (TextView) findViewById(R.id.button8);
		    textView9 = (TextView) findViewById(R.id.button9);
			
            if(v.getId()==R.id.button1 && button01.isEnabled()) {
    			textView1.setText("X");
    			button01.setEnabled(false);
    			checkEnd();
    	    	if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
    	    			|| button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
    	    			|| button09.isEnabled()) {
         	  	vsUser();
    	    	}
    		} else if (v.getId()==R.id.button2 && button02.isEnabled()) {
    			textView2.setText("X");
    			button02.setEnabled(false);
    			checkEnd();
    	    	if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
    	    			|| button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
    	    			|| button09.isEnabled()) {
         	  	vsUser();
    	    	}
    		} else if (v.getId()==R.id.button3 && button03.isEnabled()) {
    			textView3.setText("X");
    			button03.setEnabled(false);
    			checkEnd();
    	    	if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
    	    			|| button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
    	    			|| button09.isEnabled()) {
         	  	vsUser();
    	    	}
    		} else if (v.getId()==R.id.button4 && button04.isEnabled()) {
    			textView4.setText("X");
    			button04.setEnabled(false);
    			checkEnd();
    	    	if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
    	    			|| button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
    	    			|| button09.isEnabled()) {
         	  	vsUser();
    	    	}
    		} else if (v.getId()==R.id.button5 && button05.isEnabled()) {
    			textView5.setText("X");
    			button05.setEnabled(false);
    			checkEnd();
    	    	if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
    	    			|| button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
    	    			|| button09.isEnabled()) {
         	  	vsUser();
    	    	}
    		} else if (v.getId()==R.id.button6 && button06.isEnabled()) {
    			textView6.setText("X");
    			button06.setEnabled(false);
    			checkEnd();
    	    	if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
    	    			|| button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
    	    			|| button09.isEnabled()) {
         	  	vsUser();
    	    	}
    		} else if (v.getId()==R.id.button7 && button07.isEnabled()) {
    			textView7.setText("X");
    			button07.setEnabled(false);
    			checkEnd();
    	    	if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
    	    			|| button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
    	    			|| button09.isEnabled()) {
         	  	vsUser();
    	    	}
    		} else if (v.getId()==R.id.button8 && button08.isEnabled()) {
    			textView8.setText("X");
    			button08.setEnabled(false);
    			checkEnd();
    	    	if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
    	    			|| button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
    	    			|| button09.isEnabled()) {
         	  	vsUser();
    	    	}
    		} else if (v.getId()==R.id.button9 && button09.isEnabled()) {
    			textView9.setText("X");
    			button09.setEnabled(false);
    			checkEnd();
    	    	if(button01.isEnabled() || button02.isEnabled() || button03.isEnabled() || button04.isEnabled()
    	    			|| button05.isEnabled() || button06.isEnabled() || button07.isEnabled() || button08.isEnabled()
    	    			|| button09.isEnabled()) {
         	  	vsUser();
    	    	}
    		} 
			
		}
		
		public void vsUser() {
			
					computer =rand.nextInt(9);
				    
				    if (computer==0 && button01.isEnabled()){
				    	textView1.setText("O");
				    	button01.setEnabled(false);
				    	checkTurn = true;
				    } else if (computer==1 && button02.isEnabled()) {
				    	textView2.setText("O");
				    	button02.setEnabled(false);
				    	checkTurn = true;
				    } else if (computer==2 && button03.isEnabled()) {
				    	textView3.setText("O");
				    	button03.setEnabled(false);
				    	checkTurn = true;
			    	} else if (computer==3 && button04.isEnabled()) {
			    		textView4.setText("O");
			    		button04.setEnabled(false);
				    	checkTurn = true;
				    } else if (computer==4 && button05.isEnabled()) {
				    	textView5.setText("O");
				    	button05.setEnabled(false);
				    	checkTurn = true;	
				    } else if (computer==5 && button06.isEnabled()) {
				    	textView6.setText("O");
				    	button06.setEnabled(false);
				    	checkTurn = true;
				    } else if (computer==6 && button07.isEnabled()) {
				    	textView7.setText("O");
				    	button07.setEnabled(false);
				    	checkTurn = true;
			    	} else if (computer==7 && button08.isEnabled()) {
			    		textView8.setText("O");
			    		button08.setEnabled(false);
				    	checkTurn = true;
				   } else if (computer==8 && button09.isEnabled()) {
					    textView9.setText("O");
					    button09.setEnabled(false);
				    	checkTurn = true;
				   } else {
				    	vsUser();
				   }	
			
			checkEnd();
		    }


    public void checkEnd() {
    	
    	textView0 = (TextView) findViewById(R.id.textView0);
    	
    	 if (checkWin()==true) {
 		    	endGame();
 		    	textView0.setText("You won!");
 		 } else if (checkLose()==true) {
 		    	endGame();
 		    	textView0.setText("You lost");
 		 } else if (checkTie()==true) {
 		    	endGame();
 		    	textView0.setText("It's a tie!");
 		 }      
    	
    }
		
	public boolean checkWin() {
			
			if ((textView1.getText().toString()=="X" && textView2.getText().toString()=="X" && textView3.getText().toString()=="X")
					|| (textView4.getText().toString().equals("X") && textView5.getText().toString().equals("X") && textView6.getText().toString().equals("X")) 
				    || (textView7.getText().toString().equals("X") && textView8.getText().toString().equals("X") && textView9.getText().toString().equals("X"))
				    
				    || (textView1.getText().toString().equals("X") && textView4.getText().toString().equals("X") && textView7.getText().toString().equals("X"))
				    || (textView2.getText().toString().equals("X") && textView5.getText().toString().equals("X") && textView8.getText().toString().equals("X"))
				    || (textView3.getText().toString().equals("X") && textView6.getText().toString().equals("X") && textView9.getText().toString().equals("X"))
				    
				    || (textView1.getText().toString().equals("X") && textView5.getText().toString().equals("X") && textView9.getText().toString().equals("X"))
				    || (textView3.getText().toString().equals("X") && textView5.getText().toString().equals("X") && textView7.getText().toString().equals("X"))) {
				return true;
			}	
				return false;
			}
			
		
		public boolean checkLose() {
			
			if ((textView1.getText().toString().equals("O") && textView2.getText().toString().equals("O") && textView3.getText().toString().equals("O"))
					|| (textView4.getText().toString().equals("O") && textView5.getText().toString().equals("O") && textView6.getText().toString().equals("O")) 
				    || (textView7.getText().toString().equals("O") && textView8.getText().toString().equals("O") && textView9.getText().toString().equals("O"))
				    
				    || (textView1.getText().toString().equals("O") && textView4.getText().toString().equals("O") && textView7.getText().toString().equals("O"))
				    || (textView2.getText().toString().equals("O") && textView5.getText().toString().equals("O") && textView8.getText().toString().equals("O"))
				    || (textView3.getText().toString().equals("O") && textView6.getText().toString().equals("O") && textView9.getText().toString().equals("O"))
				    
				    || (textView1.getText().toString().equals("O") && textView5.getText().toString().equals("O") && textView9.getText().toString().equals("O"))
				    || (textView3.getText().toString().equals("O") && textView5.getText().toString().equals("O") && textView7.getText().toString().equals("O"))) {
				return true;
			}	
				return false;
		    }
		
		
		public boolean checkTie() {
			
			if (checkWin()==false && checkLose()==false && (!button01.isEnabled() && !button02.isEnabled() && !button03.isEnabled()
					&& !button04.isEnabled() && !button05.isEnabled() && !button06.isEnabled() && !button07.isEnabled()
					&& !button08.isEnabled() && !button09.isEnabled())) {
				return true;
				
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
		}


		
		
}
