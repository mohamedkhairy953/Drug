package com.khairy.moham.drug;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.khairy.moham.drug.databinding.RegisterFragmentBinding;

import static com.khairy.moham.drug.UtilityDrugs.TAG;

/**
 * Created by mohsallam on 1/14/2018.
 */

public class PharmacySignUpFragment extends Fragment {
    RegisterFragmentBinding b;
    SignUpDataModel signUpDataModel;
    SessionUser sessionUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.register_fragment, container, false);
        signUpDataModel = new SignUpDataModel();
        sessionUser = new SessionUser(getContext());
        b.loginTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilityDrugs.showFragment((MainActivity) getActivity(), R.id.container, new LoginFragment());
            }
        });
        b.signUpRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog dialog = ProgressDialog.show(getContext(), "", "جارى التسجيل من فضلك انتظر ...");
                signUpDataModel.signUpPharmacy(getPharmacy(), new ResponseInterface.SuccessFail() {
                    @Override
                    public void failed(String errrorMsg) {
                        dialog.dismiss();
                        Toast.makeText(getContext(), errrorMsg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void success() {
                        dialog.dismiss();
                        Toast.makeText(getContext(), "تم التسجيل بنجاح", Toast.LENGTH_SHORT).show();
                        sessionUser.saveUserSession(b.licenceRegisterText.getText().toString(), SessionUser.PHARMACY);
                        startActivity(new Intent(getContext(), MainTabbedActivity.class));
                        getActivity().finish();
                    }
                });

            }
        });
        return b.getRoot();
    }

    public Pharmacy getPharmacy() {
        return new Pharmacy(
                b.nameEditText.getText().toString()
                , b.phoneNumberRegister.getText().toString()
                , b.licenceRegisterText.getText().toString()
                , b.passwordRegisterText.getText().toString());
    }
}
