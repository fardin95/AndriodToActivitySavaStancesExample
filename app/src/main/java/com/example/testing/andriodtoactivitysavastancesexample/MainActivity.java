package com.example.testing.andriodtoactivitysavastancesexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btNext;
    private static final String TAG = "MainActivity";
    private EditText etInput,etInput2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ini();

        if (savedInstanceState !=null){

            String text1 =savedInstanceState.getString(UtilKey.KEY_INPUT_TEXT1);
            if (text1 != UtilKey.KEY_INPUT_TEXT1) {
                etInput.setText(text1);

            }


            String text2 =savedInstanceState.getString(UtilKey.KEY_INPUT_TEXT2);
            if (text2 != UtilKey.KEY_INPUT_TEXT2) {
                  etInput2.setText(text2);

            }



        }


    }

    private void ini() {
        btNext = (Button) findViewById(R.id.button);
        etInput = (EditText) findViewById(R.id.editText);
        etInput2 = (EditText) findViewById(R.id.editText1);
        btNext.setOnClickListener(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause() called with: " + "");

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.e(TAG, "onSaveInstanceState: " );

        if (!etInput.getText().equals("")) {
            outState.putString(UtilKey.KEY_INPUT_TEXT1, etInput.getText().toString());
        }

        if (!etInput2.getText().toString().toString().trim().equals("")){
            outState.putString(UtilKey.KEY_INPUT_TEXT2, etInput2.getText().toString());

        }

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState: " );



    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecoundActivity.class);
        startActivity(intent);


    }
}
