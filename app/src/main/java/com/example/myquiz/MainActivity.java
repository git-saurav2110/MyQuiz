package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_true;
    private Button btn_false;
    private TextView questionTV;

    private ImageButton nextButton;
    private int currentQuestionindex=0;

    private Questions[] questionBank=new Questions[]{
      new Questions(R.string.question_declaration,true),
      new Questions(R.string.question_pm,false),
      new Questions(R.string.qusetion_jalia,true),
      new Questions(R.string.question_president,true),
            new Questions(R.string.question_republic,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Questions questions=new Questions(R.string.question_declaration,true);

        btn_false=findViewById(R.id.btn_false);
        btn_true=findViewById(R.id.btn_true);
        questionTV=findViewById(R.id.answer_text_view);
        nextButton=findViewById(R.id.btn_next);

        btn_true.setOnClickListener(this);
        btn_false.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_false:
                checkAnswer(false);break;

            case R.id.btn_true:
               checkAnswer(true);
                break;

            case R.id.btn_next:
                //go to next question
                currentQuestionindex=(currentQuestionindex+1) %questionBank.length;
                updateQuestion();
        }
    }


    public void updateQuestion(){
        Log.d("next", "on click :"+currentQuestionindex);
        questionTV.setText(questionBank[currentQuestionindex].getAnswerResId());
    }
    private void checkAnswer(boolean userChooseCorrect){
        boolean answerIsTrue=questionBank[currentQuestionindex].getAnswertrue();

        int toastmessageId=0;

        if(userChooseCorrect==answerIsTrue)
            toastmessageId=R.string.correct_answer;
        else
            toastmessageId=R.string.wrong_answer;
        Toast.makeText(getApplicationContext(),toastmessageId,Toast.LENGTH_SHORT).show();

    }
}
