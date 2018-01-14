package com.khairy.moham.drug;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.khairy.moham.drug.databinding.ActivityDawaBinding;

/**
 * Created by mohsallam on 1/14/2018.
 */

public class MainActivity extends AppCompatActivity {
    ActivityDawaBinding b;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_dawa);
        UtilityDrugs.showFragment(this,R.id.container ,new LoginFragment());

    }


}
