package com.khairy.moham.drug;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khairy.moham.drug.databinding.UserPostesFragmentBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends Fragment {

    UserPostesFragmentBinding b;

    public NewsFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        b = DataBindingUtil.inflate(inflater, R.layout.user_postes_fragment, container, false);
        b.userRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.ItemDecoration  decoration=new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL);
        b.userRecyclerView.addItemDecoration(decoration);
        // todo set Adapter
        return b.getRoot();
    }

}
