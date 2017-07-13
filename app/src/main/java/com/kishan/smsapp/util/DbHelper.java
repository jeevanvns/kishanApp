package com.kishan.smsapp.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kishan.smsapp.model.SmsHistoryInfo;

import java.util.ArrayList;

/**
 * Created by Jeevan on 7/13/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "KisanApp";
    //Table Name
    private static final String TABLE_SMS_HISTORY = "table_sms_history";

    private static final String KEY_NAME = "name";
    private static final String KEY_CONTACT_NO = "contact_no";
    private static final String KEY_MSG = "msg";
    private static final String KEY_TIME_STAMP = "time_stamp";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SMS_HISTORY_TABLE = "CREATE TABLE " + TABLE_SMS_HISTORY + "("
                + KEY_CONTACT_NO +
                " TEXT," + KEY_NAME +
                " TEXT," + KEY_MSG +
                " TEXT," + KEY_TIME_STAMP +
                " DATETIME DEFAULT CURRENT_TIMESTAMP" + ")";
        db.execSQL(CREATE_SMS_HISTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SMS_HISTORY);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }


    public void onClear() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SMS_HISTORY);
        onCreate(db);
    }


    public void addAction(SmsHistoryInfo info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CONTACT_NO, info.getContactNo());
        values.put(KEY_NAME, info.getName());
        values.put(KEY_MSG, info.getMsg());
        db.insert(TABLE_SMS_HISTORY, null, values);
        db.close(); // Closing database connection
    }


    public ArrayList<SmsHistoryInfo> getHistoryReport() {
        ArrayList<SmsHistoryInfo> formData = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_SMS_HISTORY + " ORDER BY " + KEY_TIME_STAMP + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                SmsHistoryInfo data = new SmsHistoryInfo();
                data.setContactNo(cursor.getString(0));
                data.setName(cursor.getString(1));
                data.setMsg(cursor.getString(2));
                data.setTimeStamp(cursor.getString(3));
                formData.add(data);
            } while (cursor.moveToNext());
        }
        return formData;
    }


    public int getSMSCount() {
        String countQuery = "SELECT  * FROM " + TABLE_SMS_HISTORY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        return count;
    }


}
