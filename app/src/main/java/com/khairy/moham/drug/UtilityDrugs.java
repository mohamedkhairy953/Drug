package com.khairy.moham.drug;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mohsallam on 1/14/2018.
 */

public class UtilityDrugs {
    public static void showFragment(AppCompatActivity c, int container, Fragment fragment) {
        FragmentManager fragmentManager = c.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_from_bottom, R.anim.slide_out_to_bottom, R.anim.pop_out, R.anim.pop_in);
        transaction.replace(container, fragment)
                .commit();
    }


    public static void showInnerFragment(Fragment c, int container, Fragment fragment) {
        FragmentManager fragmentManager = c.getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_from_bottom, R.anim.slide_out_to_bottom, R.anim.pop_out, R.anim.pop_in);
        transaction.add(container, fragment)
                .commit();
    }
}
