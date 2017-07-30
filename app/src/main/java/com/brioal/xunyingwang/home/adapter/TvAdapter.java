package com.brioal.xunyingwang.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brioal.xunyingwang.R;
import com.brioal.xunyingwang.base.BaseViewHolder;
import com.brioal.xunyingwang.bean.MovieBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/30.
 */

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvViewHolder> {

    private Context mContext;
    private List<MovieBean> mList = new ArrayList<>();

    public TvAdapter(Context context) {
        mContext = context;
    }

    /**
     * 设置数据源
     *
     * @param list
     */
    public void setList(List<MovieBean> list) {
        mList.clear();
        mList.addAll(list);
    }

    @Override
    public TvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TvViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_tv, parent, false));
    }

    @Override
    public void onBindViewHolder(TvViewHolder holder, int position) {
        holder.bindView(mList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class TvViewHolder extends BaseViewHolder<MovieBean> {
        @BindView(R.id.item_tv_iv_img)
        ImageView mIvImg;
        @BindView(R.id.item_tv_tv_title)
        TextView mTvTitle;
        @BindView(R.id.item_tv_tv_rank)
        TextView mTvRank;
        @BindView(R.id.item_tv_tv_type_title)
        TextView mTvTypeTitle;
        @BindView(R.id.item_tv_tv_type1)
        TextView mTvActors;
        View mRootView;

        public TvViewHolder(View itemView) {
            super(itemView);
            mRootView = itemView;
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindView(MovieBean object, int position) {
            //图片
            Glide.with(mContext).load(object.getCoverUrl()).error(R.mipmap.ic_temp_pic).into(mIvImg);
            //标题
            mTvTitle.setText(object.getName());
            //评分
            mTvRank.setText(object.getRank());
            //主演
            mTvActors.setText(object.getmActors());
            //点击事件
            mRootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO: 2017/7/30 电视剧详情
                }
            });
        }
    }

}

