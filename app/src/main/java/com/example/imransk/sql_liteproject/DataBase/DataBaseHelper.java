package com.example.imransk.sql_liteproject.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static int DATA_BASE_VERSION = 1;

    public static String DATA_BASE_ID="User_ID";
    public static String DATA_BASE_NAME = "Information";
    public static String DATA_BASE_TABLE_NAME = "User_Information";

    public static String COL_NAME = "Name";
    public static String COL_EMAIL = "Email";
    public static String COL_PHONE = "Phone";


    public static String CREATE_TABLE = "CREATE TABLE " + DATA_BASE_TABLE_NAME + " ( " + DATA_BASE_ID +
            " INTEGER PRIMARY KEY, " + COL_NAME + " TEXT NOT NULL," + COL_EMAIL + " TEXT NOT NULL," +
            COL_PHONE + " TEXT NOT NULL );";


    public DataBaseHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
