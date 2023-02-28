package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lab1.dice.Dice;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final Map<Integer, Integer> IMAGE_ROLL = ImmutableMap.of(
            1, R.drawable.dice_1,
            2, R.drawable.dice_2,
            3, R.drawable.dice_3,
            4, R.drawable.dice_4,
            5, R.drawable.dice_5,
            6, R.drawable.dice_6
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener((view) -> rollDice());

        rollDice();
    }

    private void rollDice() {
        Dice dice = Dice.of(6);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(IMAGE_ROLL.get(dice.roll()));
    }
}