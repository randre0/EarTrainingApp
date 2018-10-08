package randre0.com.github.eartraining;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ScoreActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){

        return ScoreFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static Intent newIntent(Context packageContext, int score, int total){
        Intent intent = new Intent(packageContext, ScoreActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle extras = new Bundle();
        extras.putInt("TOTAL", total);
        extras.putInt("SCORE", score);
        intent.putExtras(extras);
        return intent;

    }




}
