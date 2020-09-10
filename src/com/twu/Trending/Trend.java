package com.twu.Trending;

public class Trend {
    String Event; //热搜事件
    int Vote; //热搜票数
    int Price; //热搜价格
    int Ranking; //热搜排名
    public boolean HotTrend; //超级热搜

    public void setEvent(String Event) {
        this.Event = Event;
    }

    public String getEvent() {
        return Event;
    }

    public void setVote(int Vote) {
        this.Vote = Vote;
    }

    public int getVote() {
        return Vote;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getPrice() {
        return Price;
    }

    public void setRanking(int Ranking) {
        this.Ranking = Ranking;
    }

    public int getRanking() {
        return Ranking;
    }

    public void setHotTrend(boolean HotTrend) {
        this.HotTrend = HotTrend;
    }

    public boolean getHotTrend() {
        return HotTrend;
    }

}
