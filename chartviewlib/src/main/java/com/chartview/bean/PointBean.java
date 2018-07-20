package com.chartview.bean;

/*
 * create at 2018/7/13
 * description:封装点坐标
 */
public class PointBean {

    private float x;
    private float y;

    public PointBean() {

    }

    public PointBean(String x ,float y){
        if (x.trim().length()!=0){
            this.x = Float.parseFloat(x.toString().trim());
        }
        this.y = y;
    }

    public PointBean(float x , String y){
        this.x = x;
        if (y.trim().length()!=0){
            this.y = Float.parseFloat(y.toString().trim());
        }
    }


    public PointBean(String x , String y){
        this.x = Float.parseFloat(x.toString().trim());
        this.y = Float.parseFloat(y.toString().trim());
    }


    public PointBean(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {

        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
