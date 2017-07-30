package com.brioal.xunyingwang.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brioal.xunyingwang.R;
import com.brioal.xunyingwang.bean.TVBean;
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

public class TvGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<TVBean> mList = new ArrayList<>();

    public TvGridAdapter(Context context) {
        mContext = context;
    }

    public void showList(List<TVBean> list) {
        mList.clear();
        mList.addAll(list);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_home_tv, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final TVBean object = mList.get(position);
        //图片
        Glide.with(mContext).load(object.getCoverUrl()).error(R.mipmap.ic_temp_pic).into(holder.mIvImg);
        //标题
        holder.mTvTitle.setText(object.getName());
        //评分
        holder.mTvRank.setText(object.getRank());
        //主演
        holder.mTvActors.setText(object.getActors());
        //点击事件
        holder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2017/7/30 电影详情
            }
        });
        return convertView;
    }


    static class ViewHolder {
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

        ViewHolder(View view) {
            mRootView = view;
            ButterKnife.bind(this, view);
        }
    }
}
