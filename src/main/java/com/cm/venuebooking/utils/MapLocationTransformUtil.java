package com.cm.venuebooking.utils;

import com.cm.common.utils.point.Point;

/**
 * 地图(腾讯、百度)定位坐标转换工具类
 * @author xwangs
 * @create 2020-06-22 16:35
 * @description
 */
public class MapLocationTransformUtil {

    /** 坐标转换，腾讯地图转换成百度地图坐标
     * @param point 腾讯纬度
     * @return 返回结果：Point经度,纬度
     */
    public Point map_tx2bd(Point point){
        double bd_lat;
        double bd_lon;
        double x_pi=3.14159265358979324;
        double x = point.getY(), y = point.getX();
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        bd_lat = z * Math.sin(theta) + 0.006;
        bd_lon = z * Math.cos(theta) + 0.0065;
        point.setX(bd_lat);
        point.setY(bd_lon);
        return point;
    }

    /**
     * 坐标转换，百度地图坐标转换成腾讯地图坐标
     * @param point  百度坐标经纬度
     * @return 返回结果：Point经度,纬度
     */
    public Point map_bd2tx(Point point) {
        double tx_lat;
        double tx_lon;
        double x_pi = 3.14159265358979324;
        double x = point.getY() - 0.0065, y = point.getX() - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
        tx_lat = z * Math.sin(theta);
        tx_lon = z * Math.cos(theta);
        point.setX(tx_lat);
        point.setY(tx_lon);
        return point;
    }

}
