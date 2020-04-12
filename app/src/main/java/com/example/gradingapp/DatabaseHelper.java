package com.example.gradingapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String dbName = "Company.db";
    public static final int version = 1;
    public static final String TABLE_NAME = "Employee";
    public static final String Column1 = "id";
    public static final String Column2 = "firstName";
    public static final String Column3 = "lastName";
    public static final String Column4 = "course";
    public static final String Column5 = "credits";
    public static final String Column6 = "marks";
    private static final String CREATE_TABLE_GRADING_APP =
            "CREATE TABLE " + TABLE_NAME + "(" + Column1 + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                                              + Column2 + "TEXT NOT NULL,"
                                              + Column3 + "TEXT NOT NULL,"
                                              + Column4 + "TEXT NOT NULL,"
                                              + Column5 + "TEXT NOT NULL,"
                                              + Column6 + "TEXT NOT NULL);";
    private static final String DROP_TABLE_GRADING_APP = "DROP TABLE IF EXISTS " + TABLE_NAME;

    // CONSTRUCTOR This method is invoked automatically when instance of this class is created
    // At the same time the database will also be created
    public DatabaseHelper (@Nullable Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_GRADING_APP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_GRADING_APP);
        onCreate(db);
    }

    public boolean insertGrade(Emp objGrade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put();
        contentValues.put();
        contentValues.put();
        contentValues.put();
        contentValues.put();
        contentValues.put();
    }

    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();

}
