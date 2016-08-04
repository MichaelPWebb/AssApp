package michaelpickering_webb.assapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    /*public void CheckChecked(){

        for(int i = 1; i <=4; i++){

            String num = Integer.toString(i);
            String box = "A"+num;

            final TextView textViewToChange = (TextView) findViewById(R.id.textView);
            textViewToChange.setText(box);
        }

    }*/

    public void onButtonClickCancel(View view) {



            if(((CheckBox) findViewById(R.id.checkBox)).isChecked()){

                String num = Integer.toString(1);
                String box = "A"+num;

                final TextView textViewToChange = (TextView) findViewById(R.id.textView);
                textViewToChange.setText(box);

            }
            else if(((CheckBox) findViewById(R.id.checkBox2)).isChecked()){

                String num = Integer.toString(2);
                String box = "A"+num;

                final TextView textViewToChange = (TextView) findViewById(R.id.textView);
                textViewToChange.setText(box);

            }
            else if(((CheckBox) findViewById(R.id.checkBox3)).isChecked()){

                String num = Integer.toString(3);
                String box = "A"+num;

                final TextView textViewToChange = (TextView) findViewById(R.id.textView);
                textViewToChange.setText(box);

            }
            else if(((CheckBox) findViewById(R.id.checkBox4)).isChecked()){

                String num = Integer.toString(4);
                String box = "A"+num;

                final TextView textViewToChange = (TextView) findViewById(R.id.textView);
                textViewToChange.setText(box);


        }
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

