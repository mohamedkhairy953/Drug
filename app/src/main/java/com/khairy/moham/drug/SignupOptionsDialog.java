package com.khairy.moham.drug;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by mohsallam on 1/14/2018.
 */

public class SignupOptionsDialog extends Dialog {
    public static final int PHARMACY_SIGNUP = 1;
    public static final int NORMAL_SIGNUP = 2;
    private TextView docSignup, normalSignup;
    private Context context;
    private OnClickListener listener;

    public SignupOptionsDialog(@NonNull Context context, DialogInterface.OnClickListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sign_up_options);
        docSignup = findViewById(R.id.doc_signup);
        normalSignup = findViewById(R.id.normal_signup);
        docSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                listener.onClick(SignupOptionsDialog.this, PHARMACY_SIGNUP);
            }
        });
        normalSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                listener.onClick(SignupOptionsDialog.this, NORMAL_SIGNUP);
            }
        });
    }


}
