package com.khairy.moham.drug;

import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.auth.User;
import com.khairy.moham.drug.databinding.UserPostBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by moham on 2/2/2018.
 */

class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.MyVH> {


    private List<? extends PostModel> models;

    public NewsFeedAdapter() {

    }

    public void setModels(final List<? extends PostModel> models) {
        if (this.models == null) {
            this.models = models;
            notifyItemRangeInserted(0, models.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return NewsFeedAdapter.this.models.size();
                }

                @Override
                public int getNewListSize() {
                    return models.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return NewsFeedAdapter.this.models.get(oldItemPosition).getFullNameInPost()
                            .equals(models.get(newItemPosition).getFullNameInPost());
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    PostModel post = models.get(newItemPosition);
                    PostModel old = models.get(oldItemPosition);
                    return post.getFullNameInPost().equals(old.getFullNameInPost());
                }
            });
            this.models = models;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        UserPostBinding p = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.user_post, parent, false);
        return new MyVH(p);
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {
        holder.binding.setPost(models.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return (models == null) ? 0 : models.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        UserPostBinding binding;

        public MyVH(UserPostBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }
}
