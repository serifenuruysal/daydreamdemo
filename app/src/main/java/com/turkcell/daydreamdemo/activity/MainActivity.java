package com.turkcell.daydreamdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;

/**
 * Created by serifenuruysal on 11/05/16.
 */
public class MainActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        Intent intent;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            intent = new Intent(Settings.ACTION_DREAM_SETTINGS);
        } else {
            intent = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
        }
        startActivity(intent);
    }
}
