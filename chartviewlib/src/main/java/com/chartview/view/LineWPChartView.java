package com.chartview.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.chartview.bean.AttrBean;
import com.chartview.chartviewlib.R;
import com.chartview.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

public class LineWPChartView extends View {

    private String TAG = "asd";
    private AttrBean attrBean = new AttrBean();
    private int width;
    private int height;

    private List<Point> y0Data = new ArrayList<>();
    private List<Point> y1Data = new ArrayList<>();
    private List<Point> y2Data = new ArrayList<>();
    private float minX = 100, maxX = 200, minYc = 0, maxYc = 100, minZgl = 0, maxZgl = 100;
    private Paint axisPaint;
    private Paint linePaint;
    private Paint scalePaint;
    private Paint axisNamePaint;
    private Paint pointPaint;
    private String x0Name = "瞬时流量 [m³/h]", y0Name = "扬程 [m]", y1Name = "轴功率 [kW]", y2Name = "水泵效率 [%]";
    private boolean isShowPonit = false; // 是否显示数据点
    private float pointRadius = 1; // 数据点的半径

    // 四条轴线的位置
//    private float xYcZgl, y1Yc, y0Yc, y1Zgl, y0Zgl, xBx, y1Bx, y0Bx, y0Axis;
    private Point y0PoStart = new Point(),
            y0PoStop= new Point(),
            y1PoStart= new Point(),
            y1PoStop= new Point(),
            y2PoStart= new Point(),
            y2PoStop= new Point(),
            xPoStart= new Point(),
            xPoStop= new Point();
    // 曲线边界
    private int padding;
    // 坐标轴名称的位置
    private float y0NameY;
    private float y1NameY;
    private float y2NameY;
    private float axisNameW;


    public LineWPChartView(Context context) {
        super(context);
    }

    public LineWPChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.chart);
        attrBean.setAxisXStart(array.getFloat(R.styleable.chart_axisX_start, 0));
        attrBean.setAxisXEnd(array.getFloat(R.styleable.chart_axisX_end, 100));
        attrBean.setAxisY0Start(array.getFloat(R.styleable.chart_axisY0_start, 0));
        attrBean.setAxisY0End(array.getFloat(R.styleable.chart_axisY0_end, 100));
        attrBean.setAxisY1Start(array.getFloat(R.styleable.chart_axisY1_start, 0));
        attrBean.setAxisY1End(array.getFloat(R.styleable.chart_axisY1_end, 100));
        attrBean.setAxisY2Start(array.getFloat(R.styleable.chart_axisY2_start, 0));
        attrBean.setAxisY2End(array.getFloat(R.styleable.chart_axisY2_end, 100));
        attrBean.setAxisY1Y2(array.getFloat(R.styleable.chart_axisY1_Y2, 5));
        attrBean.setAxisXColor(array.getColor(R.styleable.chart_axisX_color, 0xDE000000));
        attrBean.setAxisY0Color(array.getColor(R.styleable.chart_axisY0_color, 0xDE000000));
        attrBean.setAxisY1Color(array.getColor(R.styleable.chart_axisY1_color, 0xDE000000));
        attrBean.setAxisY2Color(array.getColor(R.styleable.chart_axisY2_color, 0xDE000000));
        attrBean.setAxisY0LineColor(array.getColor(R.styleable.chart_axisY0_line_color, 0xDE000000));
        attrBean.setAxisY1LineColor(array.getColor(R.styleable.chart_axisY1_line_color, 0xDE000000));
        attrBean.setAxisY2LineColor(array.getColor(R.styleable.chart_axisY2_line_color, 0xDE000000));
        attrBean.setAxisDividingIn(array.getBoolean(R.styleable.chart_axis_dividing_in, true));
        attrBean.setAxisXDividingIn(array.getBoolean(R.styleable.chart_axisX_dividing_in, true));
        attrBean.setAxisYDividingIn(array.getBoolean(R.styleable.chart_axisY_dividing_in, true));
        attrBean.setAxisY0DividingIn(array.getBoolean(R.styleable.chart_axisY0_dividing_in, true));
        attrBean.setAxisY1DividingIn(array.getBoolean(R.styleable.chart_axisY1_dividing_in, true));
        attrBean.setAxisY2DividingIn(array.getBoolean(R.styleable.chart_axisY2_dividing_in, true));
        attrBean.setDividingLeng(array.getFloat(R.styleable.chart_dividing_length, 5));
        attrBean.setDividingColor(array.getColor(R.styleable.chart_dividing_color, 0xDE000000));
        attrBean.setAxisDividingDistance(array.getFloat(R.styleable.chart_axis_dividing_distance, 5));
        attrBean.setAxisTextNameSize(array.getDimension(R.styleable.chart_axis_textName_size, 14));
        attrBean.setDividingNameSize(array.getDimension(R.styleable.chart_dividing_name_size, 14));
        attrBean.setAutoAxisDividing(array.getBoolean(R.styleable.chart_autoAxisDividing, true));
        attrBean.setAutoXDividing(array.getBoolean(R.styleable.chart_autoXDividing, true));
        attrBean.setAutoY0Dividing(array.getBoolean(R.styleable.chart_autoY0Dividing, true));
        attrBean.setAutoY1Dividing(array.getBoolean(R.styleable.chart_autoY1Dividing, true));
        attrBean.setAutoY2Dividing(array.getBoolean(R.styleable.chart_autoY2Dividing, true));
        // 初始化画笔
        initPaint();
    }

    public LineWPChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthNormal = 150;
        int heightNormal = 150;
        width = DensityUtil.getDefaultSize(widthNormal, widthMeasureSpec);
        height = DensityUtil.getDefaultSize(heightNormal, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 计算元素的位置
        getAxisPostion(axisNamePaint);

        // X 轴名称的宽度
        float x0NameLen = calculateTxt(axisNamePaint, x0Name);
        // 参数分别为 (文本 基线x 基线y 画笔)

        axisNamePaint.setColor(Color.BLACK);
        canvas.drawText(x0Name, (width / 2 - x0NameLen / 2), height - 5, axisNamePaint);
        // 绘制扬程Y轴名称
        axisNamePaint.setColor(Color.GREEN);
        drawText(canvas, y0Name, padding, y0NameY, axisNamePaint, -90);
        axisNamePaint.setColor(Color.BLUE);
        drawText(canvas, y1Name, padding, y1NameY, axisNamePaint, -90);
        axisNamePaint.setColor(Color.RED);
        drawText(canvas, y2Name, (width - padding), y2NameY, axisNamePaint, 90);

        // 绘制Y0
        axisPaint.setColor(Color.GREEN);
        canvas.drawLine(y0PoStart.x, y0PoStart.y, y0PoStop.x, y0PoStop.y, axisPaint);
        scalePaint.setColor(Color.GREEN);
        drawYAxisTag(canvas,y0PoStart,y0PoStop,scalePaint,5,true,(int) maxYc,(int)minYc);
        //绘制Y1
        axisPaint.setColor(Color.BLUE);
        canvas.drawLine(y1PoStart.x, y1PoStart.y, y1PoStop.x, y1PoStop.y + 5, axisPaint);
        scalePaint.setColor(Color.BLUE);
        drawYAxisTag(canvas,y1PoStart,y1PoStop,scalePaint,5,true,(int) maxZgl,(int)minZgl);
        //绘制Y2
        axisPaint.setColor(Color.RED);
        canvas.drawLine(y2PoStart.x, y2PoStart.y, y2PoStop.x, y2PoStop.y + 5, axisPaint);
        scalePaint.setColor(Color.RED);
        drawYAxisTag(canvas,y2PoStart,y2PoStop,scalePaint,10,false,100,0);
        //绘制X轴
        axisPaint.setColor(Color.BLACK);
        canvas.drawLine(xPoStart.x - 5, xPoStart.y, xPoStop.x + 5, xPoStop.y, axisPaint);
        scalePaint.setColor(Color.BLACK);
        drawXaxisTag(canvas,xPoStart,xPoStop,scalePaint,10,maxX,minX);
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {

        //坐标轴
        axisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        axisPaint.setStyle(Paint.Style.STROKE);
        axisPaint.setStrokeWidth(1);
        axisPaint.setColor(Color.BLACK);

        //曲线
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setColor(Color.BLACK);

        //刻度
        scalePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        scalePaint.setStyle(Paint.Style.STROKE);
        scalePaint.setColor(Color.BLACK);
        scalePaint.setTypeface(Typeface.SERIF);

        //坐标轴名称
        axisNamePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        axisNamePaint.setStyle(Paint.Style.STROKE);
        axisNamePaint.setAntiAlias(true);
        axisNamePaint.setTextSize(14);
        scalePaint.setTypeface(Typeface.SERIF);
        axisNamePaint.setColor(Color.BLACK);

        //坐标点
        pointPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pointPaint.setStyle(Paint.Style.STROKE);
        pointPaint.setColor(Color.BLACK);
    }

    private void drawText(Canvas canvas, String text, float x, float y, Paint paint, float angle) {
        if (angle != 0) {
            canvas.rotate(angle, x, y);
        }
        canvas.drawText(text, x, y, paint);
        if (angle != 0) {
            canvas.rotate(-angle, x, y);
        }
    }


    // 设置Y0 轴的点集
    public LineWPChartView setY0Data(List<Point> pointBeans) {
        y0Data.clear();
        y0Data.addAll(pointBeans);
        getMinMax();
        return this;
    }

    // 设置Y1轴的点集
    public LineWPChartView setY1Data(List<Point> pointBeans) {
        y1Data.clear();
        y1Data.addAll(pointBeans);
        getMinMax();
        invalidate();
        return this;
    }

    /* 设置Y2轴的点集*/
    public LineWPChartView setY2Data(List<Point> pointBeans) {
        y2Data.clear();
        y2Data.addAll(pointBeans);
        getMinMax();
        invalidate();
        return this;
    }

    /*设置X轴的名称*/
    public LineWPChartView setXName(String name) {
        x0Name = name;
        return this;
    }

    /*设置Y0轴的名称*/
    public LineWPChartView setY0Name(String mame) {
        y0Name = mame;
        return this;
    }

    /*设置Y1轴的名称*/
    public LineWPChartView setY1Name(String name) {
        y1Name = name;
        return this;
    }

    /*设置Y2轴的名称*/
    public LineWPChartView setY2Name(String name) {
        y2Name = name;
        return this;
    }

    /*设置是否显示数据点*/
    public LineWPChartView setShowPoint(Boolean showPoint) {
        this.isShowPonit = showPoint;
        return this;
    }

    /*数据点的半径*/
    public LineWPChartView setPointRadius(float pointRadius) {
        this.pointRadius = pointRadius;
        return this;
    }


    /*初始化曲线*/
    public void commite() {
        invalidate();
    }

    /**
     * 获取X轴\Y轴的最大、最小值
     */
    private void getMinMax() {

        for (Point po : y0Data) {
            minX = minX < po.x ? minX : po.x;
            maxX = maxX > po.x ? maxX : po.x;
        }
        //  扬程
        for (Point po : y1Data) {
            minX = minX < po.x ? minX : po.x;
            maxX = maxX > po.x ? maxX : po.x;
            minYc = minYc < po.y ? minYc : po.y;
            maxYc = maxYc > po.y ? maxYc : po.y;
        }

        // 轴功率
        for (Point po : y2Data) {
            minX = minX < po.x ? minX : po.x;
            maxX = maxX > po.x ? maxX : po.x;
            minZgl = minZgl < po.y ? minZgl : po.y;
            maxZgl = maxZgl > po.y ? maxZgl : po.y;
        }

        if (minX == maxX) maxX += 10;
        if (minYc == maxYc) maxYc += 100;
        if (minZgl == maxZgl) maxZgl += 100;

        minX = minX - minX % 10;
        maxX = maxX - maxX % 10 + 10;

        minZgl = minZgl - minZgl % 10;
        maxZgl = maxZgl - maxZgl % 10 + 10;

        minYc = minYc - minYc % 10;
        maxYc = maxYc - maxYc % 10 + 10;

    }


    /*计算各个坐标轴的位置*/

    private void getAxisPostion(Paint axisNamePaint) {

        padding = 20;

        //得出最大Y轴刻度，用于计算刻度的最大宽度
        int maxY = 0;
        maxY = (int) (maxYc > maxZgl ? maxYc : maxZgl);
        maxY = maxY > 100 ? maxY : 100;
        // 刻度标记最大宽度
        float maxYTagSize = axisNamePaint.measureText(maxY + "");
        // 一个汉字的高度
        axisNameW = axisNamePaint.measureText("轴");
        // 名称和刻度之间的距离
        float nameToTag = 5;
        //泵效Y轴的高度
        float yMax = height - nameToTag - axisNameW - axisNameW - padding - padding;

        // 轴功率、扬程 位置
        // 扬程的起点：（xYcZgl ， y1Yc）   末点：（xYcZgl ，y0Yc）
        // 轴功率的起点: (xYcZgl , y1Zgl)  末点： （xYcZgl , y0Zgl）
        // 泵效的起点：(xBx , y1Bx)   末点:（xBx , y0Bx）
        // X轴的起点： (xYcZgl,y0Axis)   末点 ：(xBx,y0Axis)
        float xYcZgl = padding + axisNameW + nameToTag + maxYTagSize;
        float y1Yc = padding;
        float y0Yc = yMax * 0.45f + padding;
        float y1Zgl = yMax * 0.55f + padding;
        float y0Zgl = yMax + padding;
        float xBx = width - padding - nameToTag - axisNameW - maxYTagSize;
        float y1Bx = padding;
        float y0Bx = yMax + padding;
        float y0Axis = yMax + padding;

        y0PoStart.set((int) xYcZgl, (int) y1Yc);
        y0PoStop.set((int) xYcZgl, (int) y0Yc);
        y1PoStart.set((int)xYcZgl ,(int) y1Zgl);
        y1PoStop.set((int)xYcZgl , (int)y0Zgl);
        y2PoStart.set((int)xBx , (int)y1Bx);
        y2PoStop.set((int)xBx , (int)y0Bx);
        xPoStart.set((int)xYcZgl,(int)y0Axis);
        xPoStop.set((int)xBx,(int)y0Axis);


        //Y0 坐标轴名称的位置
        y0NameY = yMax * 0.4f / 2 + axisNamePaint.measureText(y0Name) / 2 + padding;

        //Y1 坐标轴名称的位置
        y1NameY = yMax * 0.5f + padding + yMax * 0.2f + axisNamePaint.measureText(y1Name) / 2;

        //Y2 坐标轴的位置
        y2NameY = yMax * 0.5f + padding - axisNamePaint.measureText(y2Name) / 2;
    }


    /**
     * 绘制Y刻度
     * @param startPoint
     * @param stopPoint
     * @param scalePaint
     * @param isLeft
     */
    private void drawYAxisTag(Canvas canvas , Point startPoint, Point stopPoint, Paint scalePaint , int number , boolean isLeft , int maxValue , int minValue) {
        float step = (stopPoint.y - startPoint.y) /number;
        float stepValue = (maxValue - minValue)/number;
        int indext = 0;
        for (int i = (startPoint.y+1) ; i < stopPoint.y ; i+=step) {
            canvas.drawLine(startPoint.x-(isLeft ? 5 :-5),i,startPoint.x,i,scalePaint);
            float txtLen = scalePaint.measureText((maxValue - indext * stepValue) + "");
            canvas.drawText((int)(maxValue - indext * stepValue) + "",(isLeft ? (startPoint.x - txtLen): (startPoint.x + 10)) ,i,scalePaint);
            indext += 1;
        }
    }

    /**
     * 绘制X刻度
     * @param canvas
     * @param xPoStart
     * @param xPoStop
     * @param maxX
     * @param minX
     */
    private void drawXaxisTag(Canvas canvas , Point xPoStart , Point xPoStop , Paint scalePaint  ,int number ,float maxX , float minX ){

        float step = (xPoStop.x - xPoStart.x) / number;
        float stepValue = (maxX - minX) / number;
        int index = 0;
        for (int i = (xPoStart.x + 1) ; i < xPoStop.x ; i+=step) {
            canvas.drawLine(i-1,xPoStart.y,i ,xPoStart.y+5,scalePaint);
            float txtLen = scalePaint.measureText(minX + stepValue * index + "");
            canvas.drawText((int)(minX + stepValue * index) +"" , i-txtLen/2,xPoStart.y+10 + axisNameW,scalePaint);
            index+=1;
        }
    }


    /**
     * 计算文字的长度
     * @param paint
     * @param txt
     * @return
     */
    private float calculateTxt(Paint paint, String txt) {
        float lenTxt = paint.measureText(txt);
        return lenTxt;
    }




    
    private void drawY0Line(){



    }


}
