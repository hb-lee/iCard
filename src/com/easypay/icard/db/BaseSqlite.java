package com.easypay.icard.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.easypay.icard.entity.BusinessInfo;

public class BaseSqlite {

	public static final String TAG = BaseSqlite.class.getSimpleName();
	private static final String DBA_NAME = "myDatebase";
	// Business表的各字段
	private static final String BUSINESSTABLE_NAME = "Business_Info";
	private static final String BUSINESSID = "_id";
	private static final String BUSINESSNAME = "Business_name";
	private static final String BUSINESSPIC = "Business_pic";
	private static final String BUSINESSINTRO = "Business_intro";
	private static final String BUSINESSTYPE = "Business_type";
	private static final String USERID_IN_BUSINESS = "User_id";
	private static final String LATITUDE = "Latitude";
	private static final String LONGITUDE = "Longitude";
	
	private static final String CREATE_BUSINESSDB = "create table "
			+ BUSINESSTABLE_NAME + " (" + BUSINESSID
			+ " integer primary key autoincrement, " + BUSINESSNAME
			+ " text not null, " + BUSINESSPIC + " text not null, "
			+ BUSINESSINTRO + " text not null, " + BUSINESSTYPE
			+ " text not null, " + USERID_IN_BUSINESS + " integer not null, "
			+ LATITUDE + " text not null, " + LONGITUDE + " text not null);";
	
	// Card表的各字段
	private static final String CARDTABLE_NAME = "Card_Info";
	private static final String CARDID = "_id";
	private static final String USERID_IN_CARD = "Card_id";
	private static final String BUSINESSID_IN_CARD = "Business_id";
	private static final String BALANCE = "Balance";
	private static final String CREDIT = "Credit";
	private static final String NUMBER = "Number";
	private static final String CARD_TYPE = "Card_type";
	
	private static final String CREATE_CARDDB = "create table "
			+ CARDTABLE_NAME + " (" + CARDID
			+ " integer primary key autoincrement, " + USERID_IN_CARD
			+ " integer not null, " + BUSINESSID_IN_CARD + " integer not null, "
			+ BALANCE + " text not null, " + CREDIT
			+ " text not null, " + NUMBER + " text not null, "
			+ CARD_TYPE + " integer not null);";
	
	// User表的各字段
	private static final String USERTABLE_NAME = "User_Info";
	private static final String USERID = "_id";
	private static final String USERNAME = "User_name";
	private static final String USERPHONE = "User_phone";
	private static final String USERTYPE = "User_type";
	private static final String USERACCOUNT = "User_account";
	private static final String USERPASSWORD = "User_password";
	private static final String USERGENDER = "User_gender";
	private static final String USERPHOTO = "User_photo";
	private static final String USERCARD = "User_card";
	
	private static final String CREATE_USERDB = "create table "
			+ USERTABLE_NAME + " (" + USERID
			+ " integer primary key autoincrement, " + USERNAME
			+ " text not null, " + USERPHONE + " text not null, "
			+ USERTYPE + " integer not null, " + USERACCOUNT
			+ " text not null, " + USERPASSWORD + " text not null, "
			+ USERGENDER + " text not null, " + USERPHOTO
			+ " text not null, " + USERCARD + " text not null);";
	
	// Advertise表的各字段
	private static final String ADVERTIESTABLE_NAME = "Advertise_Info";
	private static final String ADVERTISEID = "_id";
	private static final String TITLEPIC = "Title_pri";
	private static final String TITLESUB = "Title_sub";
	private static final String BUSINESSID_IN_ADVERTISE = "Business_id";
	
	private static final String CREATE_ADVERTISEDB = "create table "
			+ ADVERTIESTABLE_NAME + " (" + ADVERTISEID
			+ " integer primary key autoincrement, " + TITLEPIC
			+ " text not null, " + TITLESUB + " text not null, "
			+ BUSINESSID_IN_ADVERTISE + " integer not null);";
	
	private BaseDBSqlite baseDBSqlite;
	private SQLiteDatabase sqliteDatabase;

	public BaseSqlite(Context context) {
		Context mcontext = context;
		baseDBSqlite = new BaseDBSqlite(mcontext, DBA_NAME, null, 1);
	}

	public BaseSqlite openDatabase() {
		sqliteDatabase = baseDBSqlite.getWritableDatabase();
		return this;
	}

	public void closeDatabase() {
		sqliteDatabase.close();
	}
	
	public long insert(BusinessInfo business){
		ContentValues values = new ContentValues();
		values.put(BUSINESSNAME, business.getName());
		values.put(BUSINESSINTRO, business.getIntro());
		values.put(BUSINESSPIC, business.getPic());
		values.put(BUSINESSTYPE, business.getType());
		values.put(USERID_IN_BUSINESS, business.getUserId());
		values.put(LATITUDE, business.getLatitude());
		values.put(LONGITUDE, business.getLongitude());
		sqliteDatabase.insert(BUSINESSTABLE_NAME, null, values);
		return 1;
	}
	
	public int delete(BusinessInfo business){
		int i = sqliteDatabase.delete(BUSINESSTABLE_NAME, BUSINESSNAME + " = '"
				+ business.getName() + "'", null);
		return i;
	}
	
	public int update(BusinessInfo business) {
		ContentValues values = new ContentValues();
		values.put(BUSINESSNAME, business.getName());
		values.put(BUSINESSINTRO, business.getIntro());
		values.put(BUSINESSPIC, business.getPic());
		values.put(BUSINESSTYPE, business.getType());
		values.put(USERID_IN_BUSINESS, business.getUserId());
		values.put(LATITUDE, business.getLatitude());
		values.put(LONGITUDE, business.getLongitude());
		return sqliteDatabase.update(BUSINESSTABLE_NAME, values, BUSINESSNAME
				+ " = '" + business.getName() + "'", null);
	}
	
	
	private class BaseDBSqlite extends SQLiteOpenHelper {
		public BaseDBSqlite(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		public void onCreate(SQLiteDatabase db) {
			db.execSQL(CREATE_ADVERTISEDB);
			db.execSQL(CREATE_BUSINESSDB);
			db.execSQL(CREATE_CARDDB);
			db.execSQL(CREATE_USERDB);

		}

		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");

			db.execSQL("DROP TABLE IF EXISTS titles");
			onCreate(db);

		}

	}
}
