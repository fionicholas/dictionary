package com.unsera.myperloaddata.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.unsera.myperloaddata.R;

public class DetailActivity extends AppCompatActivity {

    TextView word, translate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        word = findViewById(R.id.kata);
        translate = findViewById(R.id.terjemah);

        Intent intentThatStartedThisActivity = getIntent();
        if(intentThatStartedThisActivity.hasExtra("word")){


            String wordFragment = getIntent().getExtras().getString("word");
            String translateFragment = getIntent().getExtras().getString("translate");


            word.setText(wordFragment);
            translate.setText(translateFragment);
        } else {
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        }
    }
    }

