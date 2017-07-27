package com.brioal.xunyingwang.home.model;

import com.brioal.bannerview.BannerBean;
import com.brioal.xunyingwang.bean.HomeBean;
import com.brioal.xunyingwang.bean.RecommondBean;
import com.brioal.xunyingwang.home.contract.HomeContract;
import com.socks.library.KLog;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/27.
 */

public class HomeModel implements HomeContract.Model {
    private String URL_HOMe = "http://www.xunyingwang.com/";

    @Override
    public void loadHomeData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL_HOMe)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                KLog.e(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String content = response.body().string();
                HomeBean homeBean = new HomeBean();
                KLog.e(content);
                try {
                    Document document = Jsoup.parse(content);
                    //解析轮播图
                    homeBean.setBanners(getBanners(document))//解析轮播图
                            .setRecommondBeens(getRecommonds(document))//解析推荐资源

                    ;

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    /**
     * 解析推荐资源
     *
     * @param mainDocuments
     * @return
     */
    private List<RecommondBean> getRecommonds(Document mainDocuments) {
        List<RecommondBean> list = new ArrayList<>();
        Elements movies = mainDocuments.getElementsByClass("col-xs-3");
        for (int i = 0; i < 4; i++) {
            Element movie = movies.get(i);
            String title = movie.getElementsByTag("a").attr("title");
            String idWith = movie.getElementsByTag("a").attr("href");
            String imageUrl = movie.getElementsByTag("img").attr("src");
            String id = "";
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(idWith);
            while (matcher.find()) {
                id = matcher.group();
            }
            RecommondBean bean = new RecommondBean();
            KLog.e(id);
            KLog.e(title);
            KLog.e(imageUrl);
            bean.setId(id)
                    .setName(title)
                    .setPicUrl(imageUrl);
            list.add(bean);
        }
        return list;
    }

    /**
     * 解析轮播图
     *
     * @param mainDocument
     * @return
     */
    private List<BannerBean> getBanners(Document mainDocument) {
        Element bannerElements = mainDocument.getElementsByClass("carousel-inner").first();
        Elements bannersNoraml = bannerElements.getElementsByClass("item");
        List<BannerBean> banners = new ArrayList<>();
        for (int i = 0; i < bannersNoraml.size(); i++) {
            Element element = bannersNoraml.get(i);
            String urlWith = element.getElementsByTag("a").first().attr("href");
            String src = element.getElementsByTag("img").first().attr("src");
            String nameWith = element.getElementsByTag("img").first().attr("alt");
            String name = nameWith.substring(0, nameWith.length() - 1 - 3);
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(urlWith);
            String url = "";
            while (matcher.find()) {
                url = matcher.group();
            }
            KLog.e(url);
            KLog.e(src);
            KLog.e(name);
            BannerBean bean = new BannerBean(src, name, url);
            banners.add(bean);
        }
        return banners;
    }
}
