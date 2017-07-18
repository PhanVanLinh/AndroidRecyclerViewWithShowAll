package com.toong.androidrecyclerviewwithshowall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.toong.androidrecyclerviewwithshowall.R;
import com.toong.androidrecyclerviewwithshowall.base.BaseRecyclerViewAdapter;
import com.toong.androidrecyclerviewwithshowall.model.Item;
import java.util.List;

public class MyRecyclerViewAdapter extends BaseRecyclerViewAdapter<Item>
        implements ShowAllViewHolder.OnClickListener {
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_SHOW_ALL = 2;

    private boolean mIsLimit;
    private int mLimitItemCount;

    public MyRecyclerViewAdapter(Context context, int limitItemCount,
            BaseRecyclerViewAdapter.ItemClickListener itemClickListener) {
        super(context, itemClickListener);
        mIsLimit = true;
        mLimitItemCount = limitItemCount;
    }

    @Override
    public void add(List<Item> itemList) {
        super.add(itemList);
    }

    @Override
    public int getItemCount() {
        if (mIsLimit) {
            return mLimitItemCount + 1;
        } else {
            return super.getItemCount();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mIsLimit) {
            if (position == getItemCount() - 1) {
                return TYPE_SHOW_ALL;
            }
        }
        return TYPE_ITEM;
    }

    @Override
    public void onShowAllClick() {
        mIsLimit = false;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_SHOW_ALL) {
            View view = mInflater.inflate(R.layout.item_recyclerview_show_all, parent, false);
            return new ShowAllViewHolder(view, this);
        }
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ItemViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            Item item = mDataList.get(position);
            ((ItemViewHolder) holder).myTextView.setText(item.getTitle());
        }
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private TextView myTextView;
        private ItemClickListener mItemClickListener;

        ItemViewHolder(View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.info_text);
            itemView.setOnClickListener(this);
            mItemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }


}