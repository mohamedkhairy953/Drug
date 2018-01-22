package com.khairy.moham.drug;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khairy.moham.drug.databinding.LoginFragmentBinding;

/**
 * Created by mohsallam on 1/14/2018.
 */

public class LoginFragment extends Fragment implements DialogInterface.OnClickListener {
    LoginFragmentBinding b;
    private BottomSheetBehavior sheetBehavior;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false);
        b.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // showDialog();
                UtilityDrugs.showFragment((MainActivity) getActivity(), R.id.container, new PharmacySignUpFragment());
            }
        });
        b.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Todo -1 check if phone exist  2- getType of phone if user or pharmacy
                // Todo -3 if user just login to tabbed activity -4 if pharmacy ask for password first
                startActivity(new Intent(getContext(), MainTabbedActivity.class));
            }
        });
        return b.getRoot();
    }

    private void showDialog() {
        new SignupOptionsDialog(getContext(), this).show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == SignupOptionsDialog.PHARMACY_SIGNUP)
            UtilityDrugs.showFragment((MainActivity) getActivity(), R.id.container, new PharmacySignUpFragment());
        else if (i == SignupOptionsDialog.NORMAL_SIGNUP)
            UtilityDrugs.showFragment((MainActivity) getActivity(), R.id.container, new NormalSignUpFragment());

    }
}
