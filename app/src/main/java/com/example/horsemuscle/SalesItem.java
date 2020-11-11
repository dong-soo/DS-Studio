package com.example.horsemuscle;

public class SalesItem {
    private String tv_produtc; //판매상품명
    private String tv_price; //판매가격
    private String tv_date; // 판매일자

    public SalesItem(){

    }

    public String getTv_produtc() {
        return tv_produtc;
    }

    public void setTv_produtc(String tv_produtc) {
        this.tv_produtc = tv_produtc;
    }

    public String getTv_price() {
        return tv_price;
    }

    public void setTv_price(String tv_price) {
        this.tv_price = tv_price;
    }

    public String getTv_date() {
        return tv_date;
    }

    public void setTv_date(String tv_date) {
        this.tv_date = tv_date;
    }
}
