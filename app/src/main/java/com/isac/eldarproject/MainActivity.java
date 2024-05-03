package com.isac.eldarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import  android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button mainButton;
TextView isPressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainButton=(Button)findViewById(R.id.main_button);

    }
    public void clickMainButton(View view){
        Button btn= (Button)view;
        btn.setText("Pressed");
    }

}