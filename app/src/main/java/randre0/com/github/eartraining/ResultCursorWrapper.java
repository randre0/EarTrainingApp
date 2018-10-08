package randre0.com.github.eartraining;

import android.database.Cursor;
import android.database.CursorWrapper;

import randre0.com.github.eartraining.database.ResultDbSchema;

import static randre0.com.github.eartraining.database.ResultDbSchema.*;

public class ResultCursorWrapper extends CursorWrapper {

    public ResultCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Result getResult() {
        Integer score =
                getInt(getColumnIndex(ResultDataTable.Cols.SCORE));
        Integer total =
                getInt(getColumnIndex(ResultDataTable.Cols.TOTAL));
        String percent =
                getString(getColumnIndex(ResultDataTable.Cols.PERCENT));
        String date =
                getString(getColumnIndex(ResultDataTable.Cols.DATE));

        return new Result(score, total, percent, date);
    }
}
