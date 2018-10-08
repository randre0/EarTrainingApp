package randre0.com.github.eartraining;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import randre0.com.github.eartraining.databinding.FragmentExerciseOneBinding;

public class ExerciseOneFragment extends Fragment {

    private ExerciseOne mExerciseOne;
    private ExerciseOneViewModel mViewModel;

    public static ExerciseOneFragment newInstance() {
        return new ExerciseOneFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mExerciseOne = new ExerciseOne(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentExerciseOneBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_exercise_one, container, false);
        mViewModel =
                ViewModelProviders.of(getActivity()).get(ExerciseOneViewModel.class);
        mViewModel.newFragment(mExerciseOne, getContext());
        binding.setViewModel(mViewModel);
        return binding.getRoot();

    }
}
