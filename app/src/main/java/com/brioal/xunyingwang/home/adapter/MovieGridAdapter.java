package com.brioal.xunyingwang.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brioal.xunyingwang.R;
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

public class MovieGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<MovieBean> mList = new ArrayList<>();

    public MovieGridAdapter(Context context) {
        mContext = context;
    }

    public void showList(List<MovieBean> list) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_home_movie, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final MovieBean object = mList.get(position);
        //图片
        Glide.with(mContext).load(object.getCoverUrl()).error(R.mipmap.ic_temp_pic).into(holder.mIvImg);
        //标题
        holder.mTvTitle.setText(object.getName());
        //清晰度
        holder.mTvQuality.setText(object.getQuality());
        //评分
        holder.mTvRank.setText(object.getRank());
        //类型
        if (object.getTypes().length > 0) {
            holder.mTvType1.setText(object.getTypes()[0]);
            holder.mTvType1.setVisibility(View.VISIBLE);
            holder.mTvType2.setVisibility(View.GONE);
            holder.mTvType3.setVisibility(View.GONE);
        }
        if (object.getTypes().length > 1) {
            holder.mTvType1.setText(object.getTypes()[0]);
            holder.mTvType2.setText(object.getTypes()[1]);
            holder.mTvType1.setVisibility(View.VISIBLE);
            holder.mTvType2.setVisibility(View.VISIBLE);
            holder.mTvType3.setVisibility(View.GONE);
        }
        if (object.getTypes().length > 2) {
            holder.mTvType1.setText(object.getTypes()[0]);
            holder.mTvType2.setText(object.getTypes()[1]);
            holder.mTvType3.setText(object.getTypes()[2]);
            holder.mTvType1.setVisibility(View.VISIBLE);
            holder.mTvType2.setVisibility(View.VISIBLE);
            holder.mTvType3.setVisibility(View.VISIBLE);
        }
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
        @BindView(R.id.item_movie_iv_img)
        ImageView mIvImg;
        @BindView(R.id.item_movie_tv_quality)
        TextView mTvQuality;
        @BindView(R.id.item_movie_tv_title)
        TextView mTvTitle;
        @BindView(R.id.item_movie_tv_rank)
        TextView mTvRank;
        @BindView(R.id.item_movie_tv_type1)
        TextView mTvType1;
        @BindView(R.id.item_movie_tv_type2)
        TextView mTvType2;
        @BindView(R.id.item_movie_tv_type3)
        TextView mTvType3;

        View mRootView;

        ViewHolder(View view) {
            mRootView = view;
            ButterKnife.bind(this, view);
        }
    }
}
