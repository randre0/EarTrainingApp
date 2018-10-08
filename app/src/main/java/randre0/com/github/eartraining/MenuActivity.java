package randre0.com.github.eartraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity{

    private Button mStartButton;
    private Button mScoresButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mStartButton = findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MenuActivity.this,
                        ExerciseOneActivity.class);
                MenuActivity.this.startActivity(intent);
                finish();
            }
        });

        mScoresButton = findViewById(R.id.score_button);
        mScoresButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,
                        ResultsListActivity.class);
                MenuActivity.this.startActivity(intent);

            }
        });

    }

}
