package com.khairy.moham.drug;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by moham on 1/28/2018.
 */

public class PostDataModel {
    public void addPostToFirebase(PostModel p, final ResponseInterface.SuccessFail res) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child(UtilityDrugs.POSTS_CHILD).child(p.generateKey()).setValue(p);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                res.success();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                res.failed(databaseError.getMessage());
            }
        });

    }

    public void addPharmacyToPost(String postKey, PharmacyHave p, final ResponseInterface.SuccessFail res) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child(UtilityDrugs.POSTS_CHILD).child(postKey).child(UtilityDrugs.pharmaciesHave_child).setValue(p);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                res.success();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                res.failed(databaseError.getMessage());
            }
        });

    }
}
