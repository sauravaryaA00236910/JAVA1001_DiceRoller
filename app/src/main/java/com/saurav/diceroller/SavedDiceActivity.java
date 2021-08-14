package com.saurav.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SavedDiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_dice);

        Intent intent = getIntent();
        ArrayList<String> diceRolledOnceList = intent.getStringArrayListExtra("diceRolledOnce_key");

        ArrayAdapter adapterDiceRolledOnceList = new ArrayAdapter(this, android.R.layout.simple_list_item_1, diceRolledOnceList);

        ListView diceRolledOnceListView = findViewById(R.id.diceRolledHistoryListView);
        diceRolledOnceListView.setAdapter(adapterDiceRolledOnceList);

    }
}