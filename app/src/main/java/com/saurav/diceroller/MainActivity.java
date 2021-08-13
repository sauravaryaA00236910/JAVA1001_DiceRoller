package com.saurav.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    private byte result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup diceSizeRG = findViewById(R.id.diceSizeRG);
        diceSizeRG.check(R.id.d4RadioBtn);
//        RadioButton d4RadioBtn = findViewById(R.id.d4RadioBtn);
//        RadioButton d6RadioBtn = findViewById(R.id.d6RadioBtn);
//        RadioButton d8RadioBtn = findViewById(R.id.d8RadioBtn);
//        RadioButton d10RadioBtn = findViewById(R.id.d10RadioBtn);
//        RadioButton d12RadioBtn = findViewById(R.id.d12RadioBtn);
//        RadioButton d20RadioBtn = findViewById(R.id.d20RadioBtn);
        Button rollBtn = findViewById(R.id.rollBtn);
        rollBtn.setOnClickListener(this);
        try{
//            setting onCheckedChange listener to the radio group
            diceSizeRG.setOnCheckedChangeListener(this);
        }
        catch(Exception e){
            Log.e("RadioGroupError", e.getStackTrace().toString());
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId){
            case R.id.d4RadioBtn:
                Die die4 = new Die((byte) 4);
//                result = die4.getCurrentSideUp();
                result = die4.roll();
                break;
            case R.id.d6RadioBtn:
                Die die6 = new Die((byte) 6);
//                result = die6.getCurrentSideUp();
                result = die6.roll();
                break;
            case R.id.d8RadioBtn:
                Die die8 = new Die((byte) 8);
//                result = die8.getCurrentSideUp();
                result = die8.roll();
                break;
            case R.id.d10RadioBtn:
                Die die10 = new Die((byte) 10);
//                result = die10.getCurrentSideUp();
                result = die10.roll();
                break;
            case R.id.d12RadioBtn:
                Die die12 = new Die((byte) 12);
//                result = die12.getCurrentSideUp();
                result = die12.roll();
                break;
            case R.id.d20RadioBtn:
                Die die20 = new Die((byte) 20);
//                result = die20.getCurrentSideUp();
                result = die20.roll();
                break;
            default:
                Toast.makeText(this, "Select the size to roll the dice by", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.rollBtn:
                Toast.makeText(this, "die roll result is " + result, Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "View not Implemented", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}