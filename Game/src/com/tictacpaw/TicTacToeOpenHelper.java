package com.tictacpaw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
* @author Petroula
*
*/

public class TicTacToeOpenHelper extends SQLiteOpenHelper {
		
	    public SQLiteDatabase db;
	    public Cursor cursor;
	    public static String s = "";
	    public static String s1 = "";
	    public static String sql1 = "";
	    public static String s2 = "";
	    public static String sql2 = "";    
	    public static String name;
		public static final String TABLE_NAME = "scores";
		public static final String COLUMN_NAME_S = "Seconds";
		public static final String COLUMN_NAME_LEVEL = "Level";
		public static final String COLUMN_NAME_PLAYER = "Player";
		public static final String COLUMN_ID = "_id";
		
		public static final int DATABASE_VERSION = 1;
		public static final String DATABASE_NAME = "Scores.db";
	    
	    public static final String SCORES_TABLE_CREATE =
	                "CREATE TABLE " + TABLE_NAME + " (" +
	                		COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
	                		COLUMN_NAME_PLAYER + " TEXT, " +
	                		COLUMN_NAME_LEVEL + " INTEGER NOT NULL, " +
	                		COLUMN_NAME_S + " INTEGER NOT NULL);";
	    
		
		public TicTacToeOpenHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(SCORES_TABLE_CREATE);	
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {	
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		}
		
		
		/** Adds the score to the database  */
		public void addScore(String player, int level, int time) {
			
			db=this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put(COLUMN_NAME_PLAYER, player);
			values.put(COLUMN_NAME_LEVEL, level);
			values.put(COLUMN_NAME_S, time);		
			db.insert(TABLE_NAME, null, values);
			db.close();
		}
		
		/** Reads the scores from the database separately for each level and puts them in descending order
		 * Selects only the quickest score for each  */
		public void readAllScores() {
			
			s1 = "";
	    	sql1 = "SELECT " +  COLUMN_ID  + "," + COLUMN_NAME_PLAYER +
	    			"," + COLUMN_NAME_LEVEL + "," + COLUMN_NAME_S + " FROM " + TABLE_NAME
	    			+ " WHERE " + COLUMN_NAME_LEVEL + "=1"
	    			+ " ORDER BY " + COLUMN_NAME_S + " DESC";	
	    	
	    	s2 = "";
	    	sql2 = "SELECT " +  COLUMN_ID  + "," + COLUMN_NAME_PLAYER +
	    			"," + COLUMN_NAME_LEVEL + "," + COLUMN_NAME_S + " FROM " + TABLE_NAME
	    			+ " WHERE " + COLUMN_NAME_LEVEL + "=2"
	    			+ " ORDER BY " + COLUMN_NAME_S + " DESC";	
	    	
			cursor = getReadableDatabase().rawQuery(sql1, null);
			if (cursor.moveToFirst()) {
				do {
//				int id = cursor.getColumnIndex(COLUMN_ID);
				int playersName = cursor.getColumnIndex(COLUMN_NAME_PLAYER);				
				int level = cursor.getColumnIndex(COLUMN_NAME_LEVEL);
		    	int time = cursor.getColumnIndex(COLUMN_NAME_S);
		    	
		    	/** Makes sure that the results appear properly on screen */
		    	if(cursor.getString(playersName).length()==0) {
		    		name="-----";
		    	} else if(cursor.getString(playersName).length()==1){
		    		name=cursor.getString(playersName) + "    ";
		    	} else if(cursor.getString(playersName).length()==2){
		    		name=cursor.getString(playersName) + "   ";
		    	} else if(cursor.getString(playersName).length()==3){
		    		name=cursor.getString(playersName) + "  ";
		    	} else if(cursor.getString(playersName).length()==4){
		    		name=cursor.getString(playersName) + " ";
		    	} else {
		    		name=cursor.getString(playersName);
		    	} 
		    	s1 = name + "    " + cursor.getString(level) + "        " + cursor.getString(time) + "\n";
				} while (cursor.moveToNext());
			};
			

			cursor = getReadableDatabase().rawQuery(sql2, null);
			if (cursor.moveToFirst()) {
				do {
//				int id = cursor.getColumnIndex(COLUMN_ID);
				int playersName = cursor.getColumnIndex(COLUMN_NAME_PLAYER);				
				int level = cursor.getColumnIndex(COLUMN_NAME_LEVEL);
		    	int time = cursor.getColumnIndex(COLUMN_NAME_S);
		    	
		    	/** Makes sure that the results appear properly on screen */
		    	if(cursor.getString(playersName).length()==0) {
		    		name="-----";
		    	} else if(cursor.getString(playersName).length()==1){
		    		name=cursor.getString(playersName) + "    ";
		    	} else if(cursor.getString(playersName).length()==2){
		    		name=cursor.getString(playersName) + "   ";
		    	} else if(cursor.getString(playersName).length()==3){
		    		name=cursor.getString(playersName) + "  ";
		    	} else if(cursor.getString(playersName).length()==4){
		    		name=cursor.getString(playersName) + " ";
		    	} else {
		    		name=cursor.getString(playersName);
		    	} 
		    	s2 = name + "    " + cursor.getString(level) + "        " + cursor.getString(time) + "\n";
				} while (cursor.moveToNext());
			};	
			s = s1 + s2;
			
		}
		
	    
		public void deleteAllScores() {
			
			db = this.getWritableDatabase();
			db.delete(TABLE_NAME, null, null);
			db.close();
		}
		
}
		