package com.chartview.bean;


/*
 * create at 2018/7/18
 * description:属性管理
 */
public class AttrBean {

    //      <attr name="axisX_start"  format="integer|float"  />
    private float axisXStart;
    //        <attr name="axisX_end" format="integer|float"/>
    private float axisXEnd;
    //        <attr name="axisY0_start" format="float|integer"/>
    private float axisY0Start;
    //        <attr name="axisY0_end" format="float|integer"/>
    private float axisY0End;
    //        <attr name="axisY1_start" format="integer|float"/>
    private float axisY1Start;
    //        <attr name="axisY1_end" format="float|integer"/>
    private float axisY1End;//        <attr name="axisY2_start" format="integer|float"/>
    private float axisY2Start;
    //        <attr name="axisY2_end" format="integer|float"/>
    private float axisY2End;
    //        <attr name="axisY1_Y2" format="integer|float"/>
    private float axisY1Y2;
    //        <attr name="axisX_color" format="color"/>
    private int axisXColor;
    //        <attr name="axisY0_color" format="color"/>
    private int axisY0Color;
    //        <attr name="axisY1_color" format="color"/>
    private int axisY1Color;
    //        <attr name="axisY2_color" format="color"/>
    private int axisY2Color;
    //        <attr name="axisY0_line_color" format="color"/>
    private int axisY0LineColor;
    //        <attr name="axisY1_line_color" format="color"/>
    private int axisY1LineColor;
    //        <attr name="axisY2_line_color" format="color"/>
    private int axisY2LineColor;
    //        <!--所有刻度都在内部-->
//        <attr name="axis_dividing_in" format="boolean"/>
    private boolean axisDividingIn = true;
    //        <attr name="axisX_dividing_in" format="boolean"/>
    private boolean axisXDividingIn = true;
    //        <attr name="axisY_dividing_in" format="boolean"/>
    private boolean axisYDividingIn = true;
    //        <attr name="axisY0_dividing_in" format="boolean"/>
    private boolean axisY0DividingIn = true;
    //        <attr name="axisY1_dividing_in" format="boolean"/>
    private boolean axisY1DividingIn = true;
    //        <attr name="axisY2_dividing_in" format="boolean"/>
    private boolean axisY2DividingIn = true;
    //        <attr name="dividing_length" format="float|integer"/>
    private float dividingLeng;
    //        <attr name="dividing_color" format="color"/>
    private float dividingColor;
    //        <attr name="axis_dividing_distance" format="integer|float"/>
    private float axisDividingDistance;
    //        <attr name="axis_textName_size" format="dimension"/>
    private float axisTextNameSize;
    //        <attr name="dividing_name_size" format="dimension"/>
    private float dividingNameSize;

    //        <attr name="drawModle">
//            <enum name="matching" value="0" />
//            <enum name="pass" value="1" />
//        </attr>
    private int drawModle;

    private boolean autoAxisDividing = true;

    public boolean isAutoAxisDividing() {
        return autoAxisDividing;
    }

    public void setAutoAxisDividing(boolean autoAxisDividing) {
        this.autoAxisDividing = autoAxisDividing;
    }

    public boolean isAutoXDividing() {
        return autoXDividing;
    }

    public void setAutoXDividing(boolean autoXDividing) {
        this.autoXDividing = autoXDividing;
    }

    public boolean isAutoY0Dividing() {
        return autoY0Dividing;
    }

    public void setAutoY0Dividing(boolean autoY0Dividing) {
        this.autoY0Dividing = autoY0Dividing;
    }

    public boolean isAutoY1Dividing() {
        return autoY1Dividing;
    }

    public void setAutoY1Dividing(boolean autoY1Dividing) {
        this.autoY1Dividing = autoY1Dividing;
    }

    public boolean isAutoY2Dividing() {
        return autoY2Dividing;
    }

    public void setAutoY2Dividing(boolean autoY2Dividing) {
        this.autoY2Dividing = autoY2Dividing;
    }

    private boolean autoXDividing = true;
    private boolean autoY0Dividing = true;
    private boolean autoY1Dividing = true;
    private boolean autoY2Dividing = true;


    public float getAxisXStart() {
        return axisXStart;
    }

    public void setAxisXStart(float axisXStart) {
        this.axisXStart = axisXStart;
    }

    public float getAxisXEnd() {
        return axisXEnd;
    }

    public void setAxisXEnd(float axisXEnd) {
        this.axisXEnd = axisXEnd;
    }

    public float getAxisY0Start() {
        return axisY0Start;
    }

    public void setAxisY0Start(float axisY0Start) {
        this.axisY0Start = axisY0Start;
    }

    public float getAxisY0End() {
        return axisY0End;
    }

    public void setAxisY0End(float axisY0End) {
        this.axisY0End = axisY0End;
    }

    public float getAxisY1Start() {
        return axisY1Start;
    }

    public void setAxisY1Start(float axisY1Start) {
        this.axisY1Start = axisY1Start;
    }

    public float getAxisY1End() {
        return axisY1End;
    }

    public void setAxisY1End(float axisY1End) {
        this.axisY1End = axisY1End;
    }

    public float getAxisY2Start() {
        return axisY2Start;
    }

    public void setAxisY2Start(float axisY2Start) {
        this.axisY2Start = axisY2Start;
    }

    public float getAxisY2End() {
        return axisY2End;
    }

    public void setAxisY2End(float axisY2End) {
        this.axisY2End = axisY2End;
    }

    public float getAxisY1Y2() {
        return axisY1Y2;
    }

    public void setAxisY1Y2(float axisY1Y2) {
        this.axisY1Y2 = axisY1Y2;
    }

    public int getAxisXColor() {
        return axisXColor;
    }

    public void setAxisXColor(int axisXColor) {
        this.axisXColor = axisXColor;
    }

    public int getAxisY0Color() {
        return axisY0Color;
    }

    public void setAxisY0Color(int axisY0Color) {
        this.axisY0Color = axisY0Color;
    }

    public int getAxisY1Color() {
        return axisY1Color;
    }

    public void setAxisY1Color(int axisY1Color) {
        this.axisY1Color = axisY1Color;
    }

    public int getAxisY2Color() {
        return axisY2Color;
    }

    public void setAxisY2Color(int axisY2Color) {
        this.axisY2Color = axisY2Color;
    }

    public int getAxisY0LineColor() {
        return axisY0LineColor;
    }

    public void setAxisY0LineColor(int axisY0LineColor) {
        this.axisY0LineColor = axisY0LineColor;
    }

    public int getAxisY1LineColor() {
        return axisY1LineColor;
    }

    public void setAxisY1LineColor(int axisY1LineColor) {
        this.axisY1LineColor = axisY1LineColor;
    }

    public int getAxisY2LineColor() {
        return axisY2LineColor;
    }

    public void setAxisY2LineColor(int axisY2LineColor) {
        this.axisY2LineColor = axisY2LineColor;
    }

    public boolean isAxisDividingIn() {
        return axisDividingIn;
    }

    public void setAxisDividingIn(boolean axisDividingIn) {
        this.axisDividingIn = axisDividingIn;
    }

    public boolean isAxisXDividingIn() {
        return axisXDividingIn;
    }

    public void setAxisXDividingIn(boolean axisXDividingIn) {
        this.axisXDividingIn = axisXDividingIn;
    }

    public boolean isAxisYDividingIn() {
        return axisYDividingIn;
    }

    public void setAxisYDividingIn(boolean axisYDividingIn) {
        this.axisYDividingIn = axisYDividingIn;
    }

    public boolean isAxisY0DividingIn() {
        return axisY0DividingIn;
    }

    public void setAxisY0DividingIn(boolean axisY0DividingIn) {
        this.axisY0DividingIn = axisY0DividingIn;
    }

    public boolean isAxisY1DividingIn() {
        return axisY1DividingIn;
    }

    public void setAxisY1DividingIn(boolean axisY1DividingIn) {
        this.axisY1DividingIn = axisY1DividingIn;
    }

    public boolean isAxisY2DividingIn() {
        return axisY2DividingIn;
    }

    public void setAxisY2DividingIn(boolean axisY2DividingIn) {
        this.axisY2DividingIn = axisY2DividingIn;
    }

    public float getDividingLeng() {
        return dividingLeng;
    }

    public void setDividingLeng(float dividingLeng) {
        this.dividingLeng = dividingLeng;
    }

    public float getDividingColor() {
        return dividingColor;
    }

    public void setDividingColor(float dividingColor) {
        this.dividingColor = dividingColor;
    }

    public float getAxisDividingDistance() {
        return axisDividingDistance;
    }

    public void setAxisDividingDistance(float axisDividingDistance) {
        this.axisDividingDistance = axisDividingDistance;
    }

    public float getAxisTextNameSize() {
        return axisTextNameSize;
    }

    public void setAxisTextNameSize(float axisTextNameSize) {
        this.axisTextNameSize = axisTextNameSize;
    }

    public float getDividingNameSize() {
        return dividingNameSize;
    }

    public void setDividingNameSize(float dividingNameSize) {
        this.dividingNameSize = dividingNameSize;
    }

    public int getDrawModle() {
        return drawModle;
    }

    public void setDrawModle(int drawModle) {
        this.drawModle = drawModle;
    }
}
