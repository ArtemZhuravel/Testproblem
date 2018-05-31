package com.example.testproblem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testproblem.util.Correctness;

public class MainActivity extends AppCompatActivity {

    private static final int NUMBER_OF_TASKS = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCheck(View view) {
        String result = null;
        TextView resultView = (TextView) findViewById(R.id.textView3);
        final EditText fView = (EditText) findViewById(R.id.f_text_view);
        final EditText NView = (EditText) findViewById(R.id.N_text_view);
        if(Correctness.checkIfValid(fView) && Correctness.checkIfValid(NView)) {
            final int f = Integer.parseInt(fView.getText().toString());
            final int N = Integer.parseInt(NView.getText().toString());
            if((f >= 1 && f <= 11) && (N >= 1 && N <= 24)) {
                int totalTime = (N - 1) * 60;
                int restTasks = 12 - f;
                for(int i = 0; i < 11; i++) {
                    if(totalTime < 0) {
                        result = "NO";
                        resultView.setText(result);
                        break;
                    }
                    if(restTasks == 0) {
                        result = "YES";
                        resultView.setText(result);
                        break;
                    }
                    totalTime = totalTime - 55;
                    restTasks--;
                }
            } else {
                Toast.makeText(view.getContext(),
                        "Check the input fields", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(view.getContext(),
                            "Check the input fields", Toast.LENGTH_SHORT).show();
        }
    }
}
