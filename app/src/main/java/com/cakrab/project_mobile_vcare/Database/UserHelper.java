package com.cakrab.project_mobile_vcare.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserHelper {
    private final DatabaseHelper databaseHelper;
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
        return queryResult != -1;
    }

    public boolean readUser (String email, String password) {
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        String sql = "SELECT * FROM " + databaseHelper.TABLE_USER + " WHERE email= ?"  + " AND password= ?" ;
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{email, password});
        cursor.moveToLast();
        return cursor.getCount() > 0;
    }

    public boolean updateUser(String id, String name, String email, String password) {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long queryResult = sqLiteDatabase.update(databaseHelper.TABLE_USER, contentValues, "id = ?", new String[]{id});
        // If Something Wrong return false
        return queryResult > 0;
    }

    public boolean updateProfile(String id, String name, String email, String password) {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);

        int result = sqLiteDatabase.update(databaseHelper.TABLE_USER, contentValues, "id = ?", new String[]{id});
        return (result > 0) ? true : false;
    }

    public boolean deleteUser(String id) {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        long queryResult = sqLiteDatabase.delete(databaseHelper.TABLE_USER, "id = ?", new String[]{id});
        // If Something Wrong return false
        return queryResult > 0;
    }

    public void close() {
        sqLiteDatabase.close();
    }
}
