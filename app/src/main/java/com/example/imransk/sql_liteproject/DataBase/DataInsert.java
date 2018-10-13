package com.example.imransk.sql_liteproject.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.imransk.sql_liteproject.PojoClass.User_Information;

import java.util.ArrayList;

public class DataInsert {

    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;


    public DataInsert(Context context) {

        dataBaseHelper = new DataBaseHelper(context);

    }

    public void open() {
        db = dataBaseHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public boolean insertData(User_Information user_information) {
        this.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COL_NAME, user_information.getName());
        contentValues.put(DataBaseHelper.COL_EMAIL, user_information.getEmail());
        contentValues.put(DataBaseHelper.COL_PHONE, user_information.getPhone());
        long number = db.insert(DataBaseHelper.DATA_BASE_TABLE_NAME, null, contentValues);
        this.close();
        if (number > 0) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList<User_Information> get_Data() {

        ArrayList<User_Information> user_informations = new ArrayList<>();
        this.open();
        Cursor cursor = db.query(dataBaseHelper.DATA_BASE_TABLE_NAME, null, null, null,
                null, null, null);

        if (cursor.getCount() > 0 && cursor != null) {
            cursor.moveToFirst();
            do {
                int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.DATA_BASE_ID));
                String name = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_NAME));
                String email = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_EMAIL));
                String phone = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_PHONE));
                user_informations.add(new User_Information(name, email, phone, id));

            } while (cursor.moveToNext());
        }
        return user_informations;
    }

    public boolean deleteUser(int id) {
        this.open();
        int deleteRow = db.delete(DataBaseHelper.DATA_BASE_TABLE_NAME, DataBaseHelper.DATA_BASE_ID + "=" + id, null);
        if (deleteRow > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateUser(User_Information user_information) {

        this.open();
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.DATA_BASE_ID, user_information.getId());
        values.put(DataBaseHelper.COL_EMAIL, user_information.getEmail());
        values.put(DataBaseHelper.COL_NAME, user_information.getName());
        values.put(DataBaseHelper.COL_PHONE, user_information.getPhone());

        int updateRow = db.update(DataBaseHelper.DATA_BASE_TABLE_NAME, values, DataBaseHelper.DATA_BASE_ID + "=" + user_information.getId(), null);

        this.close();

        if (updateRow > 0) {
            return true;
        } else {
            return false;
        }


    }
}
