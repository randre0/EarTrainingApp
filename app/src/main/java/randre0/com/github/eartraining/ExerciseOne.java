package randre0.com.github.eartraining;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExerciseOne {
    private static final String TAG = "ExerciseOne";

    private static final int MAX_SOUNDS = 5;

    private String soundsFolder;
    private AssetManager mAssets;
    private List<Sound> mAnswerSounds = new ArrayList<>();
    private List<Sound> mQuestionsSounds = new ArrayList<>();
    private Sound mCadenceSound;
    private Sound mQuestionSound;
    private int mSolution;
    private SoundPool mSoundPool;
    private Random rand;

    public ExerciseOne(Context context) {
        rand = new Random();
        mAssets = context.getAssets();
        soundsFolder = "exercise_1";
        mSoundPool = new SoundPool(MAX_SOUNDS,
                AudioManager.STREAM_MUSIC, 0);
        loadCadenceSound();
        loadAnswerSounds();
        loadQuestionSound();
    }

    private void loadAnswerSounds(){
        String[] soundNames;
        String filesPath;
        try{
            filesPath = soundsFolder + "/" + "C_major" + "/"
                    + "answer" + "/" + "C3-C4";
            soundNames = mAssets.list(filesPath);
        }
        catch (IOException ioe) {
            Log.e(TAG, "Could not list answer assets", ioe);
            return;
        }

        for (String filename: soundNames) {
            try {
                String assetPath = filesPath + "/" + filename;
                Sound sound = new Sound(assetPath);
                load(sound);
                mAnswerSounds.add(sound);
            }
            catch (IOException ioe) {
                Log.e(TAG, "Could not load sound " + filename, ioe);
            }
        }

    }

    private void loadQuestionSound() {
        String[] soundNames;
        String filesPath;
        try {
            filesPath = soundsFolder + "/" + "C_major" + "/"
                    + "question" + "/" + "C3-C4";
            soundNames = mAssets.list(filesPath);
        } catch (IOException ioe) {
            Log.e(TAG, "Could not list question assets", ioe);
            return;
        }

        for (String filename : soundNames) {
            String assetPath = filesPath + "/" + filename;
            Sound sound = new Sound(assetPath);
            mQuestionsSounds.add(sound);
        }
        mSolution = rand.nextInt(8);
        mQuestionSound = mQuestionsSounds.get(mSolution);
        try {
            load(mQuestionSound);
        } catch (IOException ioe) {
            Log.e(TAG, "Could not load sound " +
                    mQuestionSound.getName(), ioe);
        }
    }

    private void loadCadenceSound() {
        String[] soundNames;
        String filesPath;
        String filename;
        try {
            filesPath = soundsFolder + "/" + "C_major";
            soundNames = mAssets.list(filesPath);
        } catch (IOException ioe) {
            Log.e(TAG, "Could not list question assets", ioe);
            return;
        }

        filename = soundNames[0];
        String assetPath = filesPath + "/" + filename;
        mCadenceSound = new Sound(assetPath);


        try {
            load(mCadenceSound);
        } catch (IOException ioe) {
            Log.e(TAG, "Could not load sound " +
                    mCadenceSound.getName(), ioe);
            }

    }

    private void load(Sound sound) throws IOException
    {
        AssetFileDescriptor afd =
                mAssets.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd, 1);
        sound.setSoundId(soundId);
    }

    public void play(Sound sound) {
        Integer soundId = sound.getSoundId();
        if (soundId == null) {
            return;
        }

        mSoundPool.play(soundId, 1.0f, 10.f, 1, 0, 1.0f);
    }


    public List<Sound> getAnswerSounds() {
        return mAnswerSounds;
    }

    public Sound getQuestionSound() {
        return mQuestionSound;
    }

    public Sound getCadenceSound() {
        return mCadenceSound;
    }

    public int getSolution(){
        return mSolution;
    }
}
