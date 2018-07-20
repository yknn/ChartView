package com.chartview.bean;

import android.graphics.Path;
import android.graphics.Point;

/*
 * create at 2018/7/13
 * description:封装绘制三阶贝赛尔曲线的参数
 */
public class BeizerBean {

    private Point startPoint;
    private Point endPoint;
    private Point controlPoint0;
    private Point controlPoint1;

    public BeizerBean() {
    }

    public BeizerBean(Point startPoint, Point endPoint, Point controlPoint0, Point controlPoint1) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.controlPoint0 = controlPoint0;
        this.controlPoint1 = controlPoint1;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Point getControlPoint0() {
        return controlPoint0;
    }

    public void setControlPoint0(Point controlPoint0) {
        this.controlPoint0 = controlPoint0;
    }

    public Point getControlPoint1() {
        return controlPoint1;
    }

    public void setControlPoint1(Point controlPoint1) {
        this.controlPoint1 = controlPoint1;
    }
}
