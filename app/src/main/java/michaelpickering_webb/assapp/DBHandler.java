/*package michaelpickering_webb.assapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

/**
 * Created by michael on 4/08/2016.
 */
/*public class DBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "QuestionsAndAnswersDB.db";
    private static final String TABLE_QandA = "Questions and Answers";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_Question = "Question";
    public static final String COLUMN_Answer1 = "Answer1";
    public static final String COLUMN_Answer2 = "Answer2";
    public static final String COLUMN_Answer3 = "Answer3";
    public static final String COLUMN_Answer4 = "Answer4";
    public static final String COLUMN_Answer = "Answer";

    public DBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_QandA_TABLE = "CREATE TABLE " +
                TABLE_QandA + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_Question
                + " Question," + COLUMN_Answer1 + " Answer1, " + COLUMN_Answer2 + " Answer2, "
                + COLUMN_Answer3 + " Answer3, " + COLUMN_Answer4 + " Answer4, " + COLUMN_Answer + " Answer, "
        + ")";
        db.execSQL(CREATE_QandA_TABLE);
        Quiz.setDatabase(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QandA);
        onCreate(db);

    }

    public void addQuestion() {

        ContentValues values = new ContentValues();

            Question question = new Question();
            values.put(COLUMN_Question, question.getQuestion(0));
            values.put(COLUMN_Answer1, question.getAnswer1(0));
            values.put(COLUMN_Answer2, question.getAnswer2(0));
            values.put(COLUMN_Answer3, question.getAnswer3(0));
            values.put(COLUMN_Answer4, question.getAnswer4(0));
            values.put(COLUMN_Answer, question.getAnswer(0));

        SQLiteDatabase db = Quiz.getDatabase();

        db.insert(TABLE_QandA, null, values);
        db.close();
    }

    /*public void addQuestion(Question question) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_Question, question.getQuestion(0));
        values.put(COLUMN_Answer, question.getAnswer(0));

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_QandA, null, values);
        db.close();
    }*/

  /*  public Question findQuestion(int num, View view) {
        String query = "Select * FROM " + TABLE_QandA + " WHERE " + COLUMN_ID + " =  \"" + num + "\"";
        /*String query2 = "Select * FROM " + TABLE_QandA + " WHERE " + COLUMN_Answer1 + " =  \"" + item + "\"";
        String query3 = "Select * FROM " + TABLE_QandA + " WHERE " + COLUMN_Answer2 + " =  \"" + item + "\"";
        String query4 = "Select * FROM " + TABLE_QandA + " WHERE " + COLUMN_Answer3 + " =  \"" + item + "\"";
        String query5 = "Select * FROM " + TABLE_QandA + " WHERE " + COLUMN_Answer4 + " =  \"" + item + "\"";
        String query6 = "Select * FROM " + TABLE_QandA + " WHERE " + COLUMN_Answer + " =  \"" + item + "\"";*/

     /*   SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Question quest = new Question();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            Question.setQuestion(cursor.getString(1), view);
            Question.setAnswer1(cursor.getString(2), view);
            Question.setAnswer2(cursor.getString(3), view);
            Question.setAnswer3(cursor.getString(4), view);
            Question.setAnswer4(cursor.getString(5), view);
            Question.setAnswer(cursor.getString(6), view);
            cursor.close();
        }
        else{

            quest = null;
        }

        db.close();
        return quest;
    }
    /*public boolean checkForTables(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " +TABLE_QandA, null);

        if(cursor != null){

            cursor.moveToFirst();

            int count = cursor.getInt(0);

            if(count > 0){
                return true;
            }

            cursor.close();
        }

        return false;
    }*/
/*
}*/
