package michaelpickering_webb.assapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.os.Handler;

import java.util.ArrayList;


public class Quiz extends AppCompatActivity {

    QandA question1 = new QandA("Which of the following does Copyright protect",
            "All of the above","Written work made by the owner","Digital work","All of the above","");
    QandA question2 = new QandA("When is Copyright initalized", "As soon as you make the product",
            "When you fill out the paper work","As soon as you make the product"
            ,"Once the product is in demand","When the product has been copied by someone else");
    QandA question3 = new QandA("The Privacy act protects you from?",
            "Your photos or information being used without permission","Your photos or information being used without permission",
            "People looking you up on facebook","Your work being stolen","None of the above");

    public int i = 0;
    ArrayList<Boolean> answerList = new ArrayList<Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        i=0;
        startQuiz();

    }

    public void startQuiz(){

        ArrayList<QandA> quizlist = getList();
        QandA quiz = quizlist.get(i);

        final TextView textViewToChange = (TextView) findViewById(R.id.textView);
        textViewToChange.setText(quiz.getQuestion());

        final TextView textViewToChange1 = (TextView) findViewById(R.id.checkBox);
        textViewToChange1.setText(quiz.getAnswer1());
        if(quiz.getAnswer1() == ""){
            textViewToChange1.setVisibility(View.INVISIBLE);
        }
        else{
            textViewToChange1.setVisibility(View.VISIBLE);
        }

        final TextView textViewToChange2 = (TextView) findViewById(R.id.checkBox2);
        textViewToChange2.setText(quiz.getAnswer2());
        if(quiz.getAnswer2() == ""){
            textViewToChange2.setVisibility(View.INVISIBLE);
        }
        else{
            textViewToChange2.setVisibility(View.VISIBLE);
        }

        final TextView textViewToChange3 = (TextView) findViewById(R.id.checkBox3);
        textViewToChange3.setText(quiz.getAnswer3());
        if(quiz.getAnswer3() == ""){
            textViewToChange3.setVisibility(View.INVISIBLE);
        }
        else{
            textViewToChange3.setVisibility(View.VISIBLE);
        }

        final TextView textViewToChange4 = (TextView) findViewById(R.id.checkBox4);
        textViewToChange4.setText(quiz.getAnswer4());
        if(quiz.getAnswer4() == ""){
            textViewToChange4.setVisibility(View.INVISIBLE);
        }
        else{
            textViewToChange4.setVisibility(View.VISIBLE);
        }


    }

    public ArrayList<QandA> getList(){

        ArrayList<QandA> QnAList = new ArrayList<QandA>();
        QnAList.add(question1);
        QnAList.add(question2);
        QnAList.add(question3);

        return QnAList;

    }

    public ArrayList<Boolean> getAnswerList(){

        ArrayList<Boolean> boolList = answerList;

        return boolList;

    }


    public void onButtonClickCancel(View view) {

        final ArrayList<QandA> quizlist = getList();
        QandA quiz = quizlist.get(i);


        if(getAnswered() == quiz.getAnswer()){

            final TextView textViewToChange = (TextView) findViewById(R.id.textView2);
            textViewToChange.setVisibility(View.VISIBLE);
            textViewToChange.setText("Correct");
            textViewToChange.setTextColor(Color.parseColor("#006F00"));
            textViewToChange.setBackgroundColor(Color.parseColor("#00FF00"));
            answerList.add(true);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {

                    final TextView textViewToChange = (TextView) findViewById(R.id.textView2);
                    textViewToChange.setText("");
                    textViewToChange.setVisibility(View.INVISIBLE);
                    if(i < (quizlist.size()-1)){

                        i++;
                        startQuiz();

                    }
                    else{

                        Intent intent = new Intent(Quiz.this,highScore.class);
                        startActivity(intent);

                    }


                }
            }, 2000);

        }
        else{

            final TextView textViewToChange = (TextView) findViewById(R.id.textView2);
            textViewToChange.setVisibility(View.VISIBLE);
            textViewToChange.setText("Incorrect, Try Again");
            textViewToChange.setTextColor(Color.parseColor("#1F0000"));
            textViewToChange.setBackgroundColor(Color.parseColor("#FF0000"));
            answerList.add(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {

                    final TextView textViewToChange = (TextView) findViewById(R.id.textView2);
                    textViewToChange.setText("");
                    textViewToChange.setVisibility(View.INVISIBLE);
                    if(i < (quizlist.size()-1)){

                        i++;
                        startQuiz();

                    }
                    else{

                        Intent intent = new Intent(Quiz.this,highScore.class);
                        startActivity(intent);

                    }


                }
            }, 2000);

        }


    }

    public String getAnswered(){

        String myAnswer = "";
        CheckBox ch;

        if(((CheckBox) findViewById(R.id.checkBox)).isChecked()){

            final TextView textViewToChange5 = (TextView) findViewById(R.id.checkBox);
            myAnswer = (String) textViewToChange5.getText();
            ch =(CheckBox) findViewById(R.id.checkBox);
            ch.setChecked(false);

        }
        else if(((CheckBox) findViewById(R.id.checkBox2)).isChecked()){

            final TextView textViewToChange5 = (TextView) findViewById(R.id.checkBox2);
            myAnswer = (String) textViewToChange5.getText();
            ch =(CheckBox) findViewById(R.id.checkBox2);
            ch.setChecked(false);

        }
        else if(((CheckBox) findViewById(R.id.checkBox3)).isChecked()){

            final TextView textViewToChange5 = (TextView) findViewById(R.id.checkBox3);
            myAnswer = (String) textViewToChange5.getText();
            ch =(CheckBox) findViewById(R.id.checkBox3);
            ch.setChecked(false);

        }
        else if(((CheckBox) findViewById(R.id.checkBox4)).isChecked()){

            final TextView textViewToChange5 = (TextView) findViewById(R.id.checkBox4);
            myAnswer = (String) textViewToChange5.getText();
            ch =(CheckBox) findViewById(R.id.checkBox4);
            ch.setChecked(false);

        }


        return myAnswer;

    }


        public void onCheckBox(View view) {
            // Is the view now checked?
            boolean checked = ((CheckBox) view).isChecked();

            // Check which checkbox was clicked
            switch(view.getId()) {
                case R.id.checkBox:
                    if (checked) {

                        CheckBox ch3,ch2,ch4;
                        ch3 = (CheckBox) findViewById(R.id.checkBox3);
                        ch3.setSelected(false);
                        ch3.setChecked(false);
                        ch2 = (CheckBox) findViewById(R.id.checkBox2);
                        ch2.setSelected(false);
                        ch2.setChecked(false);
                        ch4 = (CheckBox) findViewById(R.id.checkBox4);
                        ch4.setSelected(false);
                        ch4.setChecked(false);
                    }

                    break;
                case R.id.checkBox2:
                    if (checked) {

                        CheckBox ch,ch3,ch4;
                        ch = (CheckBox) findViewById(R.id.checkBox);
                        ch.setSelected(false);
                        ch.setChecked(false);
                        ch3 = (CheckBox) findViewById(R.id.checkBox3);
                        ch3.setSelected(false);
                        ch3.setChecked(false);
                        ch4 = (CheckBox) findViewById(R.id.checkBox4);
                        ch4.setSelected(false);
                        ch4.setChecked(false);
                    }

                    break;
                case R.id.checkBox3:
                    if (checked) {
                        CheckBox ch,ch2,ch4;
                        ch = (CheckBox) findViewById(R.id.checkBox);
                        ch.setSelected(false);
                        ch.setChecked(false);
                        ch2 = (CheckBox) findViewById(R.id.checkBox2);
                        ch2.setSelected(false);
                        ch2.setChecked(false);
                        ch4 = (CheckBox) findViewById(R.id.checkBox4);
                        ch4.setSelected(false);
                        ch4.setChecked(false);
                    }


                    break;
                case R.id.checkBox4:
                    if (checked) {

                        CheckBox ch,ch2,ch3;
                        ch = (CheckBox) findViewById(R.id.checkBox);
                        ch.setSelected(false);
                        ch.setChecked(false);
                        ch2 = (CheckBox) findViewById(R.id.checkBox2);
                        ch2.setSelected(false);
                        ch2.setChecked(false);
                        ch3 = (CheckBox) findViewById(R.id.checkBox3);
                        ch3.setSelected(false);
                        ch3.setChecked(false);
                    }

                    break;

            }
        }


    }

