package com.example.desent.desent.models;

import android.content.Context;

import com.example.desent.desent.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by celine on 29/06/17.
 */

public class Expenses extends Indicator {

    public Expenses(Context context, Energy energy, InputStream inputStream, ArrayList<String> columnNames) {
        super(inputStream,
                context.getResources().getString(R.string.expenses_name),
                context.getResources().getString(R.string.expenses_unit),
                columnNames);
        this.energy = energy;
    }

    @Override
    public void calculateTodaysEnergyValue() {
        dailyValues[1] = (float) energy.calculateTodaysElectricityCost();
    }

    @Override
    public void estimateTodaysValueWithSolarPanel(int pvSystemSize) {
        dailyValues[1] = (float) energy.calculateTodaysElectricityCost(pvSystemSize); //TODO: change to float
    }

}