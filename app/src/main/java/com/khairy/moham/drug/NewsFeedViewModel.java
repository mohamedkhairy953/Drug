package com.khairy.moham.drug;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by moham on 1/29/2018.
 */

public class NewsFeedViewModel extends AndroidViewModel {
    // todo we make this class for retreiving all posts from firebase
    LiveData<List<PostModel>> postsLiveData;

    public NewsFeedViewModel(@NonNull Application application) {
        super(application);
        postsLiveData = retreivePostsFromFB();
    }

    public LiveData<List<PostModel>> getListLiveData() {
        return postsLiveData;
    }

    public LiveData<List<PostModel>> retreivePostsFromFB() {

        final MutableLiveData<List<PostModel>> posts = new MutableLiveData<>();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        ref.child(UtilityDrugs.POSTS_CHILD).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> it = dataSnapshot.getChildren().iterator();
                List<PostModel> models = new ArrayList<>();
                while (it.hasNext()) {
                    models.add(it.next().getValue(PostModel.class));
                }
                posts.postValue(models);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
                posts.setValue(null);
            }
        });
        return posts;
    }
}
