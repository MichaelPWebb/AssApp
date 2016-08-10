package michaelpickering_webb.assapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    public static SQLiteDatabase DATABASE;

    public DBHandler database = new DBHandler(Quiz.this, "Database", null, 1);

    public Quiz() {

        database.addQuestion();

    }



    public static void setDatabase(SQLiteDatabase db){

        DATABASE = db;
    }

    public static SQLiteDatabase getDatabase(){

        return DATABASE;
    }
    int i = 0;


    public void onButtonClickCancel(View view) {

        database.findQuestion(1, view);

        if (((CheckBox) findViewById(R.id.checkBox)).isChecked()) {


        } else if (((CheckBox) findViewById(R.id.checkBox2)).isChecked()) {


        } else if (((CheckBox) findViewById(R.id.checkBox3)).isChecked()) {


        } else if (((CheckBox) findViewById(R.id.checkBox4)).isChecked()) {


        }
    }

    public void onCheckBox(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBox:
                if (checked) {

                    CheckBox ch3, ch2, ch4;
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

                    CheckBox ch, ch3, ch4;
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
                    CheckBox ch, ch2, ch4;
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

                    CheckBox ch, ch2, ch3;
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


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Quiz Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://michaelpickering_webb.assapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Quiz Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://michaelpickering_webb.assapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

