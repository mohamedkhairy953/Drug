package com.khairy.moham.drug;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

/**
 * Created by mohsallam on 1/15/2018.
 */

public class AddPostDialog extends Dialog {
    public static final int ADD_POST = 2;
    private Context context;
    private OnClickListener listener;
    Button addPost;

    public AddPostDialog(@NonNull Context context, DialogInterface.OnClickListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
    }

    public AddPostDialog(MainTabbedActivity mainTabbedActivity) {
        super(mainTabbedActivity);
        this.listener=mainTabbedActivity;
        this.context = mainTabbedActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_post);
        addPost = findViewById(R.id.post_add_post);
        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddPostClicked();
            }


        });
    }

    private void onAddPostClicked() {
        dismiss();
        listener.onClick(this, ADD_POST);
    }
}
