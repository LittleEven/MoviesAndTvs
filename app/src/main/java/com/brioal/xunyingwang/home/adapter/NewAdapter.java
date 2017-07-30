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
import com.brioal.xunyingwang.bean.TVBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/30.
 */

public class NewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final int TYPE_TITLE = 0;//标题
    private final int TYPE_TV = 1;//Tv
    private final int TYPE_MOVIE = 2;//Movie


    private List<String> mTitles = new ArrayList<>();
    private Context mContext;
    private List<MovieBean> mNewMovies = new ArrayList<>();
    private List<TVBean> mNewTvs = new ArrayList<>();
    private List<MovieBean> mActionMovies = new ArrayList<>();
    private List<MovieBean> mScienceMovies = new ArrayList<>();


    public NewAdapter(Context context) {
        mContext = context;
        mTitles.clear();
        mTitles.add("最新电影");
        mTitles.add("最新电视剧");
        mTitles.add("最新动作电影");
        mTitles.add("最新科幻电影");
    }

    public void setNewMovies(List<MovieBean> newMovies) {
        mNewMovies.clear();
        mNewMovies.addAll(newMovies);
    }

    public void setNewTvs(List<TVBean> newTvs) {
        mNewTvs.clear();
        mNewTvs.addAll(newTvs);
    }

    public void setActionMovies(List<MovieBean> actionMovies) {
        mActionMovies.clear();
        mActionMovies.addAll(actionMovies);
    }

    public void setScienceMovies(List<MovieBean> scienceMovies) {
        mScienceMovies.clear();
        mScienceMovies.addAll(scienceMovies);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_TITLE:
                return new TitleViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_title, parent, false));
            case TYPE_MOVIE:


                return new MovieViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_movie, parent, false));
            case TYPE_TV:

                return new TvViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_tv, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (holder instanceof TitleViewHolder) {
            //标题
            if (position == 0) {
                ((TitleViewHolder) holder).bindView(mTitles.get(0), position);//第一个标题
            }
            if (position == mNewMovies.size() + 1) {
                ((TitleViewHolder) holder).bindView(mTitles.get(1), position);//第二个标题
            }
            if (position == mNewMovies.size() + mNewTvs.size() + 2) {
                ((TitleViewHolder) holder).bindView(mTitles.get(2), position);//第三个标题
            }
            if (position == getItemCount() - mScienceMovies.size() - 1) {
                ((TitleViewHolder) holder).bindView(mTitles.get(3), position);//第四个标题
            }
        } else if (holder instanceof TvViewHolder) {
            //Tv
            ((TvViewHolder) holder).bindView(mNewTvs.get(position - 2 - mNewMovies.size()), position - 2 - mNewMovies.size());
        } else if (holder instanceof MovieViewHolder) {
            //Movie
            if (position > 0 && position <= mNewMovies.size()) {
                ((MovieViewHolder) holder).bindView(mNewMovies.get(position - mNewMovies.size() - mNewTvs.size() - 3), position - mNewMovies.size() - mNewTvs.size() - 3);//最新电影
            } else if (position > mNewMovies.size() + mNewTvs.size() + 2 && position <= getItemCount() - mScienceMovies.size() - 2) {
                ((MovieViewHolder) holder).bindView(mActionMovies.get(position - 3 - mNewMovies.size() - mNewTvs.size()), position - 3 - mNewMovies.size() - mNewTvs.size());
            } else if (position > getItemCount() - mScienceMovies.size() - 1) {
                ((MovieViewHolder) holder).bindView(mScienceMovies.get(position - mNewMovies.size() - mNewTvs.size() - mActionMovies.size() - 4), position - mNewMovies.size() - mNewTvs.size() - mActionMovies.size() - 4);//科幻
            }
        }
    }

    @Override
    public int getItemCount() {
        return mNewMovies.size() + mNewTvs.size() + mActionMovies.size() + mScienceMovies.size() + mTitles.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TITLE;//第一个标题
        }
        if (position == mNewMovies.size() + 1) {
            return TYPE_TITLE;//第二个标题
        }
        if (position == mNewMovies.size() + mNewTvs.size() + 2) {
            return TYPE_TITLE;//第三个标题
        }
        if (position == getItemCount() - mScienceMovies.size() - 1) {
            return TYPE_TITLE;//第四个标题
        }
        if (position > 0 && position <= mNewMovies.size()) {
            return TYPE_MOVIE;//最新电影
        }
        if (position > mNewMovies.size() + mNewTvs.size() + 2 && position <= getItemCount() - mScienceMovies.size() - 2) {
            return TYPE_MOVIE;//动作
        }
        if (position > mNewMovies.size() + 1 && position <= mNewMovies.size() + 1 + mNewTvs.size()) {
            return TYPE_TV;//Tv
        }
        if (position > getItemCount() - mScienceMovies.size() - 1) {
            return TYPE_MOVIE;//科幻
        }
        return TYPE_MOVIE;//动作
    }

    class TitleViewHolder extends BaseViewHolder<String> {
        private TextView mTvTitle;
        private View mRootView;

        public TitleViewHolder(View itemView) {
            super(itemView);
            mRootView = itemView;
            mTvTitle = mRootView.findViewById(R.id.item_home_title);

        }

        @Override
        public void bindView(String object, int position) {
            mTvTitle.setText(object);
        }
    }


    class MovieViewHolder extends BaseViewHolder<MovieBean> {
        private ImageView mIvImg;
        private TextView mTvQuality;
        private TextView mTvTitle;
        private TextView mTvRank;
        private TextView mTvType1;
        private TextView mTvType2;
        private TextView mTvType3;
        private View mRootView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            mRootView = itemView;
            mIvImg = mRootView.findViewById(R.id.item_movie_iv_img);
            mTvQuality = mRootView.findViewById(R.id.item_movie_tv_quality);
            mTvTitle = mRootView.findViewById(R.id.item_movie_tv_title);
            mTvRank = mRootView.findViewById(R.id.item_movie_tv_rank);
            mTvType1 = mRootView.findViewById(R.id.item_movie_tv_type1);
            mTvType2 = mRootView.findViewById(R.id.item_movie_tv_type2);
            mTvType3 = mRootView.findViewById(R.id.item_movie_tv_type3);
        }

        @Override
        public void bindView(MovieBean object, int position) {
            //图片
            Glide.with(mContext).load(object.getCoverUrl()).error(R.mipmap.ic_temp_pic).into(mIvImg);
            //标题
            mTvTitle.setText(object.getName());
            //清晰度
            mTvQuality.setText(object.getQuality());
            //评分
            mTvRank.setText(object.getRank());
            //类型
            if (object.getTypes().length > 0) {
                mTvType1.setText(object.getTypes()[0]);
                mTvType1.setVisibility(View.VISIBLE);
                mTvType2.setVisibility(View.GONE);
                mTvType3.setVisibility(View.GONE);
            }
            if (object.getTypes().length > 1) {
                mTvType1.setText(object.getTypes()[0]);
                mTvType2.setText(object.getTypes()[1]);
                mTvType1.setVisibility(View.VISIBLE);
                mTvType2.setVisibility(View.VISIBLE);
                mTvType3.setVisibility(View.GONE);
            }
            if (object.getTypes().length > 2) {
                mTvType1.setText(object.getTypes()[0]);
                mTvType2.setText(object.getTypes()[1]);
                mTvType3.setText(object.getTypes()[2]);
                mTvType1.setVisibility(View.VISIBLE);
                mTvType2.setVisibility(View.VISIBLE);
                mTvType3.setVisibility(View.VISIBLE);
            }
            //点击事件
            mRootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO: 2017/7/30 电影详情
                }
            });
        }
    }

    class TvViewHolder extends BaseViewHolder<TVBean> {
        private ImageView mIvImg;
        private TextView mTvTitle;
        private TextView mTvRank;
        private TextView mTypeTitle;
        private TextView mTvActors;

        private View mRootView;

        public TvViewHolder(View itemView) {
            super(itemView);
            mRootView = itemView;
        }

        @Override
        public void bindView(TVBean object, int position) {
//图片
            Glide.with(mContext).load(object.getCoverUrl()).error(R.mipmap.ic_temp_pic).into(mIvImg);
            //标题
            mTvTitle.setText(object.getName());
            //评分
            mTvRank.setText(object.getRank());
            //主演
            mTvActors.setText(object.getActors());
            //点击事件
            mRootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO: 2017/7/30
                }
            });
        }
    }
}
