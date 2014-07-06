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
	Button button01, button02, button03, button04, button05, button06, button07, button08, button09, button10,
	button11, button12, button13;
        TextView textView1, textView2;
        int count=1;

    
    
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
        
        button11.setVisibility(View.INVISIBLE);
        button12.setVisibility(View.INVISIBLE);
        button13.setVisibility(View.INVISIBLE);
        
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
         }
    }
   
    
    public void vsUser() {
  	
    	if (count==1) {
    		computer =rand.nextInt(9);
    	} else if (count==2) {
    		computer =rand.nextInt(11);
    	}
    	
    	
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
    
    
    public void checkEnd() {
    	
    	textView2 = (TextView) findViewById(R.id.textView2);
    
        if (checkWin()==true) {
        	endGame();
            textView2.setText("You won!");
            count++;
            if (count==3) {
            	textView2.setText("You won all levels!");
            	count=1;          	
            }
        } else if (checkLose()==true) {
        	endGame();
            textView2.setText("You lost!");
            count=1;           
        } else if (checkTie()==true) {
            endGame();
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
                
                
    			//level 2 extra checks
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
    	if (count==2) {
        	button11.setVisibility(View.VISIBLE);
        	button12.setVisibility(View.VISIBLE);
        	button13.setVisibility(View.VISIBLE);
        	button11.setEnabled(true);
        	button12.setEnabled(true);
        	button13.setEnabled(true);

        }
    }
}

