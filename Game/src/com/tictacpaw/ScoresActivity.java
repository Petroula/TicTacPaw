package com.tictacpaw;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

public class ScoresActivity extends Activity implements OnClickListener{

	TicTacToeOpenHelper helper;
	SQLiteDatabase db;
	TextView tableTitle, timeSec, levelNum, allRows, playerName;
	Button deleteScores, back;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.scores_screen);
	
    	helper = new TicTacToeOpenHelper(this);
    	deleteScores = (Button)findViewById(R.id.deleteScores);
    	deleteScores.setOnClickListener(this);
    	back = (Button)findViewById(R.id.back);
    	back.setOnClickListener(this);
    	display();
    	
	}
	
	@SuppressWarnings("deprecation")
	public void display() {
		
		allRows = (TextView)findViewById(R.id.allRows);
		helper.readAllScores();
		allRows.setText(helper.s);	
		
		if(allRows.getText() == "") {
			final AlertDialog alert = new AlertDialog.Builder(this).create();
    		alert.setTitle("No Scores..."); 
    		alert.setMessage("Currently there is no data for this application!");
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
	
	
	@SuppressWarnings("deprecation")
	public void clearAll() {
		
		allRows = (TextView)findViewById(R.id.allRows);
		
		final AlertDialog alert = new AlertDialog.Builder(this).create();
		alert.setTitle("Are you sure?"); 
		alert.setMessage("All data will be lost. Continue?");
		alert.setIcon(R.drawable.reset_pic); 
		alert.setButton("No", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				alert.dismiss();
			}
			});
		alert.setCanceledOnTouchOutside(false);	
		alert.setButton2("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				helper.deleteAllScores();
				allRows.setText("");
			}
			});
		alert.setCanceledOnTouchOutside(false);
		alert.show();
	}
	
	
	@Override
	public void onClick(View v) {
		
		if (v.getId()==R.id.deleteScores) {
			clearAll();
			
		} else if (v.getId()==R.id.back) {
			
			Intent welcomeView = new Intent(getApplicationContext(), WelcomeActivity.class);
			startActivity(welcomeView);
		}
	}
}
