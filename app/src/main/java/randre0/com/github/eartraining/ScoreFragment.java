package randre0.com.github.eartraining;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import randre0.com.github.eartraining.databinding.FragmentExerciseOneBinding;
import randre0.com.github.eartraining.databinding.FragmentScoreBinding;

public class ScoreFragment extends Fragment {

    private ScoreViewModel mViewModel;
    private Score mScore;
    private Result mResult;

    public static ScoreFragment newInstance(){
        return new ScoreFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getActivity().getIntent();
        Bundle extras = intent.getExtras();
        int score = extras.getInt("SCORE");
        int total = extras.getInt("TOTAL");
        mScore = new Score(getActivity(), score, total);
        mResult = new Result(score, total, mScore.percentScore(), mScore.getDate());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentScoreBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_score, container, false);
        mViewModel = new ScoreViewModel(mScore, getContext());
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onPause() {
        super.onPause();
        ResultsList.get(getActivity()).addResult(mResult);
    }
}
