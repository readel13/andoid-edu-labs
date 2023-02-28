package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2.databinding.ActivityMainBinding;
import com.google.common.collect.ImmutableMap;

import java.text.NumberFormat;
import java.util.Map;

public class TipService {

    private static final Map<Integer, Double> RADIO_BUTTON_PERCENTAGE_MAP = ImmutableMap.of(
            R.id.option_twenty_percent, 0.20,
            R.id.option_eighteen_percent, 0.18,
            R.id.option_fifteen_percent, 0.15
    );

    public static void calculateTip(AppCompatActivity activity, ActivityMainBinding binding) {
        int costOfService = Integer.parseInt(binding.costOfService.getText().toString());
        double percentage = RADIO_BUTTON_PERCENTAGE_MAP.getOrDefault(binding.tipOptions.getCheckedRadioButtonId(), 0.0);

        boolean roundUp = binding.roundUpSwitch.isChecked();

        double tip = roundUp ? Math.ceil(percentage * costOfService) : percentage * costOfService;
        String formattedTip = NumberFormat.getCurrencyInstance().format(tip);
        String tipAmountTemplate = activity.getResources().getString(R.string.tip_amount);

        binding.tipResult.setText(String.format(tipAmountTemplate, formattedTip));
    }
}
