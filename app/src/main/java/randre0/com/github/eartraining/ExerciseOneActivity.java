package randre0.com.github.eartraining;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExerciseOneActivity extends SingleFragmentActivity {

    ExerciseOneViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ExerciseOneViewModel mViewModel =
                ViewModelProviders.of(this).get(ExerciseOneViewModel.class);


    }
    @Override
    protected Fragment createFragment() {

        return ExerciseOneFragment.newInstance();
    }




}
