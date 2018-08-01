package randre0.com.github.eartraining;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExerciseOneActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return ExerciseOneFragment.newInstance();
    }

}
