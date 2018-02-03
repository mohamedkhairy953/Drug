package com.khairy.moham.drug;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khairy.moham.drug.databinding.UserPostesFragmentBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends Fragment {

    UserPostesFragmentBinding b;
    private NewsFeedAdapter myAdapter;

    public NewsFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        b = DataBindingUtil.inflate(inflater, R.layout.user_postes_fragment, container, false);
        myAdapter = new NewsFeedAdapter();
        b.userRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        b.userRecyclerView.setAdapter(myAdapter);

        // todo set Adapter
        return b.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final NewsFeedViewModel viewModel = ViewModelProviders.of(this).get(NewsFeedViewModel.class);

        observeViewModel(viewModel);
    }

    private void observeViewModel(NewsFeedViewModel viewModel) {
        viewModel.getListLiveData().observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(@Nullable List<PostModel> postModels) {
                myAdapter.setModels(postModels);
            }
        });
    }
}
