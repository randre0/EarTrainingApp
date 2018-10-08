package randre0.com.github.eartraining;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import randre0.com.github.eartraining.database.ResultDbSchema;
import randre0.com.github.eartraining.database.ResultDbSchema.ResultDataTable;

public class ResultsList {

    private static ResultsList sResultsList;
    private WeakReference<Context> mContext;
    private SQLiteDatabase mDatabase;

    public static ResultsList get(Context context) {
        if (sResultsList == null) {
            sResultsList = new ResultsList(context);
        }
            return sResultsList;
    }

    public ResultsList(Context context){
        mContext = new WeakReference<>(context.getApplicationContext());
        mDatabase = new ResultBaseHelper(mContext.get())
                .getWritableDatabase();
    }

    private static ContentValues getContentValues(Result result) {
        ContentValues values = new ContentValues();
        values.put(ResultDataTable.Cols.TITLE,
                result.getExerciseType());
        values.put(ResultDataTable.Cols.DATE,
                result.getDate());
        values.put(ResultDataTable.Cols.SCORE,
                result.getScore());
        values.put(ResultDataTable.Cols.TOTAL,
                result.getTotal());
        values.put(ResultDataTable.Cols.PERCENT,
                result.getPercent());
        return values;
    }

    public void addResult(Result r) {
        ContentValues values = getContentValues(r);

        mDatabase.insert(ResultDataTable.NAME, null, values);

    }

    public List<Result> getResultsList() {

        List<Result> results = new ArrayList<>();

        ResultCursorWrapper cursor = queryResults(null, null);

        try{
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                results.add(cursor.getResult());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return results;
    }

    private ResultCursorWrapper queryResults(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ResultDataTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new ResultCursorWrapper(cursor);

    }

}
