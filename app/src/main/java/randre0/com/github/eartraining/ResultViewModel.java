package randre0.com.github.eartraining;

import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class ResultViewModel extends BaseObservable {
    private Result mResult;
    private ResultsList mResultsList;

    public ResultViewModel(ResultsList resultsList){
        mResultsList = resultsList;
    }

    public Result getResult(){
        return mResult;
    }

    public void setResult(Result result) {
        mResult = result;
        notifyChange();
    }

    @Bindable
    public String getDate() {
        return String.valueOf(mResult.getDate());
    }

    @Bindable
    public String getScore() {
        return String.valueOf(mResult.getScore());
    }

    @Bindable
    public String getTotal(){
        return String.valueOf(mResult.getTotal());
    }

    @Bindable
    public String getPercent(){
        return mResult.getPercent();
    }

    @Bindable
    public String getExerciseType(){
        return mResult.getExerciseType();
    }

    @Bindable
    public String getScoreRatio(){
        return getScore() + "/" + getTotal() + "     " + getPercent();
    }

}
