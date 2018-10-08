package randre0.com.github.eartraining;

import android.content.Context;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Score {

    private int mScore;
    private int mTotal;
    private Date mDate;

    public Score(Context context, int score, int total)
    {
        mScore = score;
        mTotal = total;
        mDate = Calendar.getInstance().getTime();
    }

    public int getScore() {
        return mScore;
    }

    public int getTotal() {
        return mTotal;
    }

    public String getDate() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        return df.format(mDate);
    }

    public String percentScore(){
        return String.valueOf((mScore / mTotal * 100) + "%");
    }
}
