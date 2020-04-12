package com.example.gradingapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String dbName = "Grading.db";
    public static final int version = 1;
    public static final String TABLE_NAME = "GradingApp";
    public static final String Column1 = "id";
    public static final String Column2 = "firstName";
    public static final String Column3 = "lastName";
    public static final String Column4 = "course";
    public static final String Column5 = "credits";
    public static final String Column6 = "marks";
    private static final String CREATE_TABLE_GRADING_APP =
            "CREATE TABLE " + TABLE_NAME + "(" + Column1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                              + Column2 + " TEXT NOT NULL, "
                                              + Column3 + " TEXT NOT NULL, "
                                              + Column4 + " TEXT NOT NULL, "
                                              + Column5 + " TEXT NOT NULL, "
                                              + Column6 + " TEXT NOT NULL);";
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

    // To insert the data to the database table
    public boolean insertGrade(GradeClass objGrade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        // Taking the content value instance and putting data into the columns
        //contentValues.put(Column1, objGrade.getGradeId());
        contentValues.put(Column2, objGrade.getGradeFirstName());
        contentValues.put(Column3, objGrade.getGradeLastName());
        contentValues.put(Column4, objGrade.getGradeCourse());
        contentValues.put(Column5, objGrade.getGradeCredits());
        contentValues.put(Column6, objGrade.getGradeMarks());

        // If data is not inserted then the following method will return a value "-1"
        long executionResult = db.insert(TABLE_NAME, null, contentValues);

        if (executionResult == -1) {
            return false;
        }
        else {
            return  true;
        }
    }

    // To display the date from the database table
    public Cursor viewData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    // To delete a record from the database table
    public Integer deleteRecord(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "id="+id, null);
    }

    // To update the database table
    public int updateGrade(GradeClass objGrade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        // Taking the content value instance and putting data into the columns
        //contentValues.put(Column1, objGrade.getGradeId());
        contentValues.put(Column2, objGrade.getGradeFirstName());
        contentValues.put(Column3, objGrade.getGradeLastName());
        contentValues.put(Column4, objGrade.getGradeCourse());
        contentValues.put(Column5, objGrade.getGradeCredits());
        contentValues.put(Column6, objGrade.getGradeMarks());

        int numRows = db.update(TABLE_NAME, contentValues, "id=" + objGrade.getGradeId(), null);
        return  numRows;
    }
}
