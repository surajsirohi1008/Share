package com.example.surajsirohi1008.sharebear;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userNameInput;
    EditText passwordInput;
    TextView dataTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameInput= (EditText) findViewById(R.id.userNameInput);
        passwordInput  = (EditText) findViewById(R.id.passwordInput);
        dataTextView = (TextView) findViewById(R.id.dataTextView);

    }

    //save the login info
    public  void saveData(View view){
        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);


        SharedPreferences.Editor editor  = sharedPref.edit();
        editor.putString("username", userNameInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();

    }

    //print out the saved data
    public void getData(View view){
        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("username", "");
        String pw = sharedPref.getString("password","");
        dataTextView.setText(name +" "+ pw);
    }



}
