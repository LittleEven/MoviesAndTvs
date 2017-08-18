package com.LittleEven.xunyingwang.bean;

/**
 * Created by Mr.wan on 2017/8/1.
 */

public class RankBean {
    private String Rank = "";//排名
    private String Info = "";//简介
    private String Pic = "";//封面图片
    private String ID = "";//ID
    private String Score = "";//评分
    private String Tittle="";//标题

    public String getTittle() {
        return Tittle;
    }

    public RankBean setTittle(String tittle) {
        Tittle = tittle;
        return this;
    }

    public String getRank() {
        return Rank;
    }

    public RankBean setRank(String rank) {
        Rank = rank;
        return this;
    }

    public String getInfo() {
        return Info;
    }

    public RankBean setInfo(String info) {
        Info = info;
        return this;
    }

    public String getPic() {
        return Pic;
    }

    public RankBean setPic(String pic) {
        Pic = pic;
        return this;
    }

    public String getID() {
        return ID;
    }

    public RankBean setID(String ID) {
        this.ID = ID;
        return this;
    }

    public String getScore() {
        return Score;
    }

    public RankBean setScore(String score) {
        Score = score;
        return this;
    }
}
