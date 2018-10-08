package randre0.com.github.eartraining;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class ScoreViewModel extends ViewModel {

    private float mScore;
    private float mTotal;
    private String mPercent;
    private WeakReference<Context> mContext;

    public ScoreViewModel(Score score, Context context)
    {
        mScore = score.getScore();
        mTotal = score.getTotal();
        mContext = new WeakReference<>(context);
    }

    public String percentScore(){
        return String.valueOf((int)(mScore / mTotal * 100) + "%");
    }

    public String getScore(){
        return String.valueOf(mScore);
    }

    public String getTotal(){
        return String.valueOf(mTotal);
    }

    public void returnMenu() {
        Intent intent = new Intent(mContext.get(), MenuActivity.class);
        mContext.get().startActivity(intent);
        ((AppCompatActivity)mContext.get()).finish();
    }


}
