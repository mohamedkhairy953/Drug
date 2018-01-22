package com.khairy.moham.drug;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khairy.moham.drug.databinding.RegisterFragmentBinding;

/**
 * Created by mohsallam on 1/14/2018.
 */

public class PharmacySignUpFragment extends Fragment {
    RegisterFragmentBinding b;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.register_fragment, container, false);
        b.loginTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilityDrugs.showFragment((MainActivity) getActivity(),R.id.container,new LoginFragment());
            }
        });
        b.signUpRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo save data to the database pharmacy table
            }
        });
        return b.getRoot();
    }
}
