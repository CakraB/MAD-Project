package com.cakrab.project_mobile_vcare.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UserHelper {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;

    public UserHelper(Context context) {
        this.databaseHelper = new DatabaseHelper(context);
    }

    public boolean createUser(String name, String email, String password) {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long queryResult = sqLiteDatabase.insert(databaseHelper.TABLE_USER, null, contentValues);
        // If Something Wrong return false
        if (queryResult == -1) {
            return false;
        }
        return true;
    }
}
