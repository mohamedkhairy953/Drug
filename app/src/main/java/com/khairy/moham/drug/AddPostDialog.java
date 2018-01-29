package com.khairy.moham.drug;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by mohsallam on 1/15/2018.
 */

public class AddPostDialog extends Dialog {
    public static final int ADD_POST = 2;
    private Context context;
    private OnClickListener listener;
    Button addPost;
    private EditText concentrationEt, nameEt;
    private Spinner typeSpinner;

    public AddPostDialog(@NonNull Context context, DialogInterface.OnClickListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
    }

    public AddPostDialog(MainTabbedActivity mainTabbedActivity) {
        super(mainTabbedActivity);
        this.listener = mainTabbedActivity;
        this.context = mainTabbedActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_post);
        addPost = findViewById(R.id.post_add_post);
        concentrationEt = findViewById(R.id.drug_con_add_post);
        nameEt = findViewById(R.id.drug_name_add_post);
        typeSpinner = findViewById(R.id.drug_type_add_post);
        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddPostClicked();
            }


        });
    }

    private void onAddPostClicked() {
        final ProgressDialog dialog = ProgressDialog.show(context, "", "جارى اضافة الطلب");
        new PostDataModel().addPostToFirebase(getPost(), new ResponseInterface.SuccessFail() {
            @Override
            public void failed(String errrorMsg) {
                dialog.dismiss();
                Toast.makeText(context, errrorMsg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void success() {
                dialog.dismiss();
                dismiss();
                listener.onClick(AddPostDialog.this, ADD_POST);
            }
        });

    }

    private PostModel getPost() {
        String userKey = "uuu";
        SessionUser user = new SessionUser(context);
        if (!user.isEmpty())
            userKey = user.retreiveUserSession().key;
        return new PostModel(nameEt.getText().toString()
                , concentrationEt.getText().toString()
                , typeSpinner.getSelectedItem().toString()
                , userKey);
    }
}
