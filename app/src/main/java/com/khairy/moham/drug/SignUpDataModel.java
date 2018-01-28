package com.khairy.moham.drug;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by moham on 1/24/2018.
 */

public class SignUpDataModel {
    public void signUpPharmacy(Pharmacy p, final ResponseInterface.SuccessFail res) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child(UtilityDrugs.PHARMACY_CHILD).child(p.getPharmacyLicence()).setValue(p);
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
