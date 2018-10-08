package randre0.com.github.eartraining;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ExerciseOneViewModel extends ViewModel {
        private Sound mSound;
        private ExerciseOne mExerciseOne;
        private WeakReference<Context> mContext;
        private Integer mQuestionNumber;
        private Integer mExerciseLength;
        private List<Integer> mScore = new ArrayList<>();

        public String number;



        public void newFragment(ExerciseOne exerciseOne, Context context){
            mExerciseLength = 25;
            if (mQuestionNumber == null) {
                mQuestionNumber = 1;
            }
            number = String.valueOf(mQuestionNumber);
            mContext = new WeakReference<>(context);
            mExerciseOne = exerciseOne;
        }

        public void playCadence() {
            mExerciseOne.play(mExerciseOne.getCadenceSound());
        }

        public void playQuestion() {
            mExerciseOne.play(mExerciseOne.getQuestionSound());
        }

        public void playAnswer(int note) {
            mExerciseOne.play(mExerciseOne.getAnswerSounds().get(note));
            if(mExerciseOne.getSolution() == note)
            {
                mScore.add(1);
            }
            else
            {
                mScore.add(0);
            }
            launchNextQuestion();
        }

        private void launchNextQuestion() {
            if (mQuestionNumber < mExerciseLength) {
                mQuestionNumber += 1;
                ExerciseOneFragment nextFrag = new ExerciseOneFragment();
                ((AppCompatActivity)mContext.get()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag)
                        .addToBackStack(null)
                        .commit();
            }
            else{
                Intent intent = ScoreActivity.newIntent(mContext.get(), correctCount(), mExerciseLength);
                mContext.get().startActivity(intent);
                ((AppCompatActivity)mContext.get()).finish();
            }



        }

        public int correctCount() {
            int score = 0;
            for(int answer : mScore)
            {
                score += answer;
            }

            return score;
        }

    }
