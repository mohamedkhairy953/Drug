package com.khairy.moham.drug;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.khairy.moham.drug.databinding.RegisterNormalFragmentBinding;

import java.util.Arrays;

import static android.app.Activity.RESULT_OK;

/**
 * Created by mohsallam on 1/14/2018.
 */

public class NormalSignUpFragment extends Fragment {
    RegisterNormalFragmentBinding b;
    private final int REQUEST_CODE = 100;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.register_normal_fragment, container, false);
        b.signUpRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneAuth();
            }
        });
        return b.getRoot();
    }

    private void phoneAuth() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            String phoneNumber = firebaseAuth.getCurrentUser().getPhoneNumber();
            if (!phoneNumber.isEmpty())
                UtilityDrugs.showFragment((MainActivity) getActivity(), R.id.container, new LoginFragment());

        } else
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                    Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build())).build()
                    , REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            String phoneNumber = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
            if (resultCode == RESULT_OK) {
                if (!phoneNumber.isEmpty())
                    UtilityDrugs.showFragment((MainActivity) getActivity(), R.id.container, new LoginFragment());
            } else
                Toast.makeText(getContext(), response.getErrorCode() + "", Toast.LENGTH_SHORT).show();
        }
    }
}
