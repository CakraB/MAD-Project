package com.cakrab.project_mobile_vcare.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "VCare";
    private static final int DATABASE_VERSION = 1;
    public final String TABLE_USER = "users";

    // User Table Column
    public final String USER_ID = "id";
    public final String USER_NAME = "name";
    public final String USER_EMAIL = "email";
    public final String USER_PASSWORD = "password";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USER + "(" +
                USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_NAME + " TEXT, " +
                USER_EMAIL + " TEXT, " +
                USER_PASSWORD + " TEXT " + ")");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_USER + "(" +
                USER_ID + ", " +
                USER_NAME + ", " +
                USER_EMAIL + " , " +
                USER_PASSWORD + ") VALUES(1, 'Admin', 'admin@gmail.com', 'admin123')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(sqLiteDatabase);
    }
}
