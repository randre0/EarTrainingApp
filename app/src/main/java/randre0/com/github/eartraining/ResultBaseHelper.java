package randre0.com.github.eartraining;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import randre0.com.github.eartraining.database.ResultDbSchema;
import randre0.com.github.eartraining.database.ResultDbSchema.ResultDataTable;

public class ResultBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "resultBase.db";

    public ResultBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + ResultDataTable.NAME +"("
                + " _id integer primary key autoincrement, "
                + ResultDataTable.Cols.TITLE + ", "
                + ResultDataTable.Cols.DATE + ", "
                + ResultDataTable.Cols.SCORE + ", "
                + ResultDataTable.Cols.TOTAL + ", "
                + ResultDataTable.Cols.PERCENT +
                ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
