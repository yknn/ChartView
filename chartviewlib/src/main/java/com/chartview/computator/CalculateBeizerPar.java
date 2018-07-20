package com.chartview.computator;


import android.graphics.Point;

import com.chartview.bean.BeizerBean;
import com.chartview.bean.PointBean;

import java.util.ArrayList;
import java.util.List;

/*
 * create at 2018/7/13
 * description:计算三阶贝塞尔曲线的参数
 * 实现原理: https://wenku.baidu.com/view/19682071f242336c1eb95e47.html
 */
public class CalculateBeizerPar {

    /**
     * 获取绘制三阶贝塞尔曲线所需要的参数（两个控制点、两个数据点）
     *
     * @param pointBeans 坐标点的集合
     * @return
     */
    public static List<BeizerBean> getPar(List<Point> pointBeans) {
        return getPar(pointBeans, 0.25f);
    }


    /**
     * @param pointBeans 坐标点集合
     * @param slope
     * @return
     */
    public static List<BeizerBean> getPar(List<Point> pointBeans, float slope) {
        List<BeizerBean> beizerBeans = new ArrayList<>();
        if (pointBeans.size() <= 2) {
            return null;
        }

        if (pointBeans.size() >= 3) {

            for (int i = 0; i < (pointBeans.size()-1); i++) {
                BeizerBean beizerBean = new BeizerBean();
                //控制点A
                PointBean aControl ;
                //控制点B
                PointBean bControl ;
                if (i == 0){
                    aControl = getControlPointA(pointBeans.get(0),pointBeans.get(0),pointBeans.get(1),slope);
                    bControl = getControlPointB(pointBeans.get(0),pointBeans.get(1),pointBeans.get(2),slope);
                    beizerBean.setStartPoint(pointBeans.get(i));
                    beizerBean.setEndPoint(pointBeans.get(i+1));
                    beizerBeans.add(beizerBean);
                    continue;
                }

                if (i == (pointBeans.size()-2)){
                    aControl = getControlPointA(pointBeans.get(pointBeans.size()-2),pointBeans.get(pointBeans.size()-3),pointBeans.get(pointBeans.size()-1),slope);
                    bControl = getControlPointB(pointBeans.get(pointBeans.size()-2),pointBeans.get(pointBeans.size()-1),pointBeans.get(pointBeans.size()-1),slope);
                    beizerBean.setStartPoint(pointBeans.get(i));
                    beizerBean.setEndPoint(pointBeans.get(i+1));
                    beizerBeans.add(beizerBean);
                    continue;
                }

                aControl = getControlPointA(pointBeans.get(i),pointBeans.get(i-1),pointBeans.get(i+1),slope);
                bControl = getControlPointB(pointBeans.get(i),pointBeans.get(i +1),pointBeans.get(i+2),slope);
                beizerBean.setStartPoint(pointBeans.get(i));
                beizerBean.setEndPoint(pointBeans.get(i+1));
                beizerBeans.add(beizerBean);
            }
        }

        return beizerBeans;
    }


    /**
     * 计算控制点 A
     *
     * @param thisPoint 当前数据点
     * @param lastPoint 上一个点
     * @param nextPoint 下一个点
     * @return
     */
    public static PointBean getControlPointA(PointBean thisPoint, PointBean lastPoint, PointBean nextPoint, float slope) {
        float x = thisPoint.getX() + slope * (nextPoint.getX() - lastPoint.getX());
        float y = thisPoint.getY() + slope * (nextPoint.getY() - lastPoint.getY());
        return new PointBean(x, y);
    }


    /**
     * 计算控制点B
     *
     * @param thisPoint
     * @param nextPoint
     * @param nextTwoPoint
     * @param slope
     * @return
     */
    public static PointBean getControlPointB(PointBean thisPoint, PointBean nextPoint, PointBean nextTwoPoint, float slope) {
        float x = nextPoint.getX() - slope * (nextTwoPoint.getX() - thisPoint.getX());
        float y = nextPoint.getY() - slope * (nextTwoPoint.getY() - thisPoint.getY());
        return new PointBean(x, y);
    }


}
