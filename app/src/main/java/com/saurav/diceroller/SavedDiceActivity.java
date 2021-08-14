package com.saurav.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SavedDiceActivity extends AppCompatActivity
        implements View.OnClickListener {

    ArrayList<String> diceRolledList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_dice);

        Button deleteHistoryBtn = findViewById(R.id.deleteHistoryBtn);
        deleteHistoryBtn.setOnClickListener(this);

        Button backToHomeScreenBtn = findViewById(R.id.backToHomeScreenBtn);
        backToHomeScreenBtn.setOnClickListener(this);

        Intent intent = getIntent();
        diceRolledList = intent.getStringArrayListExtra("diceRolledOnce_key");

        ArrayAdapter adapterDiceRolledList = new ArrayAdapter(this, android.R.layout.simple_list_item_1, diceRolledList);

        ListView diceRolledHistoryListView = findViewById(R.id.diceRolledHistoryListView);
        diceRolledHistoryListView.setAdapter(adapterDiceRolledList);

    }

    public void onClick(View view){
        Intent m = new Intent(SavedDiceActivity.this, MainActivity.class);
        switch(view.getId()){
            case R.id.deleteHistoryBtn:
                diceRolledList.clear();
                Toast.makeText(this, "Dice History Cleared", Toast.LENGTH_SHORT).show();
                this.recreate();
                break;
            case R.id.backToHomeScreenBtn:
                startActivity(m);
        }
    }
}