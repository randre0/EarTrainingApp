package randre0.com.github.eartraining;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {

    private int mScore;
    private int mTotal;
    private String mDate;
    private String mExerciseType;
    private String mPercent;

    public Result(int score, int total, String percent, String date) {
        mScore = score;
        mTotal = total;
        mDate = date;
        mExerciseType = "Exercise 1";
        mPercent = percent;
    }

    public int getScore() {
        return mScore;
    }

    public int getTotal() {
        return mTotal;
    }

    public String getDate() {
        return mDate;
    }

    public String getExerciseType() {
        return mExerciseType;
    }

    public String getPercent() {
        return mPercent;
    }

}
