package com.toong.androidrecyclerviewwithshowall.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.toong.androidrecyclerviewwithshowall.R;

public  class ShowAllViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Button btnShowAll;
        private OnClickListener mOnClickListener;

        ShowAllViewHolder(View itemView, OnClickListener onClickListener) {
            super(itemView);
            mOnClickListener = onClickListener;
            btnShowAll = (Button) itemView.findViewById(R.id.button_show_all);
            btnShowAll.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.button_show_all) {
                mOnClickListener.onShowAllClick();
            }
        }
        public interface OnClickListener {
            void onShowAllClick();
        }
    }