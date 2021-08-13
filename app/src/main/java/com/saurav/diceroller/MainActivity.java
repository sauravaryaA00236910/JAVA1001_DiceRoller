package com.saurav.diceroller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    private byte result;
    private byte result2;
    TextView customSidesET;
    private int customSides;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        diceSizeRG.check(R.id.d4RadioBtn);
//        RadioButton d4RadioBtn = findViewById(R.id.d4RadioBtn);
//        RadioButton d6RadioBtn = findViewById(R.id.d6RadioBtn);
//        RadioButton d8RadioBtn = findViewById(R.id.d8RadioBtn);
//        RadioButton d10RadioBtn = findViewById(R.id.d10RadioBtn);
//        RadioButton d12RadioBtn = findViewById(R.id.d12RadioBtn);
//        RadioButton d20RadioBtn = findViewById(R.id.d20RadioBtn);
        Button rollBtn1 = findViewById(R.id.rollBtn1);
        rollBtn1.setOnClickListener(this);

        Button rollBtn2 = findViewById(R.id.rollBtn2);
        rollBtn2.setOnClickListener(this);

        customSidesET = findViewById(R.id.customSidesET);

        RadioGroup diceSizeRG = findViewById(R.id.diceSizeRG);
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
                result2 = die4.roll();
                break;
            case R.id.d6RadioBtn:
                Die die6 = new Die((byte) 6);
//                result = die6.getCurrentSideUp();
                result = die6.roll();
                result2 = die6.roll();
                break;
            case R.id.d8RadioBtn:
                Die die8 = new Die((byte) 8);
//                result = die8.getCurrentSideUp();
                result = die8.roll();
                result2 = die8.roll();
                break;
            case R.id.d10RadioBtn:
                Die die10 = new Die((byte) 10);
//                result = die10.getCurrentSideUp();
                result = die10.roll();
                result2 = die10.roll();
                break;
            case R.id.d12RadioBtn:
                Die die12 = new Die((byte) 12);
//                result = die12.getCurrentSideUp();
                result = die12.roll();
                result2 = die12.roll();
                break;
            case R.id.d20RadioBtn:
                Die die20 = new Die((byte) 20);
//                result = die20.getCurrentSideUp();
                result = die20.roll();
                result2 = die20.roll();
                break;
            default:
                Toast.makeText(this, "Select the size to roll the dice by", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.rollBtn1:
                if(customSidesET.getText().toString().isEmpty()){
                    AlertDialog alertDialog1 = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog1.setTitle("Roll Result Once");
                    alertDialog1.setMessage("The result of the dice roll is: \n" + result);
                    alertDialog1.setButton(AlertDialog.BUTTON_NEUTRAL, "Go Back to Home", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog1.show();
                }else{
                    customSides = Integer.parseInt(customSidesET.getText().toString());
                    Die die = new Die ((byte) customSides);
                    result = die.roll();
//                    result2 = die.roll();

                    AlertDialog alertDialog1 = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog1.setTitle("Roll Result Once");
                    alertDialog1.setMessage("The result of the dice roll is: \n" + result);
                    alertDialog1.setButton(AlertDialog.BUTTON_NEUTRAL, "Go Back to Home", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog1.show();
                }
                break;
            case R.id.rollBtn2:
                if(customSidesET.getText().toString().isEmpty()){
                    AlertDialog alertDialog2 = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog2.setTitle("Roll Result Twice");
                    alertDialog2.setMessage("The results of two consecutive dice rolls are: \n" + result + " & " + result2);
                    alertDialog2.setButton(AlertDialog.BUTTON_NEUTRAL, "Go Back to Home", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog2.show();
                }else{
                    customSides = Integer.parseInt(customSidesET.getText().toString());
                    Die die = new Die ((byte) customSides);
                    result = die.roll();
                    result2 = die.roll();

                    AlertDialog alertDialog2 = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog2.setTitle("Roll Result Twice");
                    alertDialog2.setMessage("The results of two consecutive dice rolls are: \n" + result + " & " + result2);
                    alertDialog2.setButton(AlertDialog.BUTTON_NEUTRAL, "Go Back to Home", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog2.show();
                }
                break;
            default:
                Toast.makeText(this, "View not Implemented", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}